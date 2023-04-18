package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author tsy
 * Created by on 2023-04-18 10:16 AM
 */
@Data
public class NodeGroup {
    private List<Node> nodes;

    public static NodeGroup getInstance() {
        NodeGroup flow = new NodeGroup();
        flow.setNodes(new ArrayList<>());
        return flow;
    }
}