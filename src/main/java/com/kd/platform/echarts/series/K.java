package com.kd.platform.echarts.series;

import com.kd.platform.echarts.code.SeriesType;

/**
 * <b>Application name:</b> K.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class K extends Series<K> {
    /**
     * 构造函数
     */
    public K() {
        this.type(SeriesType.k);
    }

    /**
     * 构造函数,参数:name
     * @param name
     */
    public K(String name) {
        super(name);
        this.type(SeriesType.k);
    }

    /**
     * 设置open,close,min,max值
     * @param open
     * @param close
     * @param min
     * @param max
     */
    public K data(Double open, Double close, Double min, Double max) {
        Object[] kData = new Object[] { open, close, min, max };
        super.data(kData);
        return this;
    }
}
