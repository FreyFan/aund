package com.kd.platform.web.system.service;

import com.kd.platform.core.common.service.CommonService;
import com.kd.platform.web.system.pojo.base.TSCategoryEntity;

public interface CategoryServiceI extends CommonService {
    /**
     * 保存分类管理
     * @param category
     */
    void saveCategory(TSCategoryEntity category);

}
