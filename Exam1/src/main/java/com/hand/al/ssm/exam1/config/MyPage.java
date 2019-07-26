package com.hand.al.ssm.exam1.config;

public class MyPage {
    private int pageSize;
    private int page;
    private String sort = "ASC";

    public MyPage(int pageSize, int page, String sort) {
        this.pageSize = pageSize;
        this.page = page;
        this.sort = sort;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}