package com.kd.platform.echarts.data;

/**
 * <b>Application name:</b> PieData.java <br>
 * <b>Application describing: 饼图</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PieData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private Object value;

    private String name;

    /**
     * 构造函数,参数:name,value
     * @param name
     * @param value
     */
    public PieData(String name, Object value) {
        this.value = value;
        this.name = name;
    }

    /**
     * 获取value值
     */
    public Object value() {
        return this.value;
    }

    /**
     * 设置value值
     * @param value
     */
    public PieData value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * 获取name值
     */
    public String name() {
        return this.name;
    }

    /**
     * 设置name值
     * @param name
     */
    public PieData name(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取value值
     */
    public Object getValue() {
        return value;
    }

    /**
     * 设置value值
     * @param value
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * 获取name值
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name值
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
