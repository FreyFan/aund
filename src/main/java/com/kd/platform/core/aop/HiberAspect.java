package com.kd.platform.core.aop;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import com.kd.platform.core.constant.DataBaseConstant;
import com.kd.platform.core.util.ResourceUtil;
import com.kd.platform.core.util.oConvertUtils;
import com.kd.platform.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>Application name:</b> HiberAspect.java <br>
 * <b>Application describing: Hiberate拦截器：实现创建人，创建时间，创建人名称自动注入; 修改人,修改时间,修改人名自动注入;</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@Component
public class HiberAspect extends EmptyInterceptor {
    private static final Logger logger = Logger.getLogger(HiberAspect.class);

    private static final long serialVersionUID = 1L;

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        TSUser currentUser = null;
        try {
            currentUser = ResourceUtil.getSessionUserName();
        } catch (RuntimeException e) {
            logger.warn("当前session为空,无法获取用户");
        }
        if (currentUser == null) {
            return true;
        }
        try {
            // 添加数据
            for (int index = 0; index < propertyNames.length; index++) {
                /* 找到名为"创建时间"的属性 */
                if (DataBaseConstant.CREATE_DATE.equals(propertyNames[index]) || DataBaseConstant.CREATE_TIME.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建时间"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = new Date();
                    }
                    continue;
                }
                /* 找到名为"创建人"的属性 */
                else if (DataBaseConstant.CREATE_BY.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建人"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_USER_CODE);
                    }
                    continue;
                }
                /* 找到名为"创建人名称"的属性 */
                else if (DataBaseConstant.CREATE_NAME.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建人名称"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_USER_NAME);
                    }
                    continue;
                }
                /* 找到名为"创建人名称"的属性 */
                else if (DataBaseConstant.SYS_USER_CODE.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建人名称"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_USER_CODE);
                    }
                    continue;
                }
                /* 找到名为"创建人部门"的属性 */
                else if (DataBaseConstant.SYS_ORG_CODE.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建人部门"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_ORG_CODE);
                    }
                    continue;
                }
                /* 找到名为"创建人部门"的属性 */
                else if (DataBaseConstant.SYS_COMPANY_CODE.equals(propertyNames[index])) {
                    /* 使用拦截器将对象的"创建人部门"属性赋上值 */
                    if (oConvertUtils.isEmpty(state[index])) {
                        state[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_COMPANY_CODE);
                    }
                    continue;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        TSUser currentUser = null;
        try {
            currentUser = ResourceUtil.getSessionUserName();
        } catch (RuntimeException e1) {
            logger.warn("当前session为空,无法获取用户");
        }
        if (currentUser == null) {
            return true;
        }
        // 添加数据
        for (int index = 0; index < propertyNames.length; index++) {
            /* 找到名为"修改时间"的属性 */
            if (DataBaseConstant.UPDATE_DATE.equals(propertyNames[index]) || DataBaseConstant.UPDATE_TIME.equals(propertyNames[index])) {
                /* 使用拦截器将对象的"修改时间"属性赋上值 */
                currentState[index] = new Date();
                continue;
            }
            /* 找到名为"修改人"的属性 */
            else if (DataBaseConstant.UPDATE_BY.equals(propertyNames[index])) {
                /* 使用拦截器将对象的"修改人"属性赋上值 */
                currentState[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_USER_CODE);
                continue;
            }
            /* 找到名为"修改人名称"的属性 */
            else if (DataBaseConstant.UPDATE_NAME.equals(propertyNames[index])) {
                /* 使用拦截器将对象的"修改人名称"属性赋上值 */
                currentState[index] = ResourceUtil.getUserSystemData(DataBaseConstant.SYS_USER_NAME);
                continue;
            }
        }
        return true;
    }
}
