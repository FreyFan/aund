package com.kd.platform.echarts.data;

/**
 * <b>Application name:</b> LineData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class LineData extends BasicData<LineData> {
    /**
     * 可以通过valueIndex:0指定为横轴特殊点
     */
    private Integer valueIndex;

    /**
     * 构造函数
     */
    public LineData() {
    }

    /**
     * 构造函数,参数:name,value
     * @param name
     * @param value
     */
    public LineData(String name, Object value) {
        super(name, value);
    }

    /**
     * 构造函数,参数:name,symbol,symbolSize
     * @param name
     * @param symbol
     * @param symbolSize
     */
    public LineData(String name, Object symbol, Object symbolSize) {
        super(name, symbol, symbolSize);
    }

    /**
     * 构造函数,参数:value,symbol
     * @param value
     * @param symbol
     */
    public LineData(Object value, Object symbol) {
        super(value, symbol);
    }

    /**
     * 构造函数,参数:value,symbol,symbolSize
     * @param value
     * @param symbol
     * @param symbolSize
     */
    public LineData(Object value, Object symbol, Object symbolSize) {
        super(value, symbol, symbolSize);
    }

    /**
     * 获取valueIndex值
     */
    public Integer valueIndex() {
        return this.valueIndex;
    }

    /**
     * 设置valueIndex值
     * @param valueIndex
     */
    public LineData valueIndex(Integer valueIndex) {
        this.valueIndex = valueIndex;
        return this;
    }

    /**
     * 获取valueIndex值
     */
    public Integer getValueIndex() {
        return valueIndex;
    }

    /**
     * 设置valueIndex值
     * @param valueIndex
     */
    public LineData setValueIndex(Integer valueIndex) {
        this.valueIndex = valueIndex;
        return this;
    }
}