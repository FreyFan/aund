package com.kd.platform.core.common.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Application name:</b> DBTable.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class DBTable<T> implements Serializable {

    public String tableName;

    public String entityName;

    public String tableTitle;

    public Class<T> tableEntityClass;

    public List<T> tableData;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getTableTitle() {
        return tableTitle;
    }

    public void setTableTitle(String tableTitle) {
        this.tableTitle = tableTitle;
    }

    public Class<T> getClass1() {
        return tableEntityClass;
    }

    public void setClass1(Class<T> class1) {
        this.tableEntityClass = class1;
    }

    public List<T> getTableData() {
        return tableData;
    }

    public void setTableData(List<T> tableData) {
        this.tableData = tableData;
    }

}
