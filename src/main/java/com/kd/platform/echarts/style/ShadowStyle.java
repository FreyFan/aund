package com.kd.platform.echarts.style;

/**
 * <b>Application name:</b> ShadowStyle.java <br>
 * <b>Application describing: 阴影指示器样式设置</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ShadowStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 阴影颜色
     */
    private String color;

    /**
     * 默认auto，阴影大小
     */
    private Object width;

    /**
     * 填充方式，默认只有default
     */
    private String type;

    /**
     * 获取color值
     */
    public String color() {
        return this.color;
    }

    /**
     * 设置color值
     * @param color
     */
    public ShadowStyle color(String color) {
        this.color = color;
        return this;
    }

    /**
     * 获取width值
     */
    public Object width() {
        return this.width;
    }

    /**
     * 设置width值
     * @param width
     */
    public ShadowStyle width(Object width) {
        this.width = width;
        return this;
    }

    /**
     * 获取type值
     */
    public String type() {
        return this.type;
    }

    /**
     * 设置type值
     * @param type
     */
    public ShadowStyle type(String type) {
        this.type = type;
        return this;
    }

    /**
     * 获取typeDefault值
     */
    public ShadowStyle typeDefault() {
        this.type = "default";
        return this;
    }

    /**
     * 获取color值
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置color值
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取width值
     */
    public Object getWidth() {
        return width;
    }

    /**
     * 设置width值
     * @param width
     */
    public void setWidth(Object width) {
        this.width = width;
    }

    /**
     * 获取type值
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type值
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
