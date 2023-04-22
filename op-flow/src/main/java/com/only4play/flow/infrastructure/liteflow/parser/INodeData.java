package com.only4play.flow.infrastructure.liteflow.parser;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

/**
 * @author tsy
 * Created by on 2023-04-18 10:15 AM
 */
@Data
public class INodeData {

    private String params;
    private String payload;

    public static INodeData getInstance(String params, String payload) {
        INodeData nodeData = new INodeData();
        nodeData.setParams(params);
        nodeData.setPayload(payload);
        return nodeData;
    }

}