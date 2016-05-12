package com.kd.platform.web.demo.service.test;

import java.util.List;

import com.kd.platform.web.demo.entity.test.PlatformOrderCustomEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderMainEntity;
import com.kd.platform.web.demo.entity.test.PlatformOrderProductEntity;

import com.kd.platform.core.common.service.CommonService;


public interface PlatformOrderMainServiceI extends CommonService{
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(PlatformOrderMainEntity platformOrderMain,List<PlatformOrderProductEntity> platformOrderProducList,List<PlatformOrderCustomEntity> platformOrderCustomList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(PlatformOrderMainEntity platformOrderMain,List<PlatformOrderProductEntity> platformOrderProducList,List<PlatformOrderCustomEntity> platformOrderCustomList,boolean platformOrderCustomShow) ;
	public void delMain (PlatformOrderMainEntity platformOrderMain);
}
