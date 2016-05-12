package com.kd.platform.echarts.data;

import com.kd.platform.echarts.Tooltip;
import com.kd.platform.echarts.style.ItemStyle;

/**
 * <b>Application name:</b> SeriesData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SeriesData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Object value;

    private Tooltip tooltip;

    private ItemStyle itemStyle;

    /**
     * 构造函数,参数:value
     * @param value
     */
    public SeriesData(Object value) {
        this.value = value;
    }

    /**
     * 构造函数,参数:value,tooltip
     * @param value
     * @param tooltip
     */
    public SeriesData(Object value, Tooltip tooltip) {
        this.value = value;
        this.tooltip = tooltip;
    }

    /**
     * 构造函数,参数:value,itemStyle
     * @param value
     * @param itemStyle
     */
    public SeriesData(Object value, ItemStyle itemStyle) {
        this.value = value;
        this.itemStyle = itemStyle;
    }

    /**
     * 构造函数,参数:value,tooltip,itemStyle
     * @param value
     * @param tooltip
     * @param itemStyle
     */
    public SeriesData(Object value, Tooltip tooltip, ItemStyle itemStyle) {
        this.value = value;
        this.tooltip = tooltip;
        this.itemStyle = itemStyle;
    }

    /**
     * 获取value值
     */
    public Object value() {
        return this.value;
    }

    /**
     * 设置value值
     * @param value
     */
    public SeriesData value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * 获取tooltip值
     */
    public Tooltip tooltip() {
        if (this.tooltip == null) {
            this.tooltip = new Tooltip();
        }
        return this.tooltip;
    }

    /**
     * 设置tooltip值
     * @param tooltip
     */
    public SeriesData tooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    /**
     * 获取itemStyle值
     */
    public ItemStyle itemStyle() {
        if (this.itemStyle == null) {
            this.itemStyle = new ItemStyle();
        }
        return this.itemStyle;
    }

    /**
     * 设置itemStyle值
     * @param itemStyle
     */
    public SeriesData itemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public ItemStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }
}
