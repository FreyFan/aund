package com.kd.platform.web.sms.service;
import java.util.Map;

import com.kd.platform.core.common.service.CommonService;

public interface TSSmsSqlServiceI extends CommonService{
	
    /**
     * getMap(这里用一句话描述这个方法的作用)
     * @Title: getMap
     * @Description: TODO
     * @param @param sql
     * @param @param map
     * @param @return 设定文件
     * @return Map<String,Object> 返回类型
     * @throws
     */
 	public Map<String, Object> getMap(String sql,Map<String, Object> map);
}
