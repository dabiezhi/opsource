package com.only4play.flow.domain.cmp.dto.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.vo.AbstractBaseJpaVO;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.flow.domain.cmp.Cmp;
import com.only4play.flow.domain.cmp.CmpParam;
import com.only4play.jpa.support.BaseJpaAggregate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema
@Data
public class CmpParamVO extends AbstractBaseJpaVO {

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

    protected CmpParamVO() {
    }

    public CmpParamVO(CmpParam source) {
        super(source);
        this.setCmpId(source.getCmpId());
        this.setName(source.getName());
        this.setRequired(source.getRequired());
        this.setInType(source.getInType());
        this.setOption(source.getOption());
        this.setPlaceholder(source.getPlaceholder());
    }
}
