package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author tsy
 * Created by on 2023-04-18 10:15 AM
 */
@Data
public class IFlow {

    private List<INode> nodes;

    public static IFlow getInstance() {
        IFlow flow = new IFlow();
        flow.setNodes(new ArrayList<>());
        return flow;
    }
}