package com.kd.platform.web.cgform.entity.category;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kd.platform.core.common.entity.IdEntity;
import com.kd.platform.web.cgform.entity.config.CgFormHeadEntity;
import com.kd.platform.web.system.pojo.base.TSCategoryEntity;

/**
 * Online Coding 分类管理
 * @author Frey.Fan
 * @date 2014年10月14日 下午10:23:08
 */
@Entity
@Table(name = "CGFORM_CATEGORY", schema = "PLATFORM")
public class CgformCategoryEntity extends IdEntity {
    /**
     * 表单
     */
    private CgFormHeadEntity form;

    /**
     * 分类
     */
    private TSCategoryEntity category;

    @ManyToOne(targetEntity = CgFormHeadEntity.class)
    @JoinColumn(name = "CGFORM_ID", referencedColumnName = "id")
    public CgFormHeadEntity getForm() {
        return form;
    }

    public void setForm(CgFormHeadEntity form) {
        this.form = form;
    }

    @ManyToOne(targetEntity = TSCategoryEntity.class)
    @JoinColumn(name = "CATEGORY_CODE", referencedColumnName = "code")
    public TSCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(TSCategoryEntity category) {
        this.category = category;
    }
}
