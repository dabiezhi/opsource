package com.only4play.flow.domain.chain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;

@GenRepository(pkgName = "com.only4play.flow.domain.chain.repository")
@GenService(pkgName = "com.only4play.flow.domain.chain.service")
@GenServiceImpl(pkgName = "com.only4play.flow.domain.chain.service")
@GenMapper(pkgName = "com.only4play.flow.domain.chain.mapper")

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
}