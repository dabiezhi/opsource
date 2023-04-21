package com.only4play.flow.domain.chain.events;

import com.alibaba.fastjson.JSON;

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

    @EventListener
    public void handleChainCreateForNode(ChainEvents.ChainCreateEvent event) {
        System.out.printf(JSON.toJSONString(event));
        //生成node节点相关的数据
    }
}