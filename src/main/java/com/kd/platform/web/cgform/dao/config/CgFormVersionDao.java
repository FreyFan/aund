package com.kd.platform.web.cgform.dao.config;

import org.springframework.stereotype.Repository;

import com.kd.platform.minidao.annotation.Arguments;
import com.kd.platform.web.cgform.entity.config.CgFormHeadEntity;

/**
 * @Title:CgFormFieldDao
 * @description:
 * @author Frey.Fan
 * @date Aug 24, 2013 11:33:33 AM
 * @version V1.0
 */
@Repository("cgFormVersionDao")
public interface CgFormVersionDao {
    @Arguments("tableName")
    public String getCgFormVersionByTableName(String tableName);

    @Arguments("id")
    public String getCgFormVersionById(String id);

    @Arguments({ "newVersion", "formId" })
    public void updateVersion(String newVersion, String formId);

    @Arguments({ "id" })
    public CgFormHeadEntity getCgFormById(String id);
}
