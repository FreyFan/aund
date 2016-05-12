package com.kd.platform.web.cgform.service.button;

import java.util.List;

import com.kd.platform.web.cgform.entity.button.CgformButtonEntity;

import com.kd.platform.core.common.service.CommonService;

/**
 * @author Frey.Fan
 */
public interface CgformButtonServiceI extends CommonService {

    /**
     * 查询按钮list
     * @param formId
     * @return
     */
    public List<CgformButtonEntity> getCgformButtonListByFormId(String formId);

    /**
     * 校验按钮唯一性
     * @param cgformButtonEntity
     * @return
     */
    public List<CgformButtonEntity> checkCgformButton(CgformButtonEntity cgformButtonEntity);
}
