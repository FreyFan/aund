package com.kd.platform.web.cgform.service.button;

import java.util.List;

import com.kd.platform.core.common.service.CommonService;
import com.kd.platform.web.cgform.entity.button.CgformButtonSqlEntity;

public interface CgformButtonSqlServiceI extends CommonService {

    /**
     * 校验按钮sql增强唯一性
     * @param cgformButtonEntity
     * @return
     */
    public List<CgformButtonSqlEntity> checkCgformButtonSql(CgformButtonSqlEntity cgformButtonSqlEntity);

    /**
     * 根据buttonCode和formId初始化数据
     * @param buttonCode
     * @param formId
     * @return
     */
    public CgformButtonSqlEntity getCgformButtonSqlByCodeFormId(String buttonCode, String formId);
}