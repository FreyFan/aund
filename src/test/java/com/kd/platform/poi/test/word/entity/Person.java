package com.kd.platform.poi.test.word.entity;

import com.kd.platform.poi.excel.annotation.Excel;

/**
 * 测试人员类
 * @author Frey.Fan
 * @date 2014年7月26日 下午10:51:30
 */
public class Person {

    @Excel(name = "姓名")
    private String name;
    @Excel(name = "手机")
    private String tel;
    @Excel(name = "Email")
    private String email;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
