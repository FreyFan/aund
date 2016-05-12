package com.kd.platform.web.system.pojo.base;

import java.util.List;
import java.util.Map;

/**
 * <b>Application name:</b> Client.java <br>
 * <b>Application describing: 在线用户对象</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-12 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Client implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private TSUser user;

    private Map<String, TSFunction> functions;

    private Map<Integer, List<TSFunction>> functionMap;

    public Map<Integer, List<TSFunction>> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<Integer, List<TSFunction>> functionMap) {
        this.functionMap = functionMap;
    }

    /**
     * 用户IP
     */
    private java.lang.String ip;

    /**
     * 登录时间
     */
    private java.util.Date logindatetime;

    public TSUser getUser() {
        return user;
    }

    public void setUser(TSUser user) {
        this.user = user;
    }

    public Map<String, TSFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(Map<String, TSFunction> functions) {
        this.functions = functions;
    }

    public java.lang.String getIp() {
        return ip;
    }

    public void setIp(java.lang.String ip) {
        this.ip = ip;
    }

    public java.util.Date getLogindatetime() {
        return logindatetime;
    }

    public void setLogindatetime(java.util.Date logindatetime) {
        this.logindatetime = logindatetime;
    }

}
