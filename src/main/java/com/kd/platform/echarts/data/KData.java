package com.kd.platform.echarts.data;

/**
 * <b>Application name:</b> KData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class KData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Double[] value;

    /**
     * 开盘，收盘，最低，最高
     * @param open
     * @param close
     * @param min
     * @param max
     */
    public KData(Double open, Double close, Double min, Double max) {
        this.value = new Double[4];
        this.value[0] = open;
        this.value[1] = close;
        this.value[2] = min;
        this.value[3] = max;
    }

    /**
     * 获取value值
     */
    public Double[] value() {
        return this.value;
    }

    /**
     * 设置value值
     * @param value
     */
    public KData value(Double[] value) {
        this.value = value;
        return this;
    }

    /**
     * 获取value值
     */
    public Double[] getValue() {
        return value;
    }

    /**
     * 设置value值
     * @param value
     */
    public void setValue(Double[] value) {
        this.value = value;
    }
}
