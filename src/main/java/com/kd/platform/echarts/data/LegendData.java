package com.kd.platform.echarts.data;

import com.kd.platform.echarts.style.TextStyle;

/**
 * <b>Application name:</b> LegendData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class LegendData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;

    /**
     * 文字样式
     * @see com.kd.platform.echarts.style.TextStyle
     */
    private TextStyle textStyle;

    /**
     * 图标
     */
    private String icon;

    /**
     * 构造函数,参数:name
     * @param name
     */
    public LegendData(String name) {
        this.name = name;
    }

    /**
     * 构造函数,参数:name,textStyle
     * @param name
     * @param textStyle
     */
    public LegendData(String name, TextStyle textStyle) {
        this.name = name;
        this.textStyle = textStyle;
    }

    /**
     * 构造函数,参数:name,textStyle,icon
     * @param name
     * @param textStyle
     * @param icon
     */
    public LegendData(String name, TextStyle textStyle, String icon) {
        this.name = name;
        this.textStyle = textStyle;
        this.icon = icon;
    }

    /**
     * 获取name值
     */
    public String name() {
        return this.name;
    }

    /**
     * 设置name值
     * @param name
     */
    public LegendData name(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取textStyle值
     */
    public TextStyle textStyle() {
        if (this.textStyle == null) {
            this.textStyle = new TextStyle();
        }
        return this.textStyle;
    }

    /**
     * 设置textStyle值
     * @param textStyle
     */
    public LegendData textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    /**
     * 获取icon值
     */
    public String icon() {
        return this.icon;
    }

    /**
     * 设置icon值
     * @param icon
     */
    public LegendData icon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 获取name值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name值
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取textStyle值
     */
    public TextStyle getTextStyle() {
        return textStyle;
    }

    /**
     * 设置textStyle值
     * @param textStyle
     */
    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }

    /**
     * 获取icon值
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置icon值
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
