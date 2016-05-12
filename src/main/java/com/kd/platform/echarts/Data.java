package com.kd.platform.echarts;

/**
 * <b>Application name:</b> Data.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface Data<T> {
    /**
     * 添加元素
     * @param values
     * @return
     */
    T data(Object... values);
}
