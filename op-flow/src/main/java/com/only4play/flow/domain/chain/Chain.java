package com.only4play.flow.domain.chain;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.flow.domain.chain.events.ChainEvents;
import com.only4play.flow.infrastructure.liteflow.parser.IFlowParser;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;

import cn.hutool.core.lang.Assert;
import lombok.Data;

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

    @Convert(converter = ValidStatusConverter.class)
    @FieldDesc(name = "有效状态: 1-有效,0-无效")
    private ValidStatus validStatus;

    public void init() {
        if (ValidStatus.INVALID.equals(this.getValidStatus())) {
            Assert.notBlank(this.getFrontJson());
            IFlowParser parser = IFlowParser.of(this.getFrontJson());
            this.setElData(parser.genEL());
            registerEvent(new ChainEvents.ChainCreateEvent(this, parser));
        }
    }

    public void valid() {
        this.setValidStatus(ValidStatus.VALID);
    }

    public void invalid() {
        this.setValidStatus(ValidStatus.INVALID);
    }

}