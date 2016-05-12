package com.kd.platform.web.system.pojo.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * TType entity.
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_OPINTEMPLATE", schema = "PLATFORM")
public class TSOpinTemplate extends IdEntity implements java.io.Serializable {
    private String descript;

    @Column(name = "DESCRIPT", length = 100)
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
