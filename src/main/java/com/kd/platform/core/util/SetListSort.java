package com.kd.platform.core.util;

import java.util.Comparator;

import com.kd.platform.web.system.pojo.base.TSFunction;

/**
 * <b>Application name:</b> SetListSort.java <br>
 * <b>Application describing: int比较器</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-29 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SetListSort implements Comparator {
    /**
     * 菜单排序比较器
     */
    public int compare(Object o1, Object o2) {
        TSFunction c1 = (TSFunction) o1;
        TSFunction c2 = (TSFunction) o2;
        if (c1.getFunctionOrder() != null && c2.getFunctionOrder() != null) {
            int c1order = oConvertUtils.getInt(c1.getFunctionOrder().substring(c1.getFunctionOrder().indexOf("fun") + 3));
            int c2order = oConvertUtils.getInt(c2.getFunctionOrder().substring(c2.getFunctionOrder().indexOf("fun")) + 3);
            if (c1order > c2order) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }
}
