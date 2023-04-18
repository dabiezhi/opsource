package com.only4play.flow.infrastructure.liteflow.parser;

import java.util.ArrayList;
import java.util.List;

import com.only4play.flow.infrastructure.liteflow.emums.NodeKind;

import lombok.Data;

/**
 * @author curry
 * Created by on 2023-04-18 10:15 AM
 */
@Data
public class Node {

    private String id;
    private String name;
    private NodeKind kind;
    private String compId;
    private NodeData data;
    private List<NodeGroup> groups = new ArrayList<>();
}