package com.kd.platform.echarts.series;

/**
 * <b>Application name:</b> ScaleLimit.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ScaleLimit implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Double min;

    private Double max;

    /**
     * 构造函数
     */
    public ScaleLimit() {
    }

    /**
     * 构造函数,参数:min,max
     * @param min
     * @param max
     */
    public ScaleLimit(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    /**
     * 获取min值
     */
    public Double min() {
        return this.min;
    }

    /**
     * 设置min值
     * @param min
     */
    public ScaleLimit min(Double min) {
        this.min = min;
        return this;
    }

    /**
     * 获取max值
     */
    public Double max() {
        return this.max;
    }

    /**
     * 设置max值
     * @param max
     */
    public ScaleLimit max(Double max) {
        this.max = max;
        return this;
    }

    /**
     * 获取min值
     */
    public Double getMin() {
        return min;
    }

    /**
     * 设置min值
     * @param min
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * 获取max值
     */
    public Double getMax() {
        return max;
    }

    /**
     * 设置max值
     * @param max
     */
    public void setMax(Double max) {
        this.max = max;
    }
}
