package com.kd.platform.web.demo.service.test;

import com.kd.platform.web.demo.entity.test.PlatformJdbcEntity;
import net.sf.json.JSONObject;

import com.kd.platform.core.common.model.json.DataGrid;
import com.kd.platform.core.common.service.CommonService;

public interface PlatformJdbcServiceI extends CommonService{
	public void getDatagrid1(PlatformJdbcEntity pageObj, DataGrid dataGrid);
	public void getDatagrid2(PlatformJdbcEntity pageObj, DataGrid dataGrid);
	public JSONObject getDatagrid3(PlatformJdbcEntity pageObj, DataGrid dataGrid);
	public void listAllByJdbc(DataGrid dataGrid);
}
