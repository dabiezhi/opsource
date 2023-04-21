package com.only4play.flow.domain.node;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;

@GenVo(pkgName = "com.only4play.flow.domain.node.vo")
@GenCreator(pkgName = "com.only4play.flow.domain.node.creator")
@GenUpdater(pkgName = "com.only4play.flow.domain.node.updater")
@GenRepository(pkgName = "com.only4play.flow.domain.node.repository")
@GenService(pkgName = "com.only4play.flow.domain.node.service")
@GenServiceImpl(pkgName = "com.only4play.flow.domain.node.service")
@GenQuery(pkgName = "com.only4play.flow.domain.node.query")
@GenMapper(pkgName = "com.only4play.flow.domain.node.mapper")
@GenController(pkgName = "com.only4play.flow.controller")
@GenCreateRequest(pkgName = "com.only4play.flow.node.api.request")
@GenUpdateRequest(pkgName = "com.only4play.flow.node..api.request")
@GenQueryRequest(pkgName = "com.only4play.flow.node..api.request")
@GenResponse(pkgName = "com.only4play.flow.node..api.response")
@Entity
@Table(name = "node")
@Data
public class Node extends BaseJpaAggregate {

    public void init() {
    }

    public void valid() {
    }

    public void invalid() {
    }
}