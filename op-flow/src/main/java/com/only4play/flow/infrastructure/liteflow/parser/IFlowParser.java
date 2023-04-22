package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.only4play.flow.infrastructure.liteflow.emums.NodeKind;

/**
 * @author tsy
 * Created by on 2023-04-18 10:14 AM
 */
public class IFlowParser {

    public final LinkedHashMap<String, List<INode>> nodeNextMap       = new LinkedHashMap<>();
    public final LinkedHashMap<String, List<INode>> nodePreMap        = new LinkedHashMap<>();
    public final LinkedHashMap<String, Integer>     flowToNodeCounter = new LinkedHashMap<>();
    public final LinkedHashMap<String, INodeGroup>  nodeGroupMap      = new LinkedHashMap<>();

    public final IFlow                              flow              = IFlow.getInstance();

    public static IFlowParser of1(String config) {
        return new IFlowParser().parseFlow(config);
    }

    public IFlowParser parseFlow(String config) {
        JSONObject configJson = JSONObject.parseObject(config);
        JSONArray cells = configJson.getJSONArray("cells");
        List<JSONObject> edges = new ArrayList<>();
        LinkedHashMap<String, INode> nodeMap = new LinkedHashMap<>();
        INode startNode = null;
        for (int i = 0; i < cells.size(); i++) {
            JSONObject cell = cells.getJSONObject(i);
            String id = cell.getString("id");
            String shape = cell.getString("shape");
            if (shape.equals("start")) {
                startNode = this.createNode(cell);
                nodeMap.put(id, startNode);
            } else if (shape.equals("edge")) {
                edges.add(cell);
            } else {
                nodeMap.put(id, this.createNode(cell));
            }
        }

        for (JSONObject edge : edges) {
            String source = edge.getJSONObject("source").getString("cell");
            String target = edge.getJSONObject("target").getString("cell");
            if (!nodeNextMap.containsKey(source)) {
                nodeNextMap.put(source, new ArrayList<>());
            }
            nodeNextMap.get(source).add(nodeMap.get(target));

            if (!nodePreMap.containsKey(target)) {
                nodePreMap.put(target, new ArrayList<>());
            }
            nodePreMap.get(target).add(nodeMap.get(source));
        }

        if (startNode != null) {
            this.initNode(startNode, null);
        }
        return this;
    }

    public String genEL() {
        StringBuilder bld = new StringBuilder("");
        String el = this.genThenEL(flow.getNodes());
        bld.append(el);
        return bld.toString();
    }

    private String genNodeEL(INode node) {
        StringBuilder bld = new StringBuilder("");
        if (node.getData() == null || node.getData().getParams() == null) {
            bld.append(node.getCompId());
        } else {
            if (NodeKind.IFNODE == node.getKind()) {
                bld.append("IF(" + node.getCompId() + ".tag(\"" + node.getId() + "\")");
                JSONObject params = JSON.parseObject(node.getData().getParams());
                String trueNode = params.getString("trueNode");
                String falseNode = params.getString("falseNode");
                List<INodeGroup> trueNodeGroup = node.getGroups().stream()
                    .filter(group -> group.getNodes().stream()
                        .filter(groupNode -> groupNode.getId().equals(trueNode))
                        .collect(Collectors.toList()).size() > 0)
                    .collect(Collectors.toList());
                List<INodeGroup> falseNodeGroup = node.getGroups().stream()
                    .filter(group -> group.getNodes().stream()
                        .filter(groupNode -> groupNode.getId().equals(falseNode))
                        .collect(Collectors.toList()).size() > 0)
                    .collect(Collectors.toList());
                if (trueNodeGroup.size() > 0) {
                    bld.append(",");
                    for (INodeGroup g : trueNodeGroup) {
                        if (node.getGroups().indexOf(g) > 0) {
                            bld.append(",");
                        }
                        bld.append(this.genThenEL(g.getNodes()));
                    }
                }
                if (falseNodeGroup.size() > 0) {
                    for (INodeGroup g : falseNodeGroup) {
                        if (node.getGroups().indexOf(g) > 0) {
                            bld.append(",");
                        }
                        bld.append(this.genThenEL(g.getNodes()));
                    }
                }
                bld.append(")");
            } else {
                bld.append(node.getCompId() + ".tag(\"" + node.getId() + "\")");
                if (node.getGroups().size() == 1) {
                    bld.append(",");
                    bld.append(this.genThenEL(node.getGroups().get(0).getNodes()));
                } else if (node.getGroups().size() > 1) {
                    bld.append(",WHEN(");
                    for (INodeGroup g : node.getGroups()) {
                        if (node.getGroups().indexOf(g) > 0) {
                            bld.append(",");
                        }
                        bld.append(this.genThenEL(g.getNodes()));
                    }
                    bld.append(")");
                }
            }
        }
        return bld.toString();
    }

    private String genThenEL(List<INode> nodes) {
        StringBuilder bld = new StringBuilder("");
        bld.append("THEN(");
        for (INode gNode : nodes) {
            String gNodeEL = this.genNodeEL(gNode);
            if (nodes.indexOf(gNode) > 0) {
                bld.append(",");
            }
            bld.append(gNodeEL);
        }
        bld.append(")");
        return bld.toString();
    }

    private INode createNode(JSONObject cell) {
        JSONObject data = cell.getJSONObject("data");
        String shape = cell.getString("shape");
        INode node = new INode();
        node.setId(cell.getString("id"));
        node.setCompId(data.getString("compId"));
        node.setName(data.getString("name"));
        node.setKind(NodeKind.getIns(shape));
        node.setData(INodeData.getInstance(data.getString("params"), data.getString("payload")));
        return node;
    }

    private void initNode(INode node, INodeGroup parentGroup) {
        List<INode> nextNodes = nodeNextMap.get(node.getId());
        List<INode> preNodes = nodePreMap.get(node.getId());

        INodeGroup realNodeGroup = parentGroup;
        if (preNodes != null && preNodes.size() > 1) {
            if (!flowToNodeCounter.containsKey(node.getId())) {
                flowToNodeCounter.put(node.getId(), 0);
            }
            flowToNodeCounter.put(node.getId(), flowToNodeCounter.get(node.getId()).intValue() + 1);
            if (flowToNodeCounter.get(node.getId()).intValue() < preNodes.size()) {
                return;
            } else {
                realNodeGroup = getNodeGroup(node);
            }
        }

        if (realNodeGroup == null) {
            flow.getNodes().add(node);
        } else {
            realNodeGroup.getNodes().add(node);
            this.nodeGroupMap.put(node.getId(), realNodeGroup);
        }

        if (nextNodes == null) {
            return;
        }
        if (nextNodes.size() == 1) {
            INodeGroup grp = getNodeGroup(nextNodes.get(0));
            this.initNode(nextNodes.get(0), grp);
        } else {
            this.nodeGroupMap.put(node.getId(), parentGroup);
            for (INode nextNode : nextNodes) {
                INodeGroup group = INodeGroup.getInstance();
                this.initNode(nextNode, group);
                if (group.getNodes().size() > 0) {
                    node.getGroups().add(group);
                }

            }
        }
    }

    private INodeGroup getNodeGroup(INode node) {
        INodeGroup group = null;
        List<List<String>> flowLines = new ArrayList<>();
        List<INode> preNodes = nodePreMap.get(node.getId());
        if (preNodes == null || preNodes.size() == 0) {
            return null;
        }
        for (INode preNode : preNodes) {
            flowLines.add(this.getPreFlowLine(preNode));
        }
        String crossNodeId = this.getCrossNodeId(flowLines);
        group = this.nodeGroupMap.get(crossNodeId);
        return group;
    }

    private List<String> getPreFlowLine(INode node) {
        List<String> flowLine = new ArrayList<String>();
        flowLine.add(node.getId());
        List<INode> preNodes = this.nodePreMap.get(node.getId());
        if (preNodes == null || preNodes.size() == 0) {
            return flowLine;
        }
        for (INode preNode : preNodes) {
            flowLine.addAll(this.getPreFlowLine(preNode));
        }
        return flowLine;
    }

    private String getCrossNodeId(List<List<String>> flowLines) {
        String result = null;
        for (String item : flowLines.get(0)) {
            boolean bHasAll = true;
            for (int i = 1; i < flowLines.size(); i++) {
                bHasAll = bHasAll && flowLines.get(i).contains(item);
            }
            if (bHasAll) {
                result = item;
                break;
            }
        }
        return result;
    }
}