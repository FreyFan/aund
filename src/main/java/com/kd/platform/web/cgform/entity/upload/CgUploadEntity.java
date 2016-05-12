package com.kd.platform.web.cgform.entity.upload;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.kd.platform.web.system.pojo.base.TSAttachment;

/**
 * <b>Application name:</b> CgUploadEntity.java <br>
 * <b>Application describing: 智能表单文件上传</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-7 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Entity
@Table(name = "cgform_uploadfiles", schema = "PLATFORM")
@PrimaryKeyJoinColumn(name = "ID")
public class CgUploadEntity extends TSAttachment implements java.io.Serializable {

    /** 自定义表名 */
    private String cgformName;

    /** 自定义表的主键 */
    private String cgformId;

    /** 自定义表上传控件绑定字段 */
    private String cgformField;

    @Column(name = "CGFORM_ID", nullable = false, length = 36)
    public String getCgformId() {
        return cgformId;
    }

    public void setCgformId(String cgformId) {
        this.cgformId = cgformId;
    }

    @Column(name = "CGFORM_NAME", nullable = false, length = 100)
    public String getCgformName() {
        return cgformName;
    }

    public void setCgformName(String cgformName) {
        this.cgformName = cgformName;
    }

    @Column(name = "CGFORM_FIELD", nullable = false, length = 100)
    public String getCgformField() {
        return cgformField;
    }

    public void setCgformField(String cgformField) {
        this.cgformField = cgformField;
    }
}
