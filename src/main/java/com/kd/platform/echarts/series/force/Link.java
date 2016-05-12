package com.kd.platform.echarts.series.force;

import com.kd.platform.echarts.style.ItemStyle;

/**
 * <b>Application name:</b> Link.java <br>
 * <b>Application describing: 力导向图的边数据</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Link implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 源节点的index或者源节点的name
     */
    private Object source;

    /**
     * 目标节点的index或者目标节点的name
     */
    private Object target;

    /**
     * 边的权重，权重越大邻接节点越靠拢
     */
    private Integer weight;

    /**
     * 详见 itemStyle, 只能设置 lineWidth, strokeColor, lineType 等描边的属性
     */
    private ItemStyle itemStyle;

    /**
     * 构造函数
     */
    public Link() {
    }

    /**
     * 构造函数,参数:source,target,weight
     * @param source
     * @param target
     * @param weight
     */
    public Link(Object source, Object target, Integer weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    /**
     * 获取source值
     */
    public Object source() {
        return this.source;
    }

    /**
     * 设置source值
     * @param source
     */
    public Link source(Object source) {
        this.source = source;
        return this;
    }

    /**
     * 获取target值
     */
    public Object target() {
        return this.target;
    }

    /**
     * 设置target值
     * @param target
     */
    public Link target(Object target) {
        this.target = target;
        return this;
    }

    /**
     * 获取weight值
     */
    public Integer weight() {
        return this.weight;
    }

    /**
     * 设置weight值
     * @param weight
     */
    public Link weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    /**
     * 详见 itemStyle, 只能设置 lineWidth, strokeColor, lineType 等描边的属性
     */
    public ItemStyle itemStyle() {
        if (this.itemStyle == null) {
            this.itemStyle = new ItemStyle();
        }
        return this.itemStyle;
    }

    /**
     * 获取itemStyle值
     */
    public ItemStyle getItemStyle() {
        return itemStyle;
    }

    /**
     * 设置itemStyle值
     * @param itemStyle
     */
    public void setItemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    /**
     * 获取source值
     */
    public Object getSource() {
        return source;
    }

    /**
     * 设置source值
     * @param source
     */
    public void setSource(Object source) {
        this.source = source;
    }

    /**
     * 获取target值
     */
    public Object getTarget() {
        return target;
    }

    /**
     * 设置target值
     * @param target
     */
    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 获取weight值
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置weight值
     * @param weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
