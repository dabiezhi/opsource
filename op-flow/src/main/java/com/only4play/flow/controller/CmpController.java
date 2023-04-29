// ---Auto Generated by Only4Play ---
package com.only4play.flow.controller;

import java.util.List;
import java.util.Map;

import com.only4play.common.model.Result;
import com.only4play.flow.domain.cmp.response.CmpResp;
import com.only4play.flow.domain.cmp.service.ICmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("cmp/v1")
@RequiredArgsConstructor
public class CmpController {
    private final ICmpService cmpService;

    /**
     * findCm
     */
    @GetMapping("findAll")
    public Result<Map<String, List<CmpResp>>> findAll() {
        return Result.success(cmpService.findAll());
    }

}
