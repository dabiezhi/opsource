package com.only4play.flow.infrastructure.liteflow.emums;

/**
 * @author tsy
 * Created by on 2023-04-18 10:17 AM
 */
public enum NodeKind {
    START("start"),
    END("end"),

    COMPNODE("compNode"),
    IFNODE("ifNode"),

    FORNODE("forNode"),
    SWITCHNODE("switch");

    private final String code;

    NodeKind(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static NodeKind getIns(String code) {
        return NodeKind.valueOf(code.toUpperCase());
    }
}