package com.kd.platform.echarts.axis;

import com.kd.platform.echarts.style.LineStyle;

/**
 * <b>Application name:</b> AxisLine.java <br>
 * <b>Application describing: 坐标轴线</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class AxisLine implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认显示，属性show控制显示与否
     */
    private Boolean show;

    /**
     * 定位到垂直方向的0值坐标上
     */
    private Boolean onZero;

    /**
     * {color: '#48b', width: 2, type: 'solid'}
     * @see com.kd.platform.echarts.style.LineStyle
     */
    private LineStyle lineStyle;

    /**
     * 获取show值
     */
    public Boolean show() {
        return this.show;
    }

    /**
     * 设置show值
     * @param show
     */
    public AxisLine show(Boolean show) {
        this.show = show;
        return this;
    }

    /**
     * 获取onZero值
     */
    public Boolean onZero() {
        return this.onZero;
    }

    /**
     * 设置onZero值
     * @param onZero
     */
    public AxisLine onZero(Boolean onZero) {
        this.onZero = onZero;
        return this;
    }

    /**
     * {color: '#48b', width: 2, type: 'solid'}
     * @see com.kd.platform.echarts.style.LineStyle
     */
    public LineStyle lineStyle() {
        if (this.lineStyle == null) {
            this.lineStyle = new LineStyle();
        }
        return this.lineStyle;
    }

    /**
     * 设置lineStyle值
     * @param lineStyle
     */
    public AxisLine lineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    /**
     * 获取lineStyle值
     */
    public LineStyle getLineStyle() {
        return lineStyle;
    }

    /**
     * 设置lineStyle值
     * @param lineStyle
     */
    public void setLineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
    }

    /**
     * 获取show值
     */
    public Boolean getShow() {
        return show;
    }

    /**
     * 设置show值
     * @param show
     */
    public void setShow(Boolean show) {
        this.show = show;
    }

    /**
     * 获取onZero值
     */
    public Boolean getOnZero() {
        return onZero;
    }

    /**
     * 设置onZero值
     * @param onZero
     */
    public void setOnZero(Boolean onZero) {
        this.onZero = onZero;
    }
}
