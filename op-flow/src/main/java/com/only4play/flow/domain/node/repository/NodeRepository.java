// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.node.repository;

import com.only4play.flow.domain.node.Node;
import com.only4play.jpa.support.BaseRepository;
import java.lang.Long;

public interface NodeRepository extends BaseRepository<Node, Long> {
    long deleteByChainId(String chainId);
}
