package com.kd.platform.web.system.pojo.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * TConfig entity. 系统配置类
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_CONFIG", schema = "PLATFORM")
public class TSConfig extends IdEntity implements java.io.Serializable {

    private TSUser TSUser;

    private String code;

    private String name;

    private String contents;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    public TSUser getTSUser() {
        return this.TSUser;
    }

    public void setTSUser(TSUser TSUser) {
        this.TSUser = TSUser;
    }

    @Column(name = "CODE", length = 100)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CONTENT", length = 300)
    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Column(name = "NOTE", length = 300)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
