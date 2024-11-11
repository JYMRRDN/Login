package com.jrdn.login.domain.dto;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PageDto<T> implements Serializable {
    private static final long serialVersionUID = -5371201158843795779L;
    private boolean hasNextPage;
    private long totalElements;
    private List<T> results;
    private int currentPage;
    private int pageSize;

    public PageDto() {
    }

    public long getCurrentPage() {
        return (long)this.currentPage;
    }

    public PageDto<T> setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public PageDto<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public PageDto<T> setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public PageDto<T> setTotalElements(long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public List<T> getResults() {
        return this.results;
    }

    public PageDto<T> setResults(List<T> results) {
        this.results = results;
        return this;
    }

    public static <Y, Z> PageDto<Z> newPageInfo(Page<Y> paged, List<Z> list) {
        return (new PageDto()).setResults(list).setCurrentPage(paged.getNumber()).setTotalElements(paged.getTotalElements()).setHasNextPage(paged.hasNext()).setPageSize(paged.getSize());
    }

    public static <Y, Z> PageDto<Z> emptyPageInfo() {
        return (new PageDto()).setResults(Collections.emptyList());
    }
}
