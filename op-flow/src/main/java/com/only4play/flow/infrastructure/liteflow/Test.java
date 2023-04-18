package com.only4play.flow.infrastructure.liteflow;

import com.only4play.flow.infrastructure.liteflow.parser.Flow;
import com.only4play.flow.infrastructure.liteflow.parser.FlowParser;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;

/**
 * @author tsy
 * Created by on 2023-04-18 10:25 AM
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource(
                "dag1.json");
        String rule = IoUtil.readUtf8(classPathResource.getStream());
        FlowParser parser = new FlowParser();
        Flow flow = parser.parseFlow(rule);
        String el = parser.genEL();
        System.out.println(el);
    }
}