package com.kd.platform.echarts.style;

import com.kd.platform.echarts.code.FontStyle;
import com.kd.platform.echarts.code.X;

/**
 * <b>Application name:</b> TextStyle.java <br>
 * <b>Application describing:文字样式 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class TextStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 颜色
     */
    private String color;

    /**
     * 修饰，仅对tooltip.textStyle生效
     */
    private String decoration;

    /**
     * 水平对齐方式，可选为：'left' | 'right' | 'center'
     * @see com.kd.platform.echarts.code.X
     */
    private X align;

    /**
     * 字号 ，单位px
     */
    private Integer fontSize = 20;

    /**
     * 字体系列
     */
    private String fontFamily = "微软雅黑";

    /**
     * 字体系列 IE8- 字体模糊并且，不支持不同字体混排，额外指定一份
     */
    private String fontFamily2;

    /**
     * 样式，可选为：'normal' | 'italic' | 'oblique'
     */
    private FontStyle fontStyle = FontStyle.normal;

    /**
     * 粗细，可选为：'normal' | 'bold' | 'bolder' | 'lighter' | 100 | 200 |... | 900
     * @see com.kd.platform.echarts.code.FontWeight
     */
    private Object fontWeight = "bold";

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
    public TextStyle color(String color) {
        this.color = color;
        return this;
    }

    /**
     * 获取decoration值
     */
    public String decoration() {
        return this.decoration;
    }

    /**
     * 设置decoration值
     * @param decoration
     */
    public TextStyle decoration(String decoration) {
        this.decoration = decoration;
        return this;
    }

    /**
     * 获取align值
     */
    public X align() {
        return this.align;
    }

    /**
     * 设置align值
     * @param align
     */
    public TextStyle align(X align) {
        this.align = align;
        return this;
    }

    /**
     * 获取fontSize值
     */
    public Integer fontSize() {
        return this.fontSize;
    }

    /**
     * 设置fontSize值
     * @param fontSize
     */
    public TextStyle fontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * 获取fontFamily值
     */
    public String fontFamily() {
        return this.fontFamily;
    }

    /**
     * 设置fontFamily值
     * @param fontFamily
     */
    public TextStyle fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * 获取fontFamily2值
     */
    public String fontFamily2() {
        return this.fontFamily2;
    }

    /**
     * 设置fontFamily2值
     * @param fontFamily2
     */
    public TextStyle fontFamily2(String fontFamily2) {
        this.fontFamily2 = fontFamily2;
        return this;
    }

    /**
     * 获取fontStyle值
     */
    public FontStyle fontStyle() {
        return this.fontStyle;
    }

    /**
     * 设置fontStyle值
     * @param fontStyle
     */
    public TextStyle fontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * 获取fontWeight值
     */
    public Object fontWeight() {
        return this.fontWeight;
    }

    /**
     * 设置fontWeight值
     * @param fontWeight
     */
    public TextStyle fontWeight(Object fontWeight) {
        this.fontWeight = fontWeight;
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
     * 获取decoration值
     */
    public String getDecoration() {
        return decoration;
    }

    /**
     * 设置decoration值
     * @param decoration
     */
    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    /**
     * 获取align值
     */
    public X getAlign() {
        return align;
    }

    /**
     * 设置align值
     * @param align
     */
    public void setAlign(X align) {
        this.align = align;
    }

    /**
     * 获取fontSize值
     */
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * 设置fontSize值
     * @param fontSize
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * 获取fontFamily值
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * 设置fontFamily值
     * @param fontFamily
     */
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    /**
     * 获取fontFamily2值
     */
    public String getFontFamily2() {
        return fontFamily2;
    }

    /**
     * 设置fontFamily2值
     * @param fontFamily2
     */
    public void setFontFamily2(String fontFamily2) {
        this.fontFamily2 = fontFamily2;
    }

    /**
     * 获取fontStyle值
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * 设置fontStyle值
     * @param fontStyle
     */
    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * 获取fontWeight值
     */
    public Object getFontWeight() {
        return fontWeight;
    }

    /**
     * 设置fontWeight值
     * @param fontWeight
     */
    public void setFontWeight(Object fontWeight) {
        this.fontWeight = fontWeight;
    }
}