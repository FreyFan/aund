/*******************************************************************************
 * @(#)ClientTest.java 2015-6-17
 *
 * Copyright 2015 Frey.Fan. All rights reserved.
 *******************************************************************************/
package com.kd.platform.ws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import com.kd.platform.core.util.LogUtil;
import com.kd.platform.ws.server.ServicePortType;

/**
 * <b>Application name:</b> ClientTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-17 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ClientTest {

    @Test
    public void test() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ServicePortType.class);
        factory.setAddress("http://127.0.0.1:8080/platform/services/Service");
        ServicePortType client = (ServicePortType) factory.create();
        String packageName = "com.kd.platform.ws";
        String className = "ServerTest";
        String content = "{id1:11001}";
        String result = client.invoke(packageName, className, content);
        LogUtil.info("返回结果:" + result);
    }
}
