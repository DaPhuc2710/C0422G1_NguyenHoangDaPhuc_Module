package com.example.model;

public class PageSize {

    int pageSizeNum;

    public PageSize() {
    }

    public PageSize(int pageSizeNum) {

        this.pageSizeNum = pageSizeNum;
    }

    public int getPageSizeNum() {
        return pageSizeNum;
    }

    public void setPageSizeNum(int pageSizeNum) {
        this.pageSizeNum = pageSizeNum;
    }

    @Override
    public String toString() {
        return String.valueOf(pageSizeNum);
    }
}
