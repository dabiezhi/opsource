package com.only4play.flow.infrastructure.liteflow;

import com.only4play.flow.infrastructure.liteflow.parser.IFlowParser;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import lombok.SneakyThrows;

/**
 * @author tsy
 * Created by on 2023-04-18 10:25 AM
 */
public class Test {

    @SneakyThrows
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("dag1.json");
        String rule = IoUtil.readUtf8(classPathResource.getStream());
        IFlowParser parser = IFlowParser.of(rule);
        String el = parser.genEl();
        System.out.println(el);
    }
}