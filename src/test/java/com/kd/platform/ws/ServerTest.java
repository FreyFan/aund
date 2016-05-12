package com.kd.platform.ws;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.ws.server.AbstractHandler;

public class ServerTest extends AbstractHandler {

    public String doHandler(String info) {

        LogUtil.info("收到的请求" + info);

        String hqlx = "select * from platform.t_s_timetask";

        JSONArray ja = new JSONArray();
        ja = getData(hqlx);
        LogUtil.info(ja.toString());

        String sql = "select count(*) from platform.t_s_timetask";
        long x = getDataCount(sql);
        LogUtil.info("x===" + x);

        List list = new ArrayList();
        String hql1 = "update platform.t_s_timetask set is_start=1 where id = '402880e74c79dd47014c79de88f70001'";
        String hql2 = "update platform.t_s_timetask set is_start=1 where id = '8a8ab0b246dc81120146dc81850c016a'";
        list.add(hql1);
        list.add(hql2);
        executeSqlList(list);

        return "test";
    }

}
