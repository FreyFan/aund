package com.kd.platform.web.system.service.impl;

import com.kd.platform.web.system.pojo.base.TSRoleUser;
import com.kd.platform.web.system.pojo.base.TSUser;
import com.kd.platform.web.system.service.UserService;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.kd.platform.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>Application name:</b> UserServiceImpl.java <br>
 * <b>Application describing: 用户管理接口实现</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends CommonServiceImpl implements UserService {

    public TSUser checkUserExits(TSUser user) {
        return this.commonDao.getUserByUserIdAndUserNameExits(user);
    }

    public String getUserRole(TSUser user) {
        return this.commonDao.getUserRole(user);
    }

    public void pwdInit(TSUser user, String newPwd) {
        this.commonDao.pwdInit(user, newPwd);
    }

    public int getUsersOfThisRole(String id) {
        Criteria criteria = getSession().createCriteria(TSRoleUser.class);
        criteria.add(Restrictions.eq("TSRole.id", id));
        int allCounts = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        return allCounts;
    }

}
