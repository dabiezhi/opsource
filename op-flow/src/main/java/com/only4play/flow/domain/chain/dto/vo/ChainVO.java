// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.chain.dto.vo;

import com.only4play.common.constants.ValidStatus;
import com.only4play.flow.domain.chain.Chain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class ChainVO {
    @Schema(title = "应用名称")
    private String applicationName;

    @Schema(title = "链路id")
    private String chainId;

    @Schema(title = "链路名称")
    private String chainName;

    @Schema(title = "链路描述")
    private String chainDesc;

    @Schema(title = "链路el数据")
    private String elData;

    @Schema(title = "页面json")
    private String frontJson;

    @Schema(title = "环境变量")
    private String env;

    @Schema(title = "有效状态: 1-有效,0-无效")
    private ValidStatus validStatus;


    public ChainVO(Chain source) {
        this.setApplicationName(source.getApplicationName());
        this.setChainId(source.getChainId());
        this.setChainName(source.getChainName());
        this.setChainDesc(source.getChainDesc());
        this.setFrontJson(source.getFrontJson());
        this.setValidStatus(source.getValidStatus());
    }
}
