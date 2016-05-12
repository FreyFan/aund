package com.kd.platform.echarts.series;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * <b>Application name:</b> GeoCoord.java <br>
 * <b>Application describing:地图特有，标线图形定位坐标 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class GeoCoord extends HashMap<String, BigDecimal[]> implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 设置key,x,y值
     * @param key
     * @param x
     * @param y
     */
    public GeoCoord put(String key, String x, String y) {
        super.put(key, new BigDecimal[] { new BigDecimal(x), new BigDecimal(y) });
        return this;
    }

}
