package com.kd.platform.echarts.data;

/**
 * <b>Application name:</b> MapData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MapData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Object value;

    private Boolean selected;

    /**
     * 构造函数,参数:name,value
     * @param name
     * @param value
     */
    public MapData(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 构造函数,参数:name,value,selected
     * @param name
     * @param value
     * @param selected
     */
    public MapData(String name, Object value, Boolean selected) {
        this.name = name;
        this.value = value;
        this.selected = selected;
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
    public MapData name(String name) {
        this.name = name;
        return this;
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
    public MapData value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * 获取selected值
     */
    public Boolean selected() {
        return this.selected;
    }

    /**
     * 设置selected值
     * @param selected
     */
    public MapData selected(Boolean selected) {
        this.selected = selected;
        return this;
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
     * 获取selected值
     */
    public Boolean getSelected() {
        return selected;
    }

    /**
     * 设置selected值
     * @param selected
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
