// ---Auto Generated by Only4Play ---
package com.only4play.flow.controller;

import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.PageResult;
import com.only4play.common.model.PageWrapper;
import com.only4play.common.model.Result;
import com.only4play.flow.domain.chain.dto.ChainCreateRequest;
import com.only4play.flow.domain.chain.dto.ChainQueryRequest;
import com.only4play.flow.domain.chain.dto.ChainReleaseRequest;
import com.only4play.flow.domain.chain.dto.ChainResponse;
import com.only4play.flow.domain.chain.dto.ChainUpdateRequest;
import com.only4play.flow.domain.chain.dto.creator.ChainCreator;
import com.only4play.flow.domain.chain.dto.query.ChainQuery;
import com.only4play.flow.domain.chain.dto.updater.ChainUpdater;
import com.only4play.flow.domain.chain.dto.vo.ChainVO;
import com.only4play.flow.domain.chain.mapper.ChainMapper;
import com.only4play.flow.domain.chain.service.IChainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("chain/v1")
@RequiredArgsConstructor
public class ChainController {
    private final IChainService chainService;


    /**
     * createRequest
     */
    @PostMapping("create")
    public Result<Long> createChain(@RequestBody ChainCreateRequest request) {
        ChainCreator creator = ChainMapper.INSTANCE.request2Creator(request);
        return Result.success(chainService.createChain(creator));
    }

    /**
     * update request
     */
    @PostMapping("update")
    public Result<String> updateChain(@RequestBody ChainUpdateRequest request) {
        ChainUpdater updater = ChainMapper.INSTANCE.request2Updater(request);
        chainService.updateChain(updater);
        return Result.success(CodeEnum.Success.getName());
    }

    /**
     * releaseRequest
     */
    @PostMapping("release")
    public Result<String> releaseChain(@RequestBody ChainReleaseRequest request) {
        chainService.releaseChain(ChainMapper.INSTANCE.request2Updater(request));
        return Result.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public Result<String> validChain(@PathVariable Long id) {
        chainService.validChain(id);
        return Result.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public Result<String> invalidChain(@PathVariable Long id) {
        chainService.invalidChain(id);
        return Result.success(CodeEnum.Success.getName());
    }

    /**
     * delete
     */
    @PostMapping("delete/{id}")
    public Result<String> deleteChain(@PathVariable Long id) {
        chainService.deleteChain(id);
        return Result.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public Result<ChainResponse> findById(@PathVariable Long id) {
        ChainVO vo = chainService.findById(id);
        ChainResponse response = ChainMapper.INSTANCE.vo2CustomResponse(vo);
        return Result.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public Result<PageResult<ChainResponse>> findByPage(@RequestBody PageWrapper<ChainQueryRequest> request) {
        PageWrapper<ChainQuery> pageWrapper = request.map(v -> ChainMapper.INSTANCE.request2Query(request.getBean()));
        Page<ChainResponse> page = chainService.findByPage(pageWrapper).map(ChainMapper.INSTANCE::vo2CustomResponse);
        return Result.success(
                PageResult.of(page.getContent(), page.getTotalElements(), page.getSize(), page.getNumber()));
    }

}
