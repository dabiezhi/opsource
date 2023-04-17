package com.only4play.flow.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;
import org.hibernate.annotations.Where;


@GenVo(pkgName = "com.only4play.flow.domain.chain.vo")
@GenCreator(pkgName = "com.only4play.flow.domain.chain.creator")
@GenUpdater(pkgName = "com.only4play.flow.domain.chain.updater")
@GenRepository(pkgName = "com.only4play.flow.domain.chain.repository")
@GenService(pkgName = "com.only4play.flow.domain.chain.service")
@GenServiceImpl(pkgName = "com.only4play.flow.domain.chain.service")
@GenQuery(pkgName = "com.only4play.flow.domain.chain.query")
@GenMapper(pkgName = "com.only4play.flow.domain.chain.mapper")
@GenController(pkgName = "com.only4play.flow.controller")
@GenCreateRequest(pkgName = "com.only4play.flow.domain.chain.request")
@GenUpdateRequest(pkgName = "com.only4play.flow.domain.chain.request")
@GenQueryRequest(pkgName = "com.only4play.flow.domain.chain.request")
@GenResponse(pkgName = "com.only4play.flow.domain.chain.response")
@Where(clause = "is_deleted = 0")
@Entity
@Table(name = "chain")
@Data
public class Chain extends BaseJpaAggregate {

    @FieldDesc(name = "应用名称")
    private String applicationName;

    @FieldDesc(name = "链路id")
    private String chainId;

    @FieldDesc(name = "链路名称")
    private String chainName;

    @FieldDesc(name = "链路描述")
    private String chainDesc;

    @FieldDesc(name = "链路el数据")
    private String elData;

    @FieldDesc(name = "页面json")
    private String frontJson;

    @FieldDesc(name = "环境变量")
    private String env;

    @Convert(converter = ValidStatusConverter.class)
    @IgnoreUpdater
    @IgnoreCreator
    @FieldDesc(name = "有效状态: 1-有效,0-无效")
    private ValidStatus validStatus;

    public void init() {
    }

    public void valid() {
    }

    public void invalid() {
    }
}