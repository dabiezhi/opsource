package com.only4play.flow.domain.chain.events;

import com.alibaba.fastjson.JSON;
import com.only4play.flow.domain.node.creator.NodeCreator;
import com.only4play.flow.domain.node.service.INodeService;
import com.only4play.flow.infrastructure.liteflow.parser.Node;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tsy
 * Created by on 2023-04-21 23:19
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ChainEventProcessor {

    private final INodeService iNodeService;
    @EventListener
    public void handleChainCreateForNode(ChainEvents.ChainCreateEvent event) {
        System.out.printf(JSON.toJSONString(event));
        Node node = event.getFlowParser().flow.getNodes().get(1);

        NodeCreator creator = new NodeCreator();
        creator.setNodeId(node.getId());
        creator.setNodeName(node.getName());
        creator.setCmpType(node.getCompId());
        creator.setParams(JSON.toJSONString(node.getData()));
        creator.setPayload("1212");
        iNodeService.createNode(creator);
    }
}