package com.kd.platform.echarts.axis;

import com.kd.platform.echarts.style.AreaStyle;

/**
 * <b>Application name:</b> SplitArea.java <br>
 * <b>Application describing: 分隔区域</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SplitArea implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 默认不显示，属性show控制显示与否
     */
    private Boolean show;

    /**
     * 属性areaStyle（详见areaStyle）控制区域样式
     * @see com.kd.platform.echarts.style.AreaStyle
     */
    private AreaStyle areaStyle;

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
    public SplitArea show(Boolean show) {
        this.show = show;
        return this;
    }

    /**
     * 设置areaStyle值
     * @param areaStyle
     */
    public SplitArea areaStyle(AreaStyle areaStyle) {
        this.areaStyle = areaStyle;
        return this;
    }

    /**
     * 属性areaStyle（详见areaStyle）控制区域样式
     * @see com.kd.platform.echarts.style.AreaStyle
     */
    public AreaStyle areaStyle() {
        if (this.areaStyle == null) {
            this.areaStyle = new AreaStyle();
        }
        return this.areaStyle;
    }

    /**
     * 获取areaStyle值
     */
    public AreaStyle getAreaStyle() {
        return areaStyle;
    }

    /**
     * 设置areaStyle值
     * @param areaStyle
     */
    public void setAreaStyle(AreaStyle areaStyle) {
        this.areaStyle = areaStyle;
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
}
