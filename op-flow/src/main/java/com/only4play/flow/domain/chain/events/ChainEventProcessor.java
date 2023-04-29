package com.only4play.flow.domain.chain.events;

import java.util.ArrayList;
import java.util.List;

import com.only4play.flow.domain.chain.Chain;
import com.only4play.flow.domain.chainel.dto.creator.ChainElCreatorOrUpdater;
import com.only4play.flow.domain.chainel.service.IChainElService;
import com.only4play.flow.domain.node.creator.NodeCreator;
import com.only4play.flow.domain.node.service.INodeService;
import com.only4play.flow.infrastructure.liteflow.parser.IFlowParser;
import com.only4play.flow.infrastructure.liteflow.parser.INode;

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
    private final IChainElService iChainElService;

    @EventListener
    public void handleChainCreateForNode(ChainEvents.ChainCreateEvent event) {
        IFlowParser iFlowParser = event.getIFlowParser();

        List<NodeCreator> nodeCreators = new ArrayList<>();
        for (INode iNode : iFlowParser.singleNodes) {
            NodeCreator creator = new NodeCreator();
            creator.setChainId(event.getChain().getChainId());
            creator.setNodeId(iNode.getId());
            creator.setNodeName(iNode.getName());
            creator.setCmpId(iNode.getCompId());
            creator.setParams(iNode.getData().getParams());
            creator.setPayload(iNode.getData().getPayload());
            nodeCreators.add(creator);
        }
        iNodeService.batchCreateNode(event.getChain().getChainId(), nodeCreators);
    }

    @EventListener
    public void handleChainCreateForEl(ChainEvents.ChainCreateEvent event) {
        IFlowParser iFlowParser = event.getIFlowParser();
        Chain chain = event.getChain();

        ChainElCreatorOrUpdater creatorOrUpdater = new ChainElCreatorOrUpdater();
        creatorOrUpdater.setChainId(chain.getChainId());
        creatorOrUpdater.setApplicationName(chain.getApplicationName());
        creatorOrUpdater.setElData(iFlowParser.genEl());
        iChainElService.createOrUpdateChainEl(creatorOrUpdater);
    }
}