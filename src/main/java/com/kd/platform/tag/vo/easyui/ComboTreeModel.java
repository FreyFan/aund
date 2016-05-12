package com.kd.platform.tag.vo.easyui;

/**
 * <b>Application name:</b> ComboTreeModel.java <br>
 * <b>Application describing: 下拉树形选择框模型设置类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-15 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ComboTreeModel implements java.io.Serializable {
    private String idField;

    private String textField;

    private String iconCls;// 前面的小图标样式

    private String childField;// 子节点

    private String srcField;// 地址字段

    public ComboTreeModel(String idField, String textField, String childField) {
        this.idField = idField;
        this.textField = textField;
        this.childField = childField;
    }

    public ComboTreeModel(String idField, String textField, String childField, String srcField) {
        this.idField = idField;
        this.textField = textField;
        this.childField = childField;
        this.srcField = srcField;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getChildField() {
        return childField;
    }

    public void setChildField(String childField) {
        this.childField = childField;
    }

    public String getIdField() {
        return idField;
    }

    public void setIdField(String idField) {
        this.idField = idField;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getSrcField() {
        return srcField;
    }

    public void setSrcField(String srcField) {
        this.srcField = srcField;
    }
}
