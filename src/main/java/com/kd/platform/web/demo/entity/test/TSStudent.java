package com.kd.platform.web.demo.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

@Entity
@Table(name = "T_S_STUDENT", schema = "PLATFORM")
public class TSStudent extends IdEntity implements java.io.Serializable {
    private String name;

    private String sex;

    private String className;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "CLASSNAME")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
