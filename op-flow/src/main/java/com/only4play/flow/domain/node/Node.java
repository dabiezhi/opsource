package com.only4play.flow.domain.node;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;

@GenVo(pkgName = "com.only4play.flow.domain.node.vo")
@GenCreator(pkgName = "com.only4play.flow.domain.node.creator")
@GenUpdater(pkgName = "com.only4play.flow.domain.node.updater")
@GenQuery(pkgName = "com.only4play.flow.domain.node.query")

@Entity
@Table(name = "node")
@Data
public class Node extends BaseJpaAggregate {

    @FieldDesc(name = "节点id")
    private String nodeId;

    @FieldDesc(name = "节点名称")
    private String nodeName;

    @FieldDesc(name = "组件id")
    private String cmpId;

    @FieldDesc(name = "节点属性参数")
    private String params;

    @FieldDesc(name = "自定义参数")
    private String payload;

    public void init() {
    }

    public void valid() {
    }

    public void invalid() {
    }
}