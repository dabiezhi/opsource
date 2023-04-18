package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.only4play.flow.infrastructure.liteflow.emums.NodeKind;

/**
 * @author tsy
 * Created by on 2023-04-18 10:14 AM
 */
public class FlowParser {

    private final LinkedHashMap<String, List<Node>> nodeNextMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, List<Node>> nodePreMap = new LinkedHashMap<>();
    private final LinkedHashMap<String, Integer> flowToNodeCounter = new LinkedHashMap<>();
    private final LinkedHashMap<String, NodeGroup> nodeGroupMap = new LinkedHashMap<>();
    private final Flow flow = Flow.getInstance();
    private final List<String> cmpDataList = new ArrayList<>();

    public FlowParser of() {
        return new FlowParser();
    }

    public Flow parseFlow(String config) {
        JSONObject configJson = JSONObject.parseObject(config);
        JSONArray cells = configJson.getJSONArray("cells");
        List<JSONObject> edges = new ArrayList<>();
        LinkedHashMap<String, Node> nodeMap = new LinkedHashMap<>();
        Node startNode = null;
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
        return flow;
    }

    public String genEL() throws Exception {
        StringBuilder bld = new StringBuilder("");
        String el = this.genThenEL(flow.getNodes());
        for (String cmpData : cmpDataList) {
            bld.append(cmpData);
            bld.append("\n");
        }
        bld.append(el);
        return bld.toString();
    }

    private String genNodeEL(Node node) throws Exception {
        StringBuilder bld = new StringBuilder("");
        if (node.getData() == null || node.getData().getParams() == null) {
            bld.append(node.getCompId());
        } else {
            String cpmDataName = "cmpData" + (cmpDataList.size() + 1);
            if (NodeKind.IFNODE == node.getKind()) {
                bld.append("IF(" + node.getCompId() + ".tag(\"" + node.getId() + "\")" + ".data(" + cpmDataName + ")");
                JSONObject params = node.getData().getParams();
                String trueNode = params.getJSONObject("trueNode").getString("value");
                String falseNode = params.getJSONObject("falseNode").getString("value");
                List<NodeGroup> trueNodeGroup = node.getGroups().stream().filter(group -> group.getNodes()
                        .stream()
                        .filter(groupNode -> groupNode.getId().equals(trueNode))
                        .collect(Collectors.toList())
                        .size() > 0).collect(Collectors.toList());
                List<NodeGroup> falseNodeGroup = node.getGroups().stream().filter(group -> group.getNodes()
                        .stream()
                        .filter(groupNode -> groupNode.getId().equals(falseNode))
                        .collect(Collectors.toList())
                        .size() > 0).collect(Collectors.toList());
                if (trueNodeGroup.size() > 0) {
                    bld.append(",");
                    for (NodeGroup g : trueNodeGroup) {
                        if (node.getGroups().indexOf(g) > 0) {
                            bld.append(",");
                        }
                        bld.append(this.genThenEL(g.getNodes()));
                    }
                }
                if (falseNodeGroup.size() > 0) {
                    for (NodeGroup g : falseNodeGroup) {
                        if (node.getGroups().indexOf(g) > 0) {
                            bld.append(",");
                        }
                        bld.append(this.genThenEL(g.getNodes()));
                    }
                }
                bld.append(")");
            } else {
                bld.append(node.getCompId() + ".tag(\"" + node.getId() + "\")" + ".data(" + cpmDataName + ")");
                if (node.getGroups().size() == 1) {
                    bld.append(",");
                    bld.append(this.genThenEL(node.getGroups().get(0).getNodes()));
                } else if (node.getGroups().size() > 1) {
                    bld.append(",WHEN(");
                    for (NodeGroup g : node.getGroups()) {
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

    private String genThenEL(List<Node> nodes) throws Exception {
        StringBuilder bld = new StringBuilder("");
        bld.append("THEN(");
        for (Node gNode : nodes) {
            String gNodeEL = this.genNodeEL(gNode);
            if (nodes.indexOf(gNode) > 0) {
                bld.append(",");
            }
            bld.append(gNodeEL);
        }
        bld.append(")");
        return bld.toString();
    }


    private Node createNode(JSONObject cell) {
        JSONObject data = cell.getJSONObject("data");
        String shape = cell.getString("shape");
        Node node = new Node();
        node.setId(cell.getString("id"));
        node.setCompId(data.getString("compId"));
        node.setName(data.getString("name"));
        node.setKind(NodeKind.getIns(shape));
        node.setData(NodeData.getInstance(data.getJSONObject("params")));
        return node;
    }

    private void initNode(Node node, NodeGroup parentGroup) {
        List<Node> nextNodes = nodeNextMap.get(node.getId());
        List<Node> preNodes = nodePreMap.get(node.getId());

        NodeGroup realNodeGroup = parentGroup;
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
            NodeGroup grp = getNodeGroup(nextNodes.get(0));
            this.initNode(nextNodes.get(0), grp);
        } else {
            this.nodeGroupMap.put(node.getId(), parentGroup);
            for (Node nextNode : nextNodes) {
                NodeGroup group = NodeGroup.getInstance();
                this.initNode(nextNode, group);
                if (group.getNodes().size() > 0) {
                    node.getGroups().add(group);
                }

            }
        }
    }

    private NodeGroup getNodeGroup(Node node) {
        NodeGroup group = null;
        List<List<String>> flowLines = new ArrayList<>();
        List<Node> preNodes = nodePreMap.get(node.getId());
        if (preNodes == null || preNodes.size() == 0) {
            return null;
        }
        for (Node preNode : preNodes) {
            flowLines.add(this.getPreFlowLine(preNode));
        }
        String crossNodeId = this.getCrossNodeId(flowLines);
        group = this.nodeGroupMap.get(crossNodeId);
        return group;
    }

    private List<String> getPreFlowLine(Node node) {
        List<String> flowLine = new ArrayList<String>();
        flowLine.add(node.getId());
        List<Node> preNodes = this.nodePreMap.get(node.getId());
        if (preNodes == null || preNodes.size() == 0) {
            return flowLine;
        }
        for (Node preNode : preNodes) {
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