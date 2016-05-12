package com.kd.platform.echarts.style;

import com.kd.platform.echarts.code.LinkType;

/**
 * <b>Application name:</b> LinkStyle.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class LinkStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 线条类型，可选为：'curve'（曲线） | 'line'（直线）
     */
    private LinkType type;

    /**
     * 线条颜色
     */
    private String borderColor;

    /**
     * 线宽
     */
    private Integer borderWidth;

    /**
     * 获取type值
     */
    public LinkType type() {
        return this.type;
    }

    /**
     * 设置type值
     * @param type
     */
    public LinkStyle type(LinkType type) {
        this.type = type;
        return this;
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
    public LinkStyle borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
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
    public LinkStyle borderWidth(Integer borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * 获取type值
     */
    public LinkType getType() {
        return type;
    }

    /**
     * 设置type值
     * @param type
     */
    public void setType(LinkType type) {
        this.type = type;
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
}
