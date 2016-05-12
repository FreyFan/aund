package com.kd.platform.echarts.series;

import com.kd.platform.echarts.code.SeriesType;

/**
 * <b>Application name:</b> Line.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Line extends Series<Line> {
    /**
     * 平滑曲线
     */
    private Boolean smooth;

    /**
     * 构造函数
     */
    public Line() {
        this.type(SeriesType.line);
    }

    /**
     * 构造函数,参数:name
     * @param name
     */
    public Line(String name) {
        super(name);
        this.type(SeriesType.line);
    }

    /**
     * 获取smooth值
     */
    public Boolean smooth() {
        return this.smooth;
    }

    /**
     * 设置smooth值
     * @param smooth
     */
    public Line smooth(Boolean smooth) {
        this.smooth = smooth;
        return this;
    }

    /**
     * 获取smooth值
     */
    public Boolean getSmooth() {
        return smooth;
    }

    /**
     * 设置smooth值
     * @param smooth
     */
    public void setSmooth(Boolean smooth) {
        this.smooth = smooth;
    }
}
