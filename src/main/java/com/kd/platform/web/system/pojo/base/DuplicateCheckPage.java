package com.kd.platform.web.system.pojo.base;

/**
 * <b>Application name:</b> DuplicateCheckPage.java <br>
 * <b>Application describing: UI库常用控件参考示例【重复校验】</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class DuplicateCheckPage implements java.io.Serializable {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 字段值
     */
    private String fieldVlaue;

    /** 编辑数据ID */
    private String rowObid;

    public String getRowObid() {
        return rowObid;
    }

    public void setRowObid(String rowObid) {
        this.rowObid = rowObid;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldVlaue() {
        return fieldVlaue;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldVlaue(String fieldVlaue) {
        this.fieldVlaue = fieldVlaue;
    }

}
