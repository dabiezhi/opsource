package com.only4play.flow.domain.chain.events;

import com.only4play.flow.domain.chain.Chain;
import com.only4play.flow.infrastructure.liteflow.parser.FlowParser;

import lombok.Value;

/**
 * @author tsy
 * Created by on 2023-04-21 23:15
 */
public interface ChainEvents {

    @Value
    class ChainCreateEvent {
        Chain      chain;
        FlowParser flowParser;
    }
}