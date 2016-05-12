package com.kd.platform.web.system.pojo.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * 权限操作表
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_OPERATION", schema = "PLATFORM")
public class TSOperation extends IdEntity implements java.io.Serializable {
    private String operationname;

    private String operationcode;

    private String operationicon;

    private Short status;

    private TSIcon TSIcon = new TSIcon();

    private TSFunction TSFunction = new TSFunction();

    private Short operationType;

    @Column(name = "OPERATIONTYPE")
    public Short getOperationType() {
        return operationType;
    }

    public void setOperationType(Short operationType) {
        this.operationType = operationType;
    }

    @Column(name = "OPERATIONNAME", length = 50)
    public String getOperationname() {
        return this.operationname;
    }

    public void setOperationname(String operationname) {
        this.operationname = operationname;
    }

    @Column(name = "OPERATIONCODE", length = 50)
    public String getOperationcode() {
        return this.operationcode;
    }

    public void setOperationcode(String operationcode) {
        this.operationcode = operationcode;
    }

    @Column(name = "OPERATIONICON", length = 100)
    public String getOperationicon() {
        return this.operationicon;
    }

    public void setOperationicon(String operationicon) {
        this.operationicon = operationicon;
    }

    @Column(name = "STATUS")
    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ICONID")
    public TSIcon getTSIcon() {
        return TSIcon;
    }

    public void setTSIcon(TSIcon tSIcon) {
        TSIcon = tSIcon;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNCTIONID")
    public TSFunction getTSFunction() {
        return TSFunction;
    }

    public void setTSFunction(TSFunction tSFunction) {
        TSFunction = tSFunction;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return false;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TSOperation other = (TSOperation) obj;
        if (getId().equals(other.getId())) {
            return true;
        } else {
            return false;
        }
    }
}
