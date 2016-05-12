package com.kd.platform.web.system.pojo.base;

import com.kd.platform.core.common.entity.IdEntity;

import javax.persistence.*;

/**
 * <b>Application name:</b> TSUserOrg.java <br>
 * <b>Application describing:用户-组织机构 实体 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "T_S_USER_ORG", schema = "PLATFORM")
public class TSUserOrg extends IdEntity implements java.io.Serializable {
    private TSUser tsUser;

    private TSDepart tsDepart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public TSUser getTsUser() {
        return tsUser;
    }

    public void setTsUser(TSUser tsDepart) {
        this.tsUser = tsDepart;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    public TSDepart getTsDepart() {
        return tsDepart;
    }

    public void setTsDepart(TSDepart tsDepart) {
        this.tsDepart = tsDepart;
    }
}
