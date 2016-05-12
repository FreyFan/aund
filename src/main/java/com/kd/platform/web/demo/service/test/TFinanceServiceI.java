package com.kd.platform.web.demo.service.test;

import com.kd.platform.web.demo.entity.test.TFinanceEntity;
import com.kd.platform.web.demo.entity.test.TFinanceFilesEntity;

import com.kd.platform.core.common.service.CommonService;

public interface TFinanceServiceI extends CommonService{

	void deleteFile(TFinanceFilesEntity file);

	void deleteFinance(TFinanceEntity finance);

}
