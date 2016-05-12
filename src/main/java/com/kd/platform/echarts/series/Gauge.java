package com.kd.platform.echarts.series;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.Title;
import com.kd.platform.echarts.axis.AxisTick;
import com.kd.platform.echarts.axis.SplitLine;
import com.kd.platform.echarts.code.SeriesType;
import com.kd.platform.echarts.series.gauge.Detail;
import com.kd.platform.echarts.series.gauge.Pointer;

/**
 * <b>Application name:</b> Gauge.java <br>
 * <b>Application describing: 仪表盘</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Gauge extends Series<Gauge> {
    /**
     * 圆心坐标，支持绝对值（px）和百分比，百分比计算min(width, height) * 50%
     */
    private Object[] center;

    /**
     * 半径，支持绝对值（px）和百分比，百分比计算比，min(width, height) / 2 * 75%， 传数组实现环形图，[内半径，外半径]
     */
    private Object radius;

    /**
     * 开始角度, 饼图（90）、仪表盘（225），有效输入范围：[-360,360]
     */
    private Integer startAngle;

    /**
     * 结束角度,有效输入范围：[-360,360]，保证startAngle - endAngle为正值
     */
    private Integer endAngle;

    /**
     * 指定的最小值
     */
    private Integer min;

    /**
     * 指定的最大值
     */
    private Integer max;

    /**
     * 小数精度，默认为0，无小数点
     */
    private Integer precision;

    /**
     * 分割段数，默认为5，为0时为线性渐变，calculable为true是默认均分100份
     */
    private Integer splitNumber;

    /**
     * 坐标轴线，默认显示
     * @see com.kd.platform.echarts.series.Line
     */
    private Line axisLine;

    /**
     * 坐标轴小标记，默认显示
     * @see com.kd.platform.echarts.axis.AxisTick
     */
    private AxisTick axisTick;

    /**
     * 坐标轴文本标签
     * @see com.kd.platform.echarts.Label
     */
    private Label axisLabel;

    /**
     * 主分隔线，默认显示
     * @see com.kd.platform.echarts.axis.SplitLine
     */
    private SplitLine splitLine;

    /**
     * 指针样式
     * @see com.kd.platform.echarts.series.gauge.Pointer
     */
    private Pointer pointer;

    /**
     * 仪表盘标题
     * @see com.kd.platform.echarts.Title
     */
    private Title title;

    /**
     * 仪表盘详情
     * @see com.kd.platform.echarts.series.gauge.Detail
     */
    private Detail detail;

    /**
     * 构造函数
     */
    public Gauge() {
        this.type(SeriesType.gauge);
    }

    /**
     * 构造函数,参数:name
     * @param name
     */
    public Gauge(String name) {
        super(name);
        this.type(SeriesType.gauge);
    }

    /**
     * 获取center值
     */
    public Object[] center() {
        return this.center;
    }

    /**
     * 设置center值
     * @param center
     */
    public Gauge center(Object[] center) {
        this.center = center;
        return this;
    }

    /**
     * 获取radius值
     */
    public Object radius() {
        return this.radius;
    }

    /**
     * 设置axisLine值
     * @param axisLine
     */
    public Gauge axisLine(Line axisLine) {
        this.axisLine = axisLine;
        return this;
    }

    /**
     * 设置axisTick值
     * @param axisTick
     */
    public Gauge axisTick(AxisTick axisTick) {
        this.axisTick = axisTick;
        return this;
    }

    /**
     * 设置axisLabel值
     * @param axisLabel
     */
    public Gauge axisLabel(Label axisLabel) {
        this.axisLabel = axisLabel;
        return this;
    }

    /**
     * 设置splitLine值
     * @param splitLine
     */
    public Gauge splitLine(SplitLine splitLine) {
        this.splitLine = splitLine;
        return this;
    }

    /**
     * 设置pointer值
     * @param pointer
     */
    public Gauge pointer(Pointer pointer) {
        this.pointer = pointer;
        return this;
    }

    /**
     * 设置title值
     * @param title
     */
    public Gauge title(Title title) {
        this.title = title;
        return this;
    }

    /**
     * 设置detail值
     * @param detail
     */
    public Gauge detail(Detail detail) {
        this.detail = detail;
        return this;
    }

    /**
     * 圆心坐标，支持绝对值（px）和百分比，百分比计算min(width, height) * 50%
     */
    public Gauge center(Object width, Object height) {
        this.center = new Object[] { width, height };
        return this;
    }

    /**
     * 半径，支持绝对值（px）和百分比，百分比计算比，min(width, height) / 2 * 75%， 传数组实现环形图，[内半径，外半径]
     * @param radius
     * @return
     */
    public Gauge radius(Object radius) {
        this.radius = radius;
        return this;
    }

    /**
     * 半径，支持绝对值（px）和百分比，百分比计算比，min(width, height) / 2 * 75%， 传数组实现环形图，[内半径，外半径]
     * @param width
     * @param height
     * @return
     */
    public Gauge radius(Object width, Object height) {
        radius = new Object[] { width, height };
        return this;
    }

    /**
     * 获取startAngle值
     */
    public Integer startAngle() {
        return this.startAngle;
    }

    /**
     * 设置startAngle值
     * @param startAngle
     */
    public Gauge startAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    /**
     * 获取endAngle值
     */
    public Integer endAngle() {
        return this.endAngle;
    }

    /**
     * 设置endAngle值
     * @param endAngle
     */
    public Gauge endAngle(Integer endAngle) {
        this.endAngle = endAngle;
        return this;
    }

    /**
     * 获取min值
     */
    public Integer min() {
        return this.min;
    }

    /**
     * 设置min值
     * @param min
     */
    public Gauge min(Integer min) {
        this.min = min;
        return this;
    }

    /**
     * 获取max值
     */
    public Integer max() {
        return this.max;
    }

    /**
     * 设置max值
     * @param max
     */
    public Gauge max(Integer max) {
        this.max = max;
        return this;
    }

    /**
     * 获取precision值
     */
    public Integer precision() {
        return this.precision;
    }

    /**
     * 设置precision值
     * @param precision
     */
    public Gauge precision(Integer precision) {
        this.precision = precision;
        return this;
    }

    /**
     * 获取splitNumber值
     */
    public Integer splitNumber() {
        return this.splitNumber;
    }

    /**
     * 设置splitNumber值
     * @param splitNumber
     */
    public Gauge splitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
        return this;
    }

    /**
     * 坐标轴线，默认显示
     * @see com.kd.platform.echarts.series.Line
     */
    public Line axisLine() {
        if (this.axisLine == null) {
            this.axisLine = new Line();
        }
        return this.axisLine;
    }

    /**
     * 坐标轴小标记，默认显示
     * @see com.kd.platform.echarts.axis.AxisTick
     */
    public AxisTick axisTick() {
        if (this.axisTick == null) {
            this.axisTick = new AxisTick();
        }
        return this.axisTick;
    }

    /**
     * 坐标轴文本标签
     * @see com.kd.platform.echarts.Label
     */
    public Label axisLabel() {
        if (this.axisLabel == null) {
            this.axisLabel = new Label();
        }
        return this.axisLabel;
    }

    /**
     * 主分隔线，默认显示
     * @see com.kd.platform.echarts.axis.SplitLine
     */
    public SplitLine splitLine() {
        if (this.splitLine == null) {
            this.splitLine = new SplitLine();
        }
        return this.splitLine;
    }

    /**
     * 指针样式
     * @see com.kd.platform.echarts.series.gauge.Pointer
     */
    public Pointer pointer() {
        if (this.pointer == null) {
            this.pointer = new Pointer();
        }
        return this.pointer;
    }

    /**
     * 仪表盘标题
     * @see com.kd.platform.echarts.Title
     */
    public Title title() {
        if (this.title == null) {
            this.title = new Title();
        }
        return this.title;
    }

    /**
     * 仪表盘详情
     * @see com.kd.platform.echarts.series.gauge.Detail
     */
    public Detail detail() {
        if (this.detail == null) {
            this.detail = new Detail();
        }
        return this.detail;
    }

    /**
     * 获取center值
     */
    public Object[] getCenter() {
        return center;
    }

    /**
     * 设置center值
     * @param center
     */
    public void setCenter(Object[] center) {
        this.center = center;
    }

    /**
     * 获取radius值
     */
    public Object getRadius() {
        return radius;
    }

    /**
     * 设置radius值
     * @param radius
     */
    public void setRadius(Object radius) {
        this.radius = radius;
    }

    /**
     * 获取axisLine值
     */
    public Line getAxisLine() {
        return axisLine;
    }

    /**
     * 设置axisLine值
     * @param axisLine
     */
    public void setAxisLine(Line axisLine) {
        this.axisLine = axisLine;
    }

    /**
     * 获取axisTick值
     */
    public AxisTick getAxisTick() {
        return axisTick;
    }

    /**
     * 设置axisTick值
     * @param axisTick
     */
    public void setAxisTick(AxisTick axisTick) {
        this.axisTick = axisTick;
    }

    /**
     * 获取axisLabel值
     */
    public Label getAxisLabel() {
        return axisLabel;
    }

    /**
     * 设置axisLabel值
     * @param axisLabel
     */
    public void setAxisLabel(Label axisLabel) {
        this.axisLabel = axisLabel;
    }

    /**
     * 获取splitLine值
     */
    public SplitLine getSplitLine() {
        return splitLine;
    }

    /**
     * 设置splitLine值
     * @param splitLine
     */
    public void setSplitLine(SplitLine splitLine) {
        this.splitLine = splitLine;
    }

    /**
     * 获取pointer值
     */
    public Pointer getPointer() {
        return pointer;
    }

    /**
     * 设置pointer值
     * @param pointer
     */
    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    /**
     * 获取title值
     */
    public Title getTitle() {
        return title;
    }

    /**
     * 设置title值
     * @param title
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * 获取detail值
     */
    public Detail getDetail() {
        return detail;
    }

    /**
     * 设置detail值
     * @param detail
     */
    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    /**
     * 获取startAngle值
     */
    public Integer getStartAngle() {
        return startAngle;
    }

    /**
     * 设置startAngle值
     * @param startAngle
     */
    public void setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
    }

    /**
     * 获取endAngle值
     */
    public Integer getEndAngle() {
        return endAngle;
    }

    /**
     * 设置endAngle值
     * @param endAngle
     */
    public void setEndAngle(Integer endAngle) {
        this.endAngle = endAngle;
    }

    /**
     * 获取min值
     */
    public Integer getMin() {
        return min;
    }

    /**
     * 设置min值
     * @param min
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * 获取max值
     */
    public Integer getMax() {
        return max;
    }

    /**
     * 设置max值
     * @param max
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 获取precision值
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * 设置precision值
     * @param precision
     */
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    /**
     * 获取splitNumber值
     */
    public Integer getSplitNumber() {
        return splitNumber;
    }

    /**
     * 设置splitNumber值
     * @param splitNumber
     */
    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }
}
