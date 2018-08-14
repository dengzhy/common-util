package com.dengzhy.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * mybatisplus和mybatis之间分页转换
 * @Author dengzhy
 * @Date 2018/8/14 14:11
 * @Return
 */
public class PageUtils<T> {

    public PageModel<List<T>> pageToPageModel(Page<T> page) {

        PageModel<List<T>> pageModel = new PageModel<>();
        pageModel.setData(page.getRecords());
        pageModel.setRecordCount(page.getTotal());
        pageModel.setPageSize(page.getSize());
        pageModel.setPageNumber(page.getCurrent());
        return pageModel;
    }

    public Page<T> pagerRequestBeanToPage(PagerRequestBean<T> pagerRequestBean) {
        Page<T> page = new Page<>();
        page.setCurrent(pagerRequestBean.getPageIndex());
        page.setSize(pagerRequestBean.getPageSize());
        return page;
    }
}
