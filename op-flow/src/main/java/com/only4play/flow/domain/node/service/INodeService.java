// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.node.service;

import java.util.List;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.flow.domain.node.creator.NodeCreator;
import com.only4play.flow.domain.node.query.NodeQuery;
import com.only4play.flow.domain.node.vo.NodeVO;

import org.springframework.data.domain.Page;

public interface INodeService {

    /**
     * batchCreateNode
     */
    void batchCreateNode(String chainId, List<NodeCreator> creatorList);

    /**
     * findById
     */
    NodeVO findById(Long id);

    /**
     * findByPage
     */
    Page<NodeVO> findByPage(PageRequestWrapper<NodeQuery> query);
}
