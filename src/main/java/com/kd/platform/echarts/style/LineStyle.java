package com.kd.platform.echarts.style;

import com.kd.platform.echarts.code.LineType;

/**
 * <b>Application name:</b> LineStyle.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class LineStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 阳线颜色
     */
    private Object color;

    /**
     * 阴线颜色
     */
    private Object color0;

    /**
     * 线条样式，可选为：'solid' | 'dotted' | 'dashed'
     * @see com.kd.platform.echarts.code.LineType
     */
    private LineType type;

    /**
     * 线宽
     */
    private Integer width;

    /**
     * 折线主线(IE8+)有效，阴影色彩，支持rgba
     */
    private String shadowColor;

    /**
     * 默认值5，折线主线(IE8+)有效，阴影模糊度，大于0有效
     */
    private Integer shadowBlur;

    /**
     * 默认值3，折线主线(IE8+)有效，阴影横向偏移，正值往右，负值往左
     */
    private Integer shadowOffsetX;

    /**
     * 默认值3，折线主线(IE8+)有效，阴影纵向偏移，正值往下，负值往上
     */
    private Integer shadowOffsetY;

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
    public LineStyle color(Object color) {
        this.color = color;
        return this;
    }

    /**
     * 获取color0值
     */
    public Object color0() {
        return this.color0;
    }

    /**
     * 设置color0值
     * @param color0
     */
    public LineStyle color0(Object color0) {
        this.color0 = color0;
        return this;
    }

    /**
     * 获取type值
     */
    public LineType type() {
        return this.type;
    }

    /**
     * 设置type值
     * @param type
     */
    public LineStyle type(LineType type) {
        this.type = type;
        return this;
    }

    /**
     * 获取width值
     */
    public Integer width() {
        return this.width;
    }

    /**
     * 设置width值
     * @param width
     */
    public LineStyle width(Integer width) {
        this.width = width;
        return this;
    }

    /**
     * 获取shadowColor值
     */
    public String shadowColor() {
        return this.shadowColor;
    }

    /**
     * 设置shadowColor值
     * @param shadowColor
     */
    public LineStyle shadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
        return this;
    }

    /**
     * 获取shadowBlur值
     */
    public Integer shadowBlur() {
        return this.shadowBlur;
    }

    /**
     * 设置shadowBlur值
     * @param shadowBlur
     */
    public LineStyle shadowBlur(Integer shadowBlur) {
        this.shadowBlur = shadowBlur;
        return this;
    }

    /**
     * 获取shadowOffsetX值
     */
    public Integer shadowOffsetX() {
        return this.shadowOffsetX;
    }

    /**
     * 设置shadowOffsetX值
     * @param shadowOffsetX
     */
    public LineStyle shadowOffsetX(Integer shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
        return this;
    }

    /**
     * 获取shadowOffsetY值
     */
    public Integer shadowOffsetY() {
        return this.shadowOffsetY;
    }

    /**
     * 设置shadowOffsetY值
     * @param shadowOffsetY
     */
    public LineStyle shadowOffsetY(Integer shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
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
     * 获取color0值
     */
    public Object getColor0() {
        return color0;
    }

    /**
     * 设置color0值
     * @param color0
     */
    public void setColor0(Object color0) {
        this.color0 = color0;
    }

    /**
     * 获取type值
     */
    public LineType getType() {
        return type;
    }

    /**
     * 设置type值
     * @param type
     */
    public void setType(LineType type) {
        this.type = type;
    }

    /**
     * 获取width值
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 设置width值
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 获取shadowColor值
     */
    public String getShadowColor() {
        return shadowColor;
    }

    /**
     * 设置shadowColor值
     * @param shadowColor
     */
    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    /**
     * 获取shadowBlur值
     */
    public Integer getShadowBlur() {
        return shadowBlur;
    }

    /**
     * 设置shadowBlur值
     * @param shadowBlur
     */
    public void setShadowBlur(Integer shadowBlur) {
        this.shadowBlur = shadowBlur;
    }

    /**
     * 获取shadowOffsetX值
     */
    public Integer getShadowOffsetX() {
        return shadowOffsetX;
    }

    /**
     * 设置shadowOffsetX值
     * @param shadowOffsetX
     */
    public void setShadowOffsetX(Integer shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    /**
     * 获取shadowOffsetY值
     */
    public Integer getShadowOffsetY() {
        return shadowOffsetY;
    }

    /**
     * 设置shadowOffsetY值
     * @param shadowOffsetY
     */
    public void setShadowOffsetY(Integer shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }
}