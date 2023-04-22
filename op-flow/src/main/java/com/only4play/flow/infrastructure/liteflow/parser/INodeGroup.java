package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author tsy
 * Created by on 2023-04-18 10:16 AM
 */
@Data
public class INodeGroup {
    private List<INode> nodes;

    public static INodeGroup getInstance() {
        INodeGroup flow = new INodeGroup();
        flow.setNodes(new ArrayList<>());
        return flow;
    }
}