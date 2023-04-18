package com.only4play.flow;

import javax.annotation.Resource;

import com.only4play.flow.domain.chain.service.IChainService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author tsy
 * Created by on 2023-04-18 11:21 AM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ChainTest {

    @Resource
    public IChainService iChainService;

    @Test
    public void page() {
        iChainService.findById(1L);
    }
}