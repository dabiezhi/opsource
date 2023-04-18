package com.only4play.flow.infrastructure.liteflow.parser;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @author tsy
 * Created by on 2023-04-18 10:15 AM
 */
@Data
public class NodeData {

    private JSONObject params;

    public static NodeData getInstance(JSONObject params) {
        NodeData nodeData = new NodeData();
        nodeData.setParams(params);
        return nodeData;
    }
}