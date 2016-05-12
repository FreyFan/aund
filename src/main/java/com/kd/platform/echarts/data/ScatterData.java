package com.kd.platform.echarts.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Application name:</b> ScatterData.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ScatterData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private List<Object> value;

    /**
     * 横值，纵值
     * @param width
     * @param height
     */
    public ScatterData(Object width, Object height) {
        this.value(width, height);
    }

    /**
     * 横值，纵值，大小
     * @param width
     * @param height
     * @param size
     */
    public ScatterData(Object width, Object height, Object size) {
        this.value(width, height, size);
    }

    /**
     * 获取value值
     */
    public List<Object> value() {
        if (this.value == null) {
            this.value = new ArrayList<Object>();
        }
        return this.value;
    }

    /**
     * 设置values值
     * @param values
     */
    private ScatterData value(Object... values) {
        if (values == null || values.length == 0) {
            return this;
        }
        this.value().addAll(Arrays.asList(values));
        return this;
    }

    /**
     * 获取value值
     */
    public List<Object> getValue() {
        return value;
    }

    /**
     * 设置value值
     * @param value
     */
    public void setValue(List<Object> value) {
        this.value = value;
    }
}
