// ---Auto Generated by Only4Play ---
package com.only4play.flow.controller;

import java.util.Map;

import com.only4play.common.model.Result;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.FlowBus;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.flow.element.Chain;
import com.yomahub.liteflow.flow.element.Node;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("flow/v1")
@RequiredArgsConstructor
public class FlowController {
    private final FlowExecutor flowExecutor;

    @GetMapping("exec")
    public Result<Void> exec() {
        Map<String, Chain> chainMap = FlowBus.getChainMap();
        Map<String, Node> nodeMap = FlowBus.getNodeMap();
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("d52510aa-511f-4052-bf8c-a1b177bc0735");
        return Result.success(null);
    }
}
