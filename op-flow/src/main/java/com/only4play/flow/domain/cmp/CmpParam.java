package com.only4play.flow.domain.cmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;


@GenRepository(pkgName = "com.only4play.flow.domain.cmp.repository")
@GenService(pkgName = "com.only4play.flow.domain.cmp.service")
@GenServiceImpl(pkgName = "com.only4play.flow.domain.cmp.service")
@GenMapper(pkgName = "com.only4play.flow.domain.cmp.mapper")

@Entity
@Table(name = "cmp_param")
@Data
public class CmpParam extends BaseJpaAggregate {

    @FieldDesc(name = "组件id")
    @Column(name = "cmp_id")
    private String cmpId;

    @FieldDesc(name = "参数名称")
    private String name;

    @FieldDesc(name = "参数是否必填")
    private Integer required;

    @FieldDesc(name = "参数输入类型")
    private String inType;

    @FieldDesc(name = "下拉选项内容，多个值以逗号分隔")
    private String option;

    @FieldDesc(name = "参数值提示性内容")
    private String placeholder;

    public void init() {
    }

    public void valid() {
    }

    public void invalid() {
    }
}
