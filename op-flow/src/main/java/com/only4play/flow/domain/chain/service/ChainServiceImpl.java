// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.chain.service;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.flow.domain.Chain;
import com.only4play.flow.domain.chain.creator.ChainCreator;
import com.only4play.flow.domain.chain.mapper.ChainMapper;
import com.only4play.flow.domain.chain.query.ChainQuery;
import com.only4play.flow.domain.chain.repository.ChainRepository;
import com.only4play.flow.domain.chain.updater.ChainUpdater;
import com.only4play.flow.domain.chain.vo.ChainVO;
import com.only4play.jpa.support.EntityOperations;
import com.querydsl.core.BooleanBuilder;
import java.lang.Long;
import java.lang.Override;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class ChainServiceImpl implements IChainService {
  private final ChainRepository chainRepository;

  /**
   * createImpl
   */
  @Override
  public Long createChain(ChainCreator creator) {
    Optional<Chain> chain = EntityOperations.doCreate(chainRepository)
    .create(() -> ChainMapper.INSTANCE.dtoToEntity(creator))
    .update(e -> e.init())
    .execute();
    return chain.isPresent() ? chain.get().getId() : 0;
  }

  /**
   * update
   */
  @Override
  public void updateChain(ChainUpdater updater) {
    EntityOperations.doUpdate(chainRepository)
    .loadById(updater.getId())
    .update(e -> updater.updateChain(e))
    .execute();
  }

  /**
   * valid
   */
  @Override
  public void validChain(Long id) {
    EntityOperations.doUpdate(chainRepository)
    .loadById(id)
    .update(e -> e.valid())
    .execute();
  }

  /**
   * invalid
   */
  @Override
  public void invalidChain(Long id) {
    EntityOperations.doUpdate(chainRepository)
    .loadById(id)
    .update(e -> e.invalid())
    .execute();
  }

  /**
   * findById
   */
  @Override
  public ChainVO findById(Long id) {
    Optional<Chain> chain =  chainRepository.findById(id);
    return new ChainVO(chain.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
  }

  /**
   * findByPage
   */
  @Override
  public Page<ChainVO> findByPage(PageRequestWrapper<ChainQuery> query) {
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    Page<Chain> page = chainRepository.findAll(booleanBuilder,
            PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                Sort.Direction.DESC, "createdAt")));
    return new PageImpl<>(page.getContent().stream().map(entity -> new ChainVO(entity))
            .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
  }
}