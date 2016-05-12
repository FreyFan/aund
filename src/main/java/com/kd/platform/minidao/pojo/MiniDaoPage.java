/*******************************************************************************
 * @(#)MiniDaoPage.java 2015-6-9
 *
 * Copyright 2015 Frey.Fan. All rights reserved.
 *******************************************************************************/
package com.kd.platform.minidao.pojo;

import java.util.List;

/**
 * <b>Application name:</b> MiniDaoPage.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoPage<T> {
    private int page;

    private int rows;

    private int total;

    private int pages;

    private List<T> results;

    public int getPage() {
        return this.page;
    }

    public int getPages() {
        return this.pages;
    }

    public List<T> getResults() {
        return this.results;
    }

    public int getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setTotal(int total) {
        this.total = total;
        this.pages = (total / this.rows + (total % this.rows > 0 ? 1 : 0));
    }
}
