package com.kd.platform.echarts.series;

import com.kd.platform.echarts.code.SeriesType;

/**
 * <b>Application name:</b> Radar.java <br>
 * <b>Application describing: 雷达图</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Radar extends Series<Radar> {
    /**
     * 极坐标索引
     */
    private Integer polarIndex;

    /**
     * 构造函数
     */
    public Radar() {
        this.type(SeriesType.radar);
    }

    /**
     * 构造函数,参数:name
     * @param name
     */
    public Radar(String name) {
        super(name);
        this.type(SeriesType.radar);
    }

    /**
     * 获取polarIndex值
     */
    public Integer polarIndex() {
        return this.polarIndex;
    }

    /**
     * 设置polarIndex值
     * @param polarIndex
     */
    public Radar polarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
        return this;
    }

    /**
     * 获取polarIndex值
     */
    public Integer getPolarIndex() {
        return polarIndex;
    }

    /**
     * 设置polarIndex值
     * @param polarIndex
     */
    public void setPolarIndex(Integer polarIndex) {
        this.polarIndex = polarIndex;
    }
}
