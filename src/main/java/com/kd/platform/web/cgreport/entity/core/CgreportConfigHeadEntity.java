package com.kd.platform.web.cgreport.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 动态报表配置抬头
 * @author Frey.Fan
 * @date 2013-12-07 16:00:21
 * @version V1.0
 */
@Entity
@Table(name = "JFORM_CGREPORT_HEAD", schema = "PLATFORM")
public class CgreportConfigHeadEntity implements java.io.Serializable {
    /** 主键 */
    private java.lang.String id;

    /** 编码 */
    private java.lang.String code;

    /** 名称 */
    private java.lang.String name;

    /** 查询数据SQL */
    private java.lang.String cgrSql;

    /** 描述 */
    private java.lang.String content;

    /** 创建时间 */
    private java.util.Date createDate;

    /** 创建人ID */
    private java.lang.String createBy;

    /** 创建人名称 */
    private java.lang.String createName;

    /** 修改时间 */
    private java.util.Date updateDate;

    /** 修改人 */
    private java.lang.String updateBy;

    /** 修改人名称 */
    private java.lang.String updateName;

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 36)
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 主键
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 编码
     */
    @Column(name = "CODE", nullable = false, length = 36)
    public java.lang.String getCode() {
        return this.code;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 编码
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 名称
     */
    @Column(name = "NAME", nullable = false, length = 100)
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 名称
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 查询数据SQL
     */
    @Column(name = "CGR_SQL", nullable = false, length = 2000)
    public java.lang.String getCgrSql() {
        return this.cgrSql;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 查询数据SQL
     */
    public void setCgrSql(java.lang.String cgrSql) {
        this.cgrSql = cgrSql;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 描述
     */
    @Column(name = "CONTENT", nullable = false, length = 1000)
    public java.lang.String getContent() {
        return this.content;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 描述
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    /**
     * 方法: 取得java.util.Date
     * @return: java.util.Date 创建时间
     */
    @Column(name = "CREATE_DATE", nullable = true)
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     * @param: java.util.Date 创建时间
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 创建人ID
     */
    @Column(name = "CREATE_BY", nullable = true, length = 32)
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 创建人ID
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 创建人名称
     */
    @Column(name = "CREATE_NAME", nullable = true, length = 32)
    public java.lang.String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 创建人名称
     */
    public void setCreateName(java.lang.String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.util.Date
     * @return: java.util.Date 修改时间
     */
    @Column(name = "UPDATE_DATE", nullable = true)
    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     * @param: java.util.Date 修改时间
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 修改人ID
     */
    @Column(name = "UPDATE_BY", nullable = true, length = 32)
    public java.lang.String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 修改人ID
     */
    public void setUpdateBy(java.lang.String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.lang.String
     * @return: java.lang.String 修改人名称
     */
    @Column(name = "UPDATE_NAME", nullable = true, length = 32)
    public java.lang.String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     * @param: java.lang.String 修改人名称
     */
    public void setUpdateName(java.lang.String updateName) {
        this.updateName = updateName;
    }
}
