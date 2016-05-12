package com.kd.platform.web.system.pojo.base;

import org.codehaus.jackson.annotate.JsonIgnore;
import com.kd.platform.core.common.entity.IdEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户父类表
 * @author Frey.Fan
 */
@Entity
@Table(name = "T_S_BASE_USER", schema = "PLATFORM")
@Inheritance(strategy = InheritanceType.JOINED)
public class TSBaseUser extends IdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;// 用户名

    private String realName;// 真实姓名

    private String browser;// 用户使用浏览器类型

    private String userKey;// 用户验证唯一标示

    private String password;// 用户密码

    private Short activitiSync;// 是否同步工作流引擎

    private Short status;// 状态1：在线,2：离线,0：禁用

    private byte[] signature;// 签名文件

    // private TSDepart TSDepart = new TSDepart();// 部门
    private List<TSUserOrg> userOrgList = new ArrayList<TSUserOrg>();

    private TSDepart currentDepart = new TSDepart();// 当前部门

    @Column(name = "SIGNATURE", length = 3000)
    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    @Column(name = "BROWSER", length = 20)
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Column(name = "USERKEY", length = 200)
    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    @Column(name = "STATUS")
    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Column(name = "ACTIVITISYNC")
    public Short getActivitiSync() {
        return activitiSync;
    }

    public void setActivitiSync(Short activitiSync) {
        this.activitiSync = activitiSync;
    }

    @Column(name = "PASSWORD", length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // @JsonIgnore //getList查询转换为列表时处理json转换异常
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "departid")
    // public TSDepart getTSDepart() {
    // return this.TSDepart;
    // }
    //
    // public void setTSDepart(TSDepart TSDepart) {
    // this.TSDepart = TSDepart;
    // }
    @Column(name = "USERNAME", nullable = false, length = 10)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "REALNAME", length = 50)
    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Transient
    public TSDepart getCurrentDepart() {
        return currentDepart;
    }

    public void setCurrentDepart(TSDepart currentDepart) {
        this.currentDepart = currentDepart;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "tsUser")
    public List<TSUserOrg> getUserOrgList() {
        return userOrgList;
    }

    public void setUserOrgList(List<TSUserOrg> userOrgList) {
        this.userOrgList = userOrgList;
    }
}
