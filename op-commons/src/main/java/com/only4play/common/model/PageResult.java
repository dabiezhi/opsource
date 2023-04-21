package com.only4play.common.model;

import java.util.List;
import lombok.Data;

@Data
public class PageResult<T> {

    private Long    total;
    private Integer totalPages;
    private Integer pageSize;
    private Integer pageNumber;
    private List<T> list;

    public PageResult(List<T> list, Long total, Integer pageSize, Integer pageNumber) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public static <T> PageResult<T> of(List<T> list, Long total, Integer pageSize,
                                       Integer pageNumber) {
        return new PageResult<T>(list, total, pageSize, pageNumber);
    }
}