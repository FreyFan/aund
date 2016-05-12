package com.kd.platform.echarts;

import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.code.Y;

import java.io.Serializable;

/**
 * <b>Application name:</b> Basic.java <br>
 * <b>Application describing: 组件的基础类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public abstract class Basic<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否显示
     */
    private Boolean show;

    /**
     * 水平安放位置，默认为左侧，可选为：'center' | 'left' | 'right' | {number}（x坐标，单位px）
     * @see com.kd.platform.echarts.code.X
     */
    private Object x;

    /**
     * 垂直安放位置，默认为全图顶端，可选为：'top' | 'bottom' | 'center' | {number}（y坐标，单位px）
     * @see com.kd.platform.echarts.code.Y
     */
    private Object y;

    /**
     * 标题背景颜色，默认透明
     */
    private String backgroundColor;

    /**
     * 标题边框颜色
     */
    private String borderColor;

    /**
     * borderWidth
     */
    private Integer borderWidth;

    /**
     * 标题内边距，单位px，默认各方向内边距为5，接受数组分别设定上右下左边距，同css，见下图
     */
    private Object padding;

    /**
     * 主副标题纵向间隔，单位px，默认为10
     */
    private Integer itemGap;

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
    public T show(Boolean show) {
        this.show = show;
        return (T) this;
    }

    /**
     * 获取x值
     */
    public Object x() {
        return this.x;
    }

    /**
     * 设置x值
     * @param x
     */
    public T x(Object x) {
        this.x = x;
        return (T) this;
    }

    /**
     * 获取y值
     */
    public Object y() {
        return this.y;
    }

    /**
     * 设置y值
     * @param y
     */
    public T y(Object y) {
        this.y = y;
        return (T) this;
    }

    /**
     * 获取backgroundColor值
     */
    public String backgroundColor() {
        return this.backgroundColor;
    }

    /**
     * 设置backgroundColor值
     * @param backgroundColor
     */
    public T backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return (T) this;
    }

    /**
     * 获取borderColor值
     */
    public String borderColor() {
        return this.borderColor;
    }

    /**
     * 设置borderColor值
     * @param borderColor
     */
    public T borderColor(String borderColor) {
        this.borderColor = borderColor;
        return (T) this;
    }

    /**
     * 获取borderWidth值
     */
    public Integer borderWidth() {
        return this.borderWidth;
    }

    /**
     * 设置borderWidth值
     * @param borderWidth
     */
    public T borderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return (T) this;
    }

    /**
     * 获取padding值
     */
    public Object padding() {
        return this.padding;
    }

    /**
     * 设置padding值
     * @param padding
     */
    public T padding(Integer padding) {
        this.padding = padding;
        return (T) this;
    }

    /**
     * 设置padding值
     * @param padding
     */
    public T padding(Integer... padding) {
        if (padding != null && padding.length > 4) {
            throw new RuntimeException("padding属性最多可以接收4个参数!");
        }
        this.padding = padding;
        return (T) this;
    }

    /**
     * 获取itemGap值
     */
    public Integer itemGap() {
        return this.itemGap;
    }

    /**
     * 设置itemGap值
     * @param itemGap
     */
    public T itemGap(Integer itemGap) {
        this.itemGap = itemGap;
        return (T) this;
    }

    /**
     * 设置x值
     * @param x
     */
    public T x(X x) {
        this.x = x;
        return (T) this;
    }

    /**
     * 设置y值
     * @param y
     */
    public T y(Y y) {
        this.y = y;
        return (T) this;
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
     * 获取x值
     */
    public Object getX() {
        return x;
    }

    /**
     * 设置x值
     * @param x
     */
    public void setX(Object x) {
        this.x = x;
    }

    /**
     * 获取y值
     */
    public Object getY() {
        return y;
    }

    /**
     * 设置y值
     * @param y
     */
    public void setY(Object y) {
        this.y = y;
    }

    /**
     * 获取backgroundColor值
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 设置backgroundColor值
     * @param backgroundColor
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * 获取borderColor值
     */
    public String getBorderColor() {
        return borderColor;
    }

    /**
     * 设置borderColor值
     * @param borderColor
     */
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * 获取borderWidth值
     */
    public Integer getBorderWidth() {
        return borderWidth;
    }

    /**
     * 设置borderWidth值
     * @param borderWidth
     */
    public void setBorderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
    }

    /**
     * 获取padding值
     */
    public Object getPadding() {
        return padding;
    }

    /**
     * 设置padding值
     * @param padding
     */
    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    /**
     * 获取itemGap值
     */
    public Integer getItemGap() {
        return itemGap;
    }

    /**
     * 设置itemGap值
     * @param itemGap
     */
    public void setItemGap(Integer itemGap) {
        this.itemGap = itemGap;
    }

    public void setPadding(Object padding) {
        this.padding = padding;
    }
}