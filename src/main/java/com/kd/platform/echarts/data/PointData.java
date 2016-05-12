package com.kd.platform.echarts.data;

/**
 * <b>Application name:</b> PointData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PointData extends BasicData<PointData> {
    /**
     * 构造函数
     */
    public PointData() {
        super();
    }

    /**
     * 构造函数,参数:name,value
     * @param name
     * @param value
     */
    public PointData(String name, Object value) {
        super(name, value);
    }

    /**
     * 构造函数,参数:name,symbol,symbolSize
     * @param name
     * @param symbol
     * @param symbolSize
     */
    public PointData(String name, Object symbol, Object symbolSize) {
        super(name, symbol, symbolSize);
    }

    /**
     * 构造函数,参数:value,symbol
     * @param value
     * @param symbol
     */
    public PointData(Object value, Object symbol) {
        super(value, symbol);
    }

    /**
     * 构造函数,参数:value,symbol,symbolSize
     * @param value
     * @param symbol
     * @param symbolSize
     */
    public PointData(Object value, Object symbol, Object symbolSize) {
        super(value, symbol, symbolSize);
    }
}
