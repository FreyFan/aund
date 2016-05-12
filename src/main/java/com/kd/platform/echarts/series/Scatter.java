package com.kd.platform.echarts.series;

import com.kd.platform.echarts.code.SeriesType;

/**
 * <b>Application name:</b> Scatter.java <br>
 * <b>Application describing:散点图、气泡图 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Scatter extends Series<Scatter> {
    /**
     * 大规模散点图
     */
    private Boolean large;

    /**
     * 大规模阀值，large为true且数据量>largeThreshold才启用大规模模式
     */
    private Long largeThreshold;

    /**
     * 构造函数
     */
    public Scatter() {
        this.type(SeriesType.scatter);
    }

    /**
     * 构造函数,参数:name
     * @param name
     */
    public Scatter(String name) {
        super(name);
        this.type(SeriesType.scatter);
    }

    /**
     * 获取large值
     */
    public Boolean large() {
        return this.large;
    }

    /**
     * 设置large值
     * @param large
     */
    public Scatter large(Boolean large) {
        this.large = large;
        return this;
    }

    /**
     * 获取largeThreshold值
     */
    public Long largeThreshold() {
        return this.largeThreshold;
    }

    /**
     * 设置largeThreshold值
     * @param largeThreshold
     */
    public Scatter largeThreshold(Long largeThreshold) {
        this.largeThreshold = largeThreshold;
        return this;
    }

    /**
     * 获取large值
     */
    public Boolean getLarge() {
        return large;
    }

    /**
     * 设置large值
     * @param large
     */
    public void setLarge(Boolean large) {
        this.large = large;
    }

    /**
     * 获取largeThreshold值
     */
    public Long getLargeThreshold() {
        return largeThreshold;
    }

    /**
     * 设置largeThreshold值
     * @param largeThreshold
     */
    public void setLargeThreshold(Long largeThreshold) {
        this.largeThreshold = largeThreshold;
    }
}
