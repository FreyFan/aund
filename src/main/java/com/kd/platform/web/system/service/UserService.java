package com.kd.platform.web.system.service;

import com.kd.platform.core.common.service.CommonService;

import com.kd.platform.web.system.pojo.base.TSUser;

/**
 * <b>Application name:</b> UserService.java <br>
 * <b>Application describing: 用户管理业务接口</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface UserService extends CommonService {

    public TSUser checkUserExits(TSUser user);

    public String getUserRole(TSUser user);

    public void pwdInit(TSUser user, String newPwd);

    /**
     * 判断这个角色是不是还有用户使用
     * @Author Frey.Fan
     * @date 2013-11-12
     * @param id
     * @return
     */
    public int getUsersOfThisRole(String id);
}
