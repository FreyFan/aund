package com.kd.platform.web.system.pojo.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * TRoleFunction entity.
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_ROLE_FUNCTION", schema = "PLATFORM")
public class TSRoleFunction extends IdEntity implements java.io.Serializable {
    private TSFunction TSFunction;

    private TSRole TSRole;

    private String operation;

    private String dataRule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNCTIONID")
    public TSFunction getTSFunction() {
        return this.TSFunction;
    }

    public void setTSFunction(TSFunction TSFunction) {
        this.TSFunction = TSFunction;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLEID")
    public TSRole getTSRole() {
        return this.TSRole;
    }

    public void setTSRole(TSRole TSRole) {
        this.TSRole = TSRole;
    }

    @Column(name = "OPERATION", length = 100)
    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Column(name = "DATARULE", length = 100)
    public String getDataRule() {
        return dataRule;
    }

    public void setDataRule(String dataRule) {
        this.dataRule = dataRule;
    }
}
