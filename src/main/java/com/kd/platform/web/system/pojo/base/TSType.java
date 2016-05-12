package com.kd.platform.web.system.pojo.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * 通用类型字典表
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_TYPE", schema = "PLATFORM")
public class TSType extends IdEntity implements java.io.Serializable {

    private TSTypegroup TSTypegroup;// 类型分组

    private TSType TSType;// 父类型

    private String typename;// 类型名称

    private String typecode;// 类型编码

    private List<TSType> TSTypes = new ArrayList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPEGROUPID")
    public TSTypegroup getTSTypegroup() {
        return this.TSTypegroup;
    }

    public void setTSTypegroup(TSTypegroup TSTypegroup) {
        this.TSTypegroup = TSTypegroup;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPEPID")
    public TSType getTSType() {
        return this.TSType;
    }

    public void setTSType(TSType TSType) {
        this.TSType = TSType;
    }

    @Column(name = "TYPENAME", length = 50)
    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Column(name = "TYPECODE", length = 50)
    public String getTypecode() {
        return this.typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSType")
    public List<TSType> getTSTypes() {
        return this.TSTypes;
    }

    public void setTSTypes(List<TSType> TSTypes) {
        this.TSTypes = TSTypes;
    }
}
