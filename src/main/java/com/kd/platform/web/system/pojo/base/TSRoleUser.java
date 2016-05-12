package com.kd.platform.web.system.pojo.base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * <b>Application name:</b> TSRoleUser.java <br>
 * <b>Application describing:角色用户关联表实体 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "T_S_ROLE_USER", schema = "PLATFORM")
public class TSRoleUser extends IdEntity implements java.io.Serializable {
    private TSUser TSUser;

    private TSRole TSRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USERID")
    public TSUser getTSUser() {
        return this.TSUser;
    }

    public void setTSUser(TSUser TSUser) {
        this.TSUser = TSUser;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLEID")
    public TSRole getTSRole() {
        return this.TSRole;
    }

    public void setTSRole(TSRole TSRole) {
        this.TSRole = TSRole;
    }
}
