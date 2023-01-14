package com.qin.entity;

public class Page {
    private int countPage; //总页数
    private static int clums = 5; //每页显示条数
    private int countClums; //总记录数
    private int pages = 1; //当前页数

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCountPage() {
        this.countPage = (int) Math.ceil((float)countClums / (float)clums);
        return countPage;
    }

    public int getClums() {
        return clums;
    }

    public int getCountClums() {
        return countClums;
    }

    public void setCountClums(int countClums) {
        this.countClums = countClums;
    }
}
