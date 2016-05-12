package com.kd.platform.core.common.model.json;

import java.util.List;

/**
 * <b>Application name:</b> DataGridReturn.java <br>
 * <b>Application describing: 后台向前台返回JSON，用于easyui的datagrid</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class DataGridReturn {

    public DataGridReturn(Integer total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    private Integer total;// 总记录数

    private List rows;// 每行记录

    private List footer;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public List getFooter() {
        return footer;
    }

    public void setFooter(List footer) {
        this.footer = footer;
    }

}
