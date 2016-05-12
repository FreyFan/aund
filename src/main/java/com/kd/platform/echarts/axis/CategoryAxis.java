package com.kd.platform.echarts.axis;

import com.kd.platform.echarts.code.AxisType;

/**
 * <b>Application name:</b> CategoryAxis.java <br>
 * <b>Application describing:类目轴 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CategoryAxis extends Axis<CategoryAxis> {
    /**
     * [类目型]类目起始和结束两端空白策略，见下图，默认为true留空，false则顶头
     */
    private Boolean boundaryGap;

    /**
     * 获取boundaryGap值
     */
    public Boolean boundaryGap() {
        return this.boundaryGap;
    }

    /**
     * 设置boundaryGap值
     * @param boundaryGap
     */
    public CategoryAxis boundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
        return this;
    }

    /**
     * 构造函数
     */
    public CategoryAxis() {
        this.type(AxisType.category);
    }

    /**
     * 获取boundaryGap值
     */
    public Boolean getBoundaryGap() {
        return boundaryGap;
    }

    /**
     * 设置boundaryGap值
     * @param boundaryGap
     */
    public void setBoundaryGap(Boolean boundaryGap) {
        this.boundaryGap = boundaryGap;
    }
}
