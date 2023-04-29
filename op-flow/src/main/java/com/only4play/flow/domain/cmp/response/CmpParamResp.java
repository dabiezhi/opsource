package com.only4play.flow.domain.cmp.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema
@Data
public class CmpParamResp {

    @Schema(title = "组件id")
    private String cmpId;

    @Schema(title = "参数名称")
    private String name;

    @Schema(title = "参数是否必填")
    private Integer required;

    @Schema(title = "参数输入类型")
    private String inType;

    @Schema(title = "下拉选项内容，多个值以逗号分隔")
    private String option;

    @Schema(title = "参数值提示性内容")
    private String placeholder;

}
