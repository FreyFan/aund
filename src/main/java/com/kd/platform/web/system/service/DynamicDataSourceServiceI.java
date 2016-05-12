package com.kd.platform.web.system.service;

import java.util.List;

import com.kd.platform.core.common.service.CommonService;
import com.kd.platform.web.system.pojo.base.DynamicDataSourceEntity;

public interface DynamicDataSourceServiceI extends CommonService {

    public List<DynamicDataSourceEntity> initDynamicDataSource();

    public void refleshCache();
}
