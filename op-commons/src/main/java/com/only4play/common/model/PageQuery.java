package com.only4play.common.model;

import java.io.Serializable;

public class PageQuery implements Serializable {

    private static final long serialVersionUID = -8882187050736891728L;
    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 20;
    /**
     * 最大每页显示的记录数
     */
    public static final int MAX_PAGE_SIZE = 200;
    /**
     * 默认每页显示的记录数
     */
    public static final int DEFAULT_PAGE_NUMBER = 1;

    private int pageNumber;
    private int pageSize;
    private boolean lockedOffset;
    private int offset;

    public PageQuery() {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.pageNumber = DEFAULT_PAGE_NUMBER;
    }

    public PageQuery(int pageNumber, int pageSize) {
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Page index must not be less than one!");
        }

        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }

        this.pageNumber = pageNumber;
        this.pageSize = Math.min(pageSize, MAX_PAGE_SIZE);
    }

    public void lockOffset() {
        lockedOffset = true;
        this.offset = (pageNumber - 1) * pageSize;
    }

    public void unlockOffset() {
        lockedOffset = false;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        if (lockedOffset) {
            return offset;
        }
        return (pageNumber - 1) * pageSize;
    }

    public void setPageNumber(int pageNumber) {
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Page index must not be less than one!");
        }
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        }
        this.pageSize = Math.min(pageSize, MAX_PAGE_SIZE);
    }

    @Override
    public String toString() {
        return "PageQuery{" + "pageNumber=" + pageNumber + ", pageSize=" + pageSize + '}';
    }
}
