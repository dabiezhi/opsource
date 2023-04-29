package com.only4play.flow.domain.chainel;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;

@Entity
@Table(name = "chain_el")
@Data
public class ChainEl extends BaseJpaAggregate {

    @FieldDesc(name = "应用名称")
    private String applicationName;

    @FieldDesc(name = "链路id")
    private String chainId;

    @FieldDesc(name = "链路el数据")
    private String elData;

    public void init() {
    }

}