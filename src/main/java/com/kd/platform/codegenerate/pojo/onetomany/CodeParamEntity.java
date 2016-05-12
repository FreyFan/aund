package com.kd.platform.codegenerate.pojo.onetomany;

import java.util.List;

/**
 * <b>Application name:</b> CodeParamEntity.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CodeParamEntity {
    private String entityPackage;

    private String tableName;

    private String entityName;

    private String ftlDescription;

    private String primaryKeyPolicy;

    private String sequenceCode;

    private String ftl_mode = "A";

    List<SubTableEntity> subTabParam;

    public List<SubTableEntity> getSubTabParam() {
        return this.subTabParam;
    }

    public void setSubTabParam(List<SubTableEntity> subTabParam) {
        this.subTabParam = subTabParam;
    }

    public String getEntityPackage() {
        return this.entityPackage;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public String getFtlDescription() {
        return this.ftlDescription;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public void setFtlDescription(String ftlDescription) {
        this.ftlDescription = ftlDescription;
    }

    public String getFtl_mode() {
        return this.ftl_mode;
    }

    public void setFtl_mode(String ftl_mode) {
        this.ftl_mode = ftl_mode;
    }

    public String getPrimaryKeyPolicy() {
        return this.primaryKeyPolicy;
    }

    public String getSequenceCode() {
        return this.sequenceCode;
    }

    public void setPrimaryKeyPolicy(String primaryKeyPolicy) {
        this.primaryKeyPolicy = primaryKeyPolicy;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }
}
