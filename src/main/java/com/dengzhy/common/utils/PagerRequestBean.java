package com.dengzhy.common.utils;

import java.io.Serializable;

/**
 * FileName: PagerRequestBean
 * Author: dengzhy
 * Date: 2016/9/9 19:15
 * Description:
 */
public class PagerRequestBean<T> implements Serializable {

    private Integer pageIndex;

    private Integer pageSize;

    private String sortField;

    private String sortOrder;

    private T queryParam;


    public T getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(T queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 行起始值
     */
    public Integer getStartIndex() {
        return (pageIndex) * pageSize;
    }
}
