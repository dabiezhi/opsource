package com.only4play.flow;

import java.util.UUID;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.common.model.Result;
import com.only4play.flow.controller.ChainController;
import com.only4play.flow.domain.chain.dto.ChainCreateReq;
import com.only4play.flow.domain.chain.dto.ChainQueryReq;
import com.only4play.flow.domain.chain.dto.ChainReleaseReq;
import com.only4play.flow.domain.chain.dto.ChainResp;
import com.only4play.flow.domain.chain.dto.ChainUpdateReq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tsy
 * Created by on 2023-04-18 11:21 AM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ChainTest {

    @Resource
    public ChainController chainController;

    @Test
    public void testCreateChain() {
        //TODO: Test goes here...
        ChainCreateReq request = new ChainCreateReq();
        request.setApplicationName("op-flow");
        request.setChainId(UUID.randomUUID().toString());
        request.setChainName("演示流程");
        request.setChainDesc("用于演示");
        Result<Long> chain = chainController.createChain(request);
    }


    @Test
    public void testUpdateChain() {
        //TODO: Test goes here...
        ChainUpdateReq request = new ChainUpdateReq();
        request.setId(1L);
        request.setApplicationName("op-flow");
        request.setChainId(UUID.randomUUID().toString());
        request.setChainName("演示流程");
        request.setChainDesc("修改成用于演示");
        Result<String> chain = chainController.updateChain(request);
    }

    @Test
    public void testReleaseChain() {
        //TODO: Test goes here...
        ChainReleaseReq request = new ChainReleaseReq();
        request.setId(1L);
        request.setFrontJson(Dag.json);
        Result<String> chain = chainController.releaseChain(request);
    }


    @Test
    public void testValidChain() {
        //TODO: Test goes here...
        chainController.validChain(1L);
    }

    @Test
    public void testInvalidChain() {
        //TODO: Test goes here...
        chainController.invalidChain(1L);
    }

    @Test
    public void testFindById() {
        //TODO: Test goes here...
        Result<ChainResp> byId = chainController.findById(1L);
        System.out.println(JSON.toJSONString(byId));
    }

    @Test
    public void testFindByPage() {
        //TODO: Test goes here...
        ChainQueryReq request = new ChainQueryReq();
        request.setApplicationName("op-flow");
        Result<PageResult<ChainResp>> byPage = chainController.findByPage(request);
        System.out.println(JSON.toJSONString(byPage));
    }

}