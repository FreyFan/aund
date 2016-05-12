package com.kd.platform.echarts.style;

/**
 * <b>Application name:</b> AreaStyle.java <br>
 * <b>Application describing: 区域填充样式</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class AreaStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 颜色
     */
    private Object color;

    /**
     * 填充样式，目前仅支持'default'(实填充)
     */
    private Object type;

    /**
     * 获取color值
     */
    public Object color() {
        return this.color;
    }

    /**
     * 设置color值
     * @param color
     */
    public AreaStyle color(Object color) {
        this.color = color;
        return this;
    }

    /**
     * 获取type值
     */
    public Object type() {
        return this.type;
    }

    /**
     * 设置type值
     * @param type
     */
    public AreaStyle type(Object type) {
        this.type = type;
        return this;
    }

    /**
     * 获取typeDefault值
     */
    public AreaStyle typeDefault() {
        this.type = "default";
        return this;
    }

    /**
     * 获取color值
     */
    public Object getColor() {
        return color;
    }

    /**
     * 设置color值
     * @param color
     */
    public void setColor(Object color) {
        this.color = color;
    }

    /**
     * 获取type值
     */
    public Object getType() {
        return type;
    }

    /**
     * 设置type值
     * @param type
     */
    public void setType(Object type) {
        this.type = type;
    }
}
