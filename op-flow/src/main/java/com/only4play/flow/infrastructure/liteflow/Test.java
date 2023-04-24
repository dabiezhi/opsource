package com.only4play.flow.infrastructure.liteflow;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.only4play.flow.infrastructure.liteflow.parser.IFlowParser;
import com.only4play.flow.infrastructure.liteflow.parser.INode;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
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
        List<INode> nodes = parser.flow.getNodes();
        String el = parser.genEL();
        System.out.println(el);
    }
}