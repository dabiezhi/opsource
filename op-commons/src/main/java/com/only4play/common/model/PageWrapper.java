package com.only4play.common.model;

import java.util.Map;
import java.util.function.Function;

import lombok.Data;

/**
 * @author gim
 */
@Data
public class PageWrapper<T> {
    private T bean;
    private Integer pageSize;
    private Integer page;
    private Map<String, String> sorts;

    public PageWrapper() {
    }

    public PageWrapper(T bean, Integer pageSize, Integer page, Map<String, String> sorts) {
        this.bean = bean;
        this.pageSize = pageSize;
        this.page = page;
        this.sorts = sorts;
    }

    public <U> PageWrapper<U> map(Function<? super T, ? extends U> converter) {
        return new PageWrapper<>(converter.apply(bean), pageSize, page, sorts);
    }


}
