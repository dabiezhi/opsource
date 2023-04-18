package com.only4play.flow;

import java.util.UUID;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.only4play.flow.controller.ChainController;
import com.only4play.flow.domain.chain.request.ChainCreateRequest;
import com.only4play.flow.domain.chain.request.ChainQueryRequest;
import com.only4play.flow.domain.chain.request.ChainUpdateRequest;
import com.only4play.flow.domain.chain.response.ChainResponse;

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
        ChainCreateRequest request = new ChainCreateRequest();
        request.setApplicationName("app");
        request.setChainId(UUID.randomUUID().toString());
        request.setChainName("演示流程");
        request.setChainDesc("用于演示");
        request.setElData("");
        request.setFrontJson("");
        request.setValidStatus("VALID");
        JsonObject<Long> chain = chainController.createChain(request);
        System.out.println(JSONObject.toJSONString(chain));
    }


    @Test
    public void testUpdateChain() {
        //TODO: Test goes here...
        ChainUpdateRequest request = new ChainUpdateRequest();
        request.setId(1L);
        request.setApplicationName("app");
        request.setChainId(UUID.randomUUID().toString());
        request.setChainName("演示流程");
        request.setChainDesc("用于演示");
        request.setElData("234");
        request.setFrontJson("");
        request.setEnv("dev");
        JsonObject<String> chain = chainController.updateChain(request);
        System.out.println(JSONObject.toJSONString(chain));
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
        JsonObject<ChainResponse> byId = chainController.findById(1L);
        System.out.println(JSONObject.toJSONString(byId));
    }

    @Test
    public void testFindByPage() {
        //TODO: Test goes here...
        PageRequestWrapper<ChainQueryRequest> request = new PageRequestWrapper<>();
        request.setPage(1);
        request.setPageSize(10);
        JsonObject<PageResult<ChainResponse>> byPage = chainController.findByPage(request);
        System.out.println(JSONObject.toJSONString(byPage));
    }

}