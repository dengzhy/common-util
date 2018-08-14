package com.dengzhy.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: PageModel
 * Author: dengzhy
 * Date: 2016/9/9 17:48
 * Description:
 */
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = 5156026126959380620L;
    private int pageNumber = 0;
    private int pageSize = 0;
    private int pageCount = 0;
    private int recordCount = 0;
    private int offset = 0;
    private int limit = 0;
    private T data;
    private int start;

    private int last;

    public PageModel() {

    }


    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the recordCount
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public static <T> PageModel<T> getPagination(int pageSize, int pageNumber,
                                                 int recordCount) {
        int pageCount = 0;
        int offset = 0;
        int pageLast = 0;
        int start = 0;
        int last = 0;
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = recordCount / pageSize + 1;
        }

        if (pageNumber == 0) {
            pageNumber = 1;
        }

        offset = (pageNumber - 1) * pageSize;

        pageLast = pageNumber * pageSize; // 当前页最大记录

        if (recordCount >= pageLast) {
            last = pageLast;
        } else {
            last = recordCount;
        }

        if (recordCount > 0) {
            start = 1;
            if (pageNumber > 1) {
                start = (pageNumber - 1) * pageSize;
            }
        }

        PageModel<T> pgModel = new PageModel<T>();
        pgModel.setOffset(offset);
        pgModel.setLimit(pageSize);
        pgModel.setPageSize(pageSize);
        pgModel.setPageNumber(pageNumber);
        pgModel.setPageCount(pageCount);
        pgModel.setRecordCount(recordCount);
        pgModel.setStart(start);
        pgModel.setLast(last);
        return pgModel;
    }

    public static <T> PageModel<T> getPagination(int pageSize, int pageNumber) {
        int offset = 0;

        if (pageNumber == 0) {
            pageNumber = 1;
        }

        offset = (pageNumber - 1) * pageSize;

        PageModel<T> pgModel = new PageModel<T>();
        pgModel.setOffset(offset);
        pgModel.setLimit(pageSize);
        pgModel.setPageSize(pageSize);
        pgModel.setPageNumber(pageNumber);
        return pgModel;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new PageModelMap<>();
        map.put("data", data);
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        map.put("pageCount", pageCount);
        map.put("recordCount", recordCount);
        return map;
    }

    public Map<String, Object> toShopListMap() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        map.put("pageNumber", pageNumber);
        map.put("pageSize", pageSize);
        map.put("pageCount", pageCount);
        map.put("recordCount", recordCount);
        result.put("shopList", map);
        return result;
    }

    public void reset() {
        pageSize = pageSize == 0 ? 10 : pageSize;
        pageNumber = pageNumber == 0 ? 1 : pageNumber;
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = recordCount / pageSize + 1;
        }
        offset = (pageNumber - 1) * pageSize;

        last = pageNumber * pageSize;
        if (recordCount < last) {
            last = recordCount;
        }

        if (recordCount > 0) {
            start = 1;
            if (pageNumber > 1) {
                start = (pageNumber - 1) * pageSize;
            }
        }
        limit = pageSize;
    }

    public static Integer handlePageNumber(Integer pageNumber) {
        return null != pageNumber && pageNumber > 0 ? pageNumber : 1;
    }

    public static Integer handlePageSize(Integer pageSize) {
        return null != pageSize && pageSize > 0 ? pageSize : 10;
    }

    public static Integer getOffset(Integer pageNumber, Integer pageSize) {
        return (pageNumber - 1) * pageSize;
    }
}