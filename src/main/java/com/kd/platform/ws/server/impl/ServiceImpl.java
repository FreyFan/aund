package com.kd.platform.ws.server.impl;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.ws.server.Handler;
import com.kd.platform.ws.server.ServicePortType;

public class ServiceImpl implements ServicePortType {

    public String invoke(String path, String className, String data) {
        Handler handler = this.getHander(path, className);
        String sStr = handler.doHandler(data);
        return sStr;
    }

    private Handler getHander(String path, String className) {
        try {
            Object object = Class.forName(path + "." + className).newInstance();
            return (Handler) object;
        } catch (Exception e) {
            LogUtil.error("not instance handler " + path, e);
        }
        return null;
    }
}
