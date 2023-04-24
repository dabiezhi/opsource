// ---Auto Generated by Only4Play ---
package com.only4play.flow.application.chain;

import com.only4play.common.model.PageWrapper;
import com.only4play.flow.application.chain.dto.ChainCreateRequest;
import com.only4play.flow.application.chain.dto.ChainQueryRequest;
import com.only4play.flow.application.chain.dto.ChainResponse;
import com.only4play.flow.application.chain.dto.ChainUpdateRequest;

import org.springframework.data.domain.Page;

public interface IChainService {
  /**
   * create
   */
  Long createChain(ChainCreateRequest creator);

  /**
   * update
   */
  void updateChain(ChainUpdateRequest updater);

  /**
   * valid
   */
  void validChain(Long id);

  /**
   * invalid
   */
  void invalidChain(Long id);

  /**
   * delete
   */
  void deleteChain(Long id);

  /**
   * findById
   */
  ChainResponse findById(Long id);

  /**
   * findByPage
   */
  Page<ChainResponse> findByPage(PageWrapper<ChainQueryRequest> query);
}