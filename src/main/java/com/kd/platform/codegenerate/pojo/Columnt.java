package com.kd.platform.codegenerate.pojo;

/**
 * <b>Application name:</b> Columnt.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Columnt {
    public static final String OPTION_REQUIRED = "required:true";

    public static final String OPTION_NUMBER_INSEX = "precision:2,groupSeparator:','";

    private String fieldDbName;

    private String fieldName;

    private String filedComment = "";

    private String fieldType = "";

    private String classType = "";

    private String classType_row = "";

    private String optionType = "";

    private String charmaxLength = "";

    private String precision;

    private String scale;

    private String nullable;

    public String getNullable() {
        return this.nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getPrecision() {
        return this.precision;
    }

    public String getScale() {
        return this.scale;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getOptionType() {
        return this.optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFiledComment() {
        return this.filedComment;
    }

    public void setFiledComment(String filedComment) {
        this.filedComment = filedComment;
    }

    public String getClassType_row() {
        if ((this.classType != null) && (this.classType.indexOf("easyui-") >= 0)) {
            return this.classType.replaceAll("easyui-", "");
        }
        return this.classType_row;
    }

    public void setClassType_row(String classType_row) {
        this.classType_row = classType_row;
    }

    public String getCharmaxLength() {
        if ((this.charmaxLength == null) || ("0".equals(this.charmaxLength))) {
            return "";
        }
        return this.charmaxLength;
    }

    public void setCharmaxLength(String charmaxLength) {
        this.charmaxLength = charmaxLength;
    }

    public String getFieldDbName() {
        return this.fieldDbName;
    }

    public void setFieldDbName(String fieldDbName) {
        this.fieldDbName = fieldDbName;
    }
}
