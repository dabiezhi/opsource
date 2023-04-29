package com.only4play.flow.domain.cmp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.jpa.support.BaseJpaAggregate;

import lombok.Data;

@Entity
@Table(name = "cmp")
@Data
public class Cmp extends BaseJpaAggregate {

    @FieldDesc(name = "组件id")
    private String cmpId;

    @FieldDesc(name = "组件名称")
    private String name;

    @FieldDesc(name = "组件形状")
    private String shape;

    @FieldDesc(name = "组件菜单分类")
    private String menu;

    @FieldDesc(name = "组件图标")
    private String svg;

    @FieldDesc(name = "组件背景色")
    private String background;

    @FieldDesc(name = "组件描述")
    private String desc;

    public void init() {
    }

    public void valid() {
    }

    public void invalid() {
    }
}
