package com.kd.platform.ws.server;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.web.system.service.SystemService;

public abstract class AbstractHandler implements Handler {

    public static SystemService systemService;

    /**
     * @param sql
     * @return JSONARRAY
     */
    public JSONArray getData(String sql) {
        List<Map<String, Object>> getSqlData = systemService.findForJdbc(sql);
        JSONArray returnJsonArray = new JSONArray();
        if (getSqlData != null && getSqlData.size() > 0) {
            for (int i = 0; i < getSqlData.size(); i++) {
                Map<String, ?> object = getSqlData.get(i);
                Iterator<String> iter = object.keySet().iterator();
                JSONObject jo = new JSONObject();
                while (iter.hasNext()) {
                    String key = iter.next();
                    LogUtil.info(key);
                    String value = object.get(key) == null ? "" : object.get(key).toString();
                    jo.put(key, value);
                }
                returnJsonArray.add(jo);
            }
            return returnJsonArray;
        } else {
            return returnJsonArray;
        }
    }

    public List<Map<String, Object>> getDataList(String sql) {
        List<Map<String, Object>> getSqlData = systemService.findForJdbc(sql);
        return getSqlData;
    }

    // select count(*) from ...
    public long getDataCount(String sql) {
        long num = systemService.getCountForJdbc(sql);
        return num;
    }

    public void executeSqlList(List<String> sqlList) {
        if (sqlList != null && sqlList.size() > 0) {
            for (String sql : sqlList) {
                systemService.executeSql(sql);
            }
        }
    }

    public int executeSql(String sql) {
        return systemService.executeSql(sql);
    }
}
