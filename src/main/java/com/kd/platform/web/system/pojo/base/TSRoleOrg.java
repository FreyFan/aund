package com.kd.platform.web.system.pojo.base;

import com.kd.platform.core.common.entity.IdEntity;

import javax.persistence.*;

/**
 * <b>Application name:</b> TSRoleOrg.java <br>
 * <b>Application describing: 角色-组织机构 实体</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "T_S_ROLE_ORG", schema = "PLATFORM")
public class TSRoleOrg extends IdEntity implements java.io.Serializable {
    private TSDepart tsDepart;

    private TSRole tsRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    public TSDepart getTsDepart() {
        return tsDepart;
    }

    public void setTsDepart(TSDepart tsDepart) {
        this.tsDepart = tsDepart;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    public TSRole getTsRole() {
        return tsRole;
    }

    public void setTsRole(TSRole tsRole) {
        this.tsRole = tsRole;
    }
}
