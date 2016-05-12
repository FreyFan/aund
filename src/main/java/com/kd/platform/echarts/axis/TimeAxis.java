package com.kd.platform.echarts.axis;

import com.kd.platform.echarts.code.AxisType;

/**
 * <b>Application name:</b> TimeAxis.java <br>
 * <b>Application describing:时间型坐标轴用法同数值型，只是目标处理和格式化显示时会自动转变为时间，并且随着时间跨度的不同自动切换需要显示的时间粒度 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class TimeAxis extends ValueAxis {
    /**
     * 构造函数
     */
    public TimeAxis() {
        this.type(AxisType.time);
    }
}
