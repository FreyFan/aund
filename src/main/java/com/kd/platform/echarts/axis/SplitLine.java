package com.kd.platform.echarts.axis;

import com.kd.platform.echarts.style.LineStyle;

/**
 * <b>Application name:</b> SplitLine.java <br>
 * <b>Application describing: 分隔线</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SplitLine implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认显示，属性show控制显示与否
     */
    private Boolean show;

    /**
     * 小标记是否显示为间隔，默认等于boundaryGap
     */
    private Boolean onGap;

    /**
     * 属性lineStyle（详见lineStyle）控制线条样式
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
    public SplitLine show(Boolean show) {
        this.show = show;
        return this;
    }

    /**
     * 获取onGap值
     */
    public Boolean onGap() {
        return this.onGap;
    }

    /**
     * 设置onGap值
     * @param onGap
     */
    public SplitLine onGap(Boolean onGap) {
        this.onGap = onGap;
        return this;
    }

    /**
     * 设置lineStyle值
     * @param lineStyle
     */
    public SplitLine lineStyle(LineStyle lineStyle) {
        this.lineStyle = lineStyle;
        return this;
    }

    /**
     * 属性lineStyle（详见lineStyle）控制线条样式
     * @see com.kd.platform.echarts.style.LineStyle
     */
    public LineStyle lineStyle() {
        if (this.lineStyle == null) {
            this.lineStyle = new LineStyle();
        }
        return this.lineStyle;
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
     * 获取onGap值
     */
    public Boolean getOnGap() {
        return onGap;
    }

    /**
     * 设置onGap值
     * @param onGap
     */
    public void setOnGap(Boolean onGap) {
        this.onGap = onGap;
    }
}
