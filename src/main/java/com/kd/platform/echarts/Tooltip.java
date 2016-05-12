package com.kd.platform.echarts;

import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.style.TextStyle;

/**
 * <b>Application name:</b> Tooltip.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Tooltip extends Basic<Tooltip> implements Component {
    /**
     * tooltip主体内容显示策略，只需tooltip触发事件或显示axisPointer而不需要显示内容时可配置该项为falase， 可选为：true（显示） | false（隐藏）
     */
    private Boolean showContent;

    /**
     * 触发类型，默认数据触发，见下图，可选为：'item' | 'axis'
     * @see com.kd.platform.echarts.code.Trigger
     */
    private Trigger trigger;

    /**
     *
     */
    private Object position;

    /**
     * 位置指定，传入{Array}，如[x, y]， 固定位置[x, y]；传入{Function}，如function([x, y]) {return
     * [newX,newY]}，默认显示坐标为输入参数，用户指定的新坐标为输出返回。
     */
    private Object formatter;

    /**
     * 内容格式器：{string}（Template） | {Function}，支持异步回调见表格下方
     */
    private String islandFormatter;

    /**
     * 默认20，显示延迟，添加显示延迟可以避免频繁切换，特别是在详情内容需要异步获取的场景，单位ms
     */
    private Integer showDelay;

    /**
     * 默认100，隐藏延迟，单位ms
     */
    private Integer hideDelay;

    /**
     * 动画变换时长，单位s，如果你希望tooltip的跟随实时响应，showDelay设置为0是关键，同时transitionDuration设0也会有交互体验上的差别
     */
    private Double transitionDuration;

    /**
     * 2.1.9新增属性，默认true，含义未知
     * @since 2.1.9
     */
    private Boolean enterable;

    /**
     * 提示边框圆角，单位px，默认为4
     */
    private Integer borderRadius;

    /**
     * 坐标轴指示器，坐标轴触发有效
     */
    private AxisPointer axisPointer;

    /**
     * 文本样式，默认为白色字体
     * @see com.kd.platform.echarts.style.TextStyle
     */
    private TextStyle textStyle;

    /**
     * 设置axisPointer值
     * @param axisPointer
     */
    public Tooltip axisPointer(AxisPointer axisPointer) {
        this.axisPointer = axisPointer;
        return this;
    }

    /**
     * 设置textStyle值
     * @param textStyle
     */
    public Tooltip textStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
        return this;
    }

    /**
     * 获取showContent值
     */
    public Boolean showContent() {
        return this.showContent;
    }

    /**
     * 设置showContent值
     * @param showContent
     */
    public Tooltip showContent(Boolean showContent) {
        this.showContent = showContent;
        return this;
    }

    /**
     * 获取trigger值
     */
    public Trigger trigger() {
        return this.trigger;
    }

    /**
     * 设置trigger值
     * @param trigger
     */
    public Tooltip trigger(Trigger trigger) {
        this.trigger = trigger;
        return this;
    }

    /**
     * 获取position值
     */
    public Object position() {
        return this.position;
    }

    /**
     * 设置position值
     * @param position
     */
    public Tooltip position(Object position) {
        this.position = position;
        return this;
    }

    /**
     * 获取formatter值
     */
    public Object formatter() {
        return this.formatter;
    }

    /**
     * 设置formatter值
     * @param formatter
     */
    public Tooltip formatter(Object formatter) {
        this.formatter = formatter;
        return this;
    }

    /**
     * 获取islandFormatter值
     */
    public String islandFormatter() {
        return this.islandFormatter;
    }

    /**
     * 设置islandFormatter值
     * @param islandFormatter
     */
    public Tooltip islandFormatter(String islandFormatter) {
        this.islandFormatter = islandFormatter;
        return this;
    }

    /**
     * 获取showDelay值
     */
    public Integer showDelay() {
        return this.showDelay;
    }

    /**
     * 设置showDelay值
     * @param showDelay
     */
    public Tooltip showDelay(Integer showDelay) {
        this.showDelay = showDelay;
        return this;
    }

    /**
     * 获取hideDelay值
     */
    public Integer hideDelay() {
        return this.hideDelay;
    }

    /**
     * 设置hideDelay值
     * @param hideDelay
     */
    public Tooltip hideDelay(Integer hideDelay) {
        this.hideDelay = hideDelay;
        return this;
    }

    /**
     * 获取transitionDuration值
     */
    public Double transitionDuration() {
        return this.transitionDuration;
    }

    /**
     * 设置transitionDuration值
     * @param transitionDuration
     */
    public Tooltip transitionDuration(Double transitionDuration) {
        this.transitionDuration = transitionDuration;
        return this;
    }

    public Boolean enterable() {
        return this.enterable;
    }

    public Tooltip enterable(Boolean enterable) {
        this.enterable = enterable;
        return this;
    }

    /**
     * 获取borderRadius值
     */
    public Integer borderRadius() {
        return this.borderRadius;
    }

    /**
     * 设置borderRadius值
     * @param borderRadius
     */
    public Tooltip borderRadius(Integer borderRadius) {
        this.borderRadius = borderRadius;
        return this;
    }

    /**
     * 坐标轴指示器，坐标轴触发有效
     */
    public AxisPointer axisPointer() {
        if (this.axisPointer == null) {
            this.axisPointer = new AxisPointer();
        }
        return this.axisPointer;
    }

    /**
     * 文本样式，默认为白色字体
     * @see com.kd.platform.echarts.style.TextStyle
     */
    public TextStyle textStyle() {
        if (this.textStyle == null) {
            this.textStyle = new TextStyle();
        }
        return this.textStyle;
    }

    /**
     * 获取showContent值
     */
    public Boolean getShowContent() {
        return showContent;
    }

    /**
     * 设置showContent值
     * @param showContent
     */
    public void setShowContent(Boolean showContent) {
        this.showContent = showContent;
    }

    /**
     * 获取trigger值
     */
    public Trigger getTrigger() {
        return trigger;
    }

    /**
     * 设置trigger值
     * @param trigger
     */
    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    /**
     * 获取position值
     */
    public Object getPosition() {
        return position;
    }

    /**
     * 设置position值
     * @param position
     */
    public void setPosition(Object position) {
        this.position = position;
    }

    /**
     * 获取formatter值
     */
    public Object getFormatter() {
        return formatter;
    }

    /**
     * 设置formatter值
     * @param formatter
     */
    public void setFormatter(Object formatter) {
        this.formatter = formatter;
    }

    /**
     * 获取islandFormatter值
     */
    public String getIslandFormatter() {
        return islandFormatter;
    }

    /**
     * 设置islandFormatter值
     * @param islandFormatter
     */
    public void setIslandFormatter(String islandFormatter) {
        this.islandFormatter = islandFormatter;
    }

    /**
     * 获取showDelay值
     */
    public Integer getShowDelay() {
        return showDelay;
    }

    /**
     * 设置showDelay值
     * @param showDelay
     */
    public void setShowDelay(Integer showDelay) {
        this.showDelay = showDelay;
    }

    /**
     * 获取hideDelay值
     */
    public Integer getHideDelay() {
        return hideDelay;
    }

    /**
     * 设置hideDelay值
     * @param hideDelay
     */
    public void setHideDelay(Integer hideDelay) {
        this.hideDelay = hideDelay;
    }

    /**
     * 获取transitionDuration值
     */
    public Double getTransitionDuration() {
        return transitionDuration;
    }

    /**
     * 设置transitionDuration值
     * @param transitionDuration
     */
    public void setTransitionDuration(Double transitionDuration) {
        this.transitionDuration = transitionDuration;
    }

    public Boolean getEnterable() {
        return enterable;
    }

    public void setEnterable(Boolean enterable) {
        this.enterable = enterable;
    }

    /**
     * 获取borderRadius值
     */
    public Integer getBorderRadius() {
        return borderRadius;
    }

    /**
     * 设置borderRadius值
     * @param borderRadius
     */
    public void setBorderRadius(Integer borderRadius) {
        this.borderRadius = borderRadius;
    }

    /**
     * 获取axisPointer值
     */
    public AxisPointer getAxisPointer() {
        return axisPointer;
    }

    /**
     * 设置axisPointer值
     * @param axisPointer
     */
    public void setAxisPointer(AxisPointer axisPointer) {
        this.axisPointer = axisPointer;
    }

    /**
     * 获取textStyle值
     */
    public TextStyle getTextStyle() {
        return textStyle;
    }

    /**
     * 设置textStyle值
     * @param textStyle
     */
    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }
}
