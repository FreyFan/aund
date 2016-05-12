package com.kd.platform.web.system.pojo.base;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;

/**
 * <b>Application name:</b> TSAttachment.java <br>
 * <b>Application describing: 项目附件父表(其他附件表需继承该表)</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "T_S_ATTACHMENT", schema = "PLATFORM")
@Inheritance(strategy = InheritanceType.JOINED)
public class TSAttachment extends IdEntity implements java.io.Serializable {

    /**
     * （用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 1L;

    private TSUser TSUser;// 创建人

    private String businessKey;// 业务类主键

    private String subclassname;// 子类名称全路径

    private String attachmenttitle;// 附件名称

    private byte[] attachmentcontent;// 附件内容

    private String realpath;// 附件物理路径

    private Timestamp createdate;

    private String note;

    private String swfpath;// swf格式路径

    private String extend;// 扩展名

    @Column(name = "EXTEND", length = 32)
    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    public TSUser getTSUser() {
        return this.TSUser;
    }

    public void setTSUser(TSUser TSUser) {
        this.TSUser = TSUser;
    }

    @Column(name = "BUSINESSKEY", length = 32)
    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @Column(name = "ATTACHMENTTITLE", length = 100)
    public String getAttachmenttitle() {
        return this.attachmenttitle;
    }

    public void setAttachmenttitle(String attachmenttitle) {
        this.attachmenttitle = attachmenttitle;
    }

    @Column(name = "ATTACHMENTCONTENT", length = 3000)
    @Lob
    public byte[] getAttachmentcontent() {
        return this.attachmentcontent;
    }

    public void setAttachmentcontent(byte[] attachmentcontent) {
        this.attachmentcontent = attachmentcontent;
    }

    @Column(name = "REALPATH", length = 100)
    public String getRealpath() {
        return this.realpath;
    }

    public void setRealpath(String realpath) {
        this.realpath = realpath;
    }

    @Column(name = "CREATEDATE", length = 35)
    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    @Column(name = "NOTE", length = 300)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "SWFPATH", length = 300)
    public String getSwfpath() {
        return this.swfpath;
    }

    public void setSwfpath(String swfpath) {
        this.swfpath = swfpath;
    }

    @Column(name = "SUBCLASSNAME", length = 300)
    public String getSubclassname() {
        return subclassname;
    }

    public void setSubclassname(String subclassname) {
        this.subclassname = subclassname;
    }
}
