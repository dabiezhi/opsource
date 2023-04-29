// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.chain.dto;

import com.only4play.common.model.AbstractJpaResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class ChainResponse extends AbstractJpaResponse {
    @Schema(title = "应用名称")
    private String applicationName;

    @Schema(title = "链路id")
    private String chainId;

    @Schema(title = "链路名称")
    private String chainName;

    @Schema(title = "链路描述")
    private String chainDesc;

    @Schema(title = "有效状态: 1-有效,0-无效")
    private Integer validStatus;

}
