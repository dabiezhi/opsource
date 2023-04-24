package com.only4play.flow.infrastructure.liteflow.cmp;

import java.util.Arrays;
import java.util.Base64;

import com.alibaba.fastjson.JSONObject;
import com.only4play.flow.infrastructure.liteflow.parser.INodeData;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;

/**
 * @author tsy
 * Created by on 2023-04-24 11:36 AM
 */
@LiteflowComponent("start")
public class StartCmp extends NodeComponent {

    @Override
    public void process() {
        String cmpData = this.getCmpData(String.class);
        System.out.println(cmpData);
        byte[] decode = Base64.getDecoder().decode(cmpData.getBytes());
        System.out.println(new String(decode));
        INodeData iNodeData = JSONObject.parseObject(new String(decode),INodeData.class);
        System.out.println(this.getTag());
    }
}