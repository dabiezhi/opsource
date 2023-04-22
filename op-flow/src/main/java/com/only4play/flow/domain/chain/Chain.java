package com.only4play.flow.domain.chain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.flow.domain.chain.events.ChainEvents;
import com.only4play.flow.infrastructure.liteflow.parser.IFlowParser;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;

import cn.hutool.core.lang.Assert;
import lombok.Data;

@GenVo(pkgName = "com.only4play.flow.domain.chain.vo")
@GenCreator(pkgName = "com.only4play.flow.domain.chain.creator")
@GenUpdater(pkgName = "com.only4play.flow.domain.chain.updater")
@GenQuery(pkgName = "com.only4play.flow.domain.chain.query")
@Entity
@Table(name = "chain")
@Data
public class Chain extends BaseJpaAggregate {

    @FieldDesc(name = "应用名称")
    private String      applicationName;

    @FieldDesc(name = "链路id")
    private String      chainId;

    @FieldDesc(name = "链路名称")
    private String      chainName;

    @FieldDesc(name = "链路描述")
    private String      chainDesc;

    @FieldDesc(name = "链路el数据")
    private String      elData;

    @FieldDesc(name = "页面json")
    private String      frontJson;

    @FieldDesc(name = "环境变量")
    private String      env;

    @Convert(converter = ValidStatusConverter.class)
    @IgnoreUpdater
    //    @IgnoreCreat
    //    or
    @FieldDesc(name = "有效状态: 1-有效,0-无效")
    private ValidStatus validStatus;

    public void init() {
        this.setValidStatus(ValidStatus.INVALID);
        Assert.notBlank(this.getFrontJson());
        IFlowParser parser = IFlowParser.of1(this.getFrontJson());
        this.setElData(parser.genEL());
        registerEvent(new ChainEvents.ChainCreateEvent(this, parser));
    }

    public void valid() {
        this.setValidStatus(ValidStatus.VALID);
        IFlowParser parser = IFlowParser.of1(this.getFrontJson());
        this.setElData(parser.genEL());
    }

    public void invalid() {
        this.setValidStatus(ValidStatus.INVALID);
    }
}