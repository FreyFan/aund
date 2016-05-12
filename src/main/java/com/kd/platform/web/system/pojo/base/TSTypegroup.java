package com.kd.platform.web.system.pojo.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * <b>Application name:</b> TSTypegroup.java <br>
 * <b>Application describing:</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "T_S_TYPEGROUP", schema = "PLATFORM")
public class TSTypegroup extends IdEntity implements java.io.Serializable {
    public static Map<String, TSTypegroup> allTypeGroups = new HashMap<String, TSTypegroup>();

    public static Map<String, List<TSType>> allTypes = new HashMap<String, List<TSType>>();

    private String typegroupname;

    private String typegroupcode;

    private List<TSType> TSTypes = new ArrayList<TSType>();

    @Column(name = "TYPEGROUPNAME", length = 50)
    public String getTypegroupname() {
        return this.typegroupname;
    }

    public void setTypegroupname(String typegroupname) {
        this.typegroupname = typegroupname;
    }

    @Column(name = "TYPEGROUPCODE", length = 50)
    public String getTypegroupcode() {
        return this.typegroupcode;
    }

    public void setTypegroupcode(String typegroupcode) {
        this.typegroupcode = typegroupcode;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSTypegroup")
    public List<TSType> getTSTypes() {
        return this.TSTypes;
    }

    public void setTSTypes(List<TSType> TSTypes) {
        this.TSTypes = TSTypes;
    }
}
