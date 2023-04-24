// ---Auto Generated by Only4Play ---
package com.only4play.flow.application.chain;

import java.util.Optional;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.model.PageWrapper;
import com.only4play.flow.application.chain.dto.ChainCreateRequest;
import com.only4play.flow.application.chain.dto.ChainQueryRequest;
import com.only4play.flow.application.chain.dto.ChainResponse;
import com.only4play.flow.application.chain.dto.ChainUpdateRequest;
import com.only4play.flow.infrastructure.repository.chain.dataobject.Chain;
import com.only4play.flow.application.chain.mapper.ChainMapper;
import com.only4play.flow.infrastructure.repository.chain.ChainRepository;
import com.only4play.jpa.support.EntityOperations;
import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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

    @Override
    public Long createChain(ChainCreateRequest creator) {
        Optional<Chain> chain = EntityOperations.doCreate(chainRepository)
            .create(() -> ChainMapper.INSTANCE.reqToEntity(creator)).update(e -> e.init())
            .execute();
        return chain.isPresent() ? chain.get().getId() : 0;
    }

    @Override
    public void updateChain(ChainUpdateRequest updater) {
        EntityOperations.doUpdate(chainRepository).loadById(updater.getId()).update(e -> e.init())
            .execute();
    }

    /**
     * valid
     */
    @Override
    public void validChain(Long id) {
        EntityOperations.doUpdate(chainRepository).loadById(id).update(e -> e.valid()).execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidChain(Long id) {
        EntityOperations.doUpdate(chainRepository).loadById(id).update(e -> e.invalid()).execute();
    }

    /**
     * delete
     */
    @Override
    public void deleteChain(Long id) {
        chainRepository.deleteById(id);
    }

    /**
     * findById
     */
    @Override
    public ChainResponse findById(Long id) {
        Optional<Chain> chain = chainRepository.findById(id);
        return ChainMapper.INSTANCE
            .entityToResp(chain.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    @Override
    public Page<ChainResponse> findByPage(PageWrapper<ChainQueryRequest> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<Chain> page = chainRepository.findAll(booleanBuilder, PageRequest.of(
            query.getPage() - 1, query.getPageSize(), Sort.by(Sort.Direction.DESC, "createdAt")));
        return page.map(ChainMapper.INSTANCE::entityToResp);
    }

}