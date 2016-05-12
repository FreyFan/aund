package com.kd.platform.echarts;

import com.kd.platform.echarts.code.Orient;

/**
 * <b>Application name:</b> DataZoom.java <br>
 * <b>Application describing:数据区域缩放。与toolbox.feature.dataZoom同步，仅对直角坐标系图表有效 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class DataZoom extends Basic<DataZoom> implements Component {
    /**
     * 布局方式，默认为水平布局，可选为：'horizontal' | 'vertical'
     */
    private Orient orient;

    /**
     * 默认#ccc，数据缩略背景颜色
     */
    private String dataBackgroundColor;

    /**
     * 默认值rgba(144,197,237,0.2)，选择区域填充颜色
     */
    private String fillerColor;

    /**
     * 默认值rgba(70,130,180,0.8)，控制手柄颜色
     */
    private String handleColor;

    /**
     * 当不指定时默认控制所有横向类目，可通过数组指定多个需要控制的横向类目坐标轴Index，仅一个时可直接为数字
     */
    private Object xAxisIndex;

    /**
     * 当不指定时默认控制所有纵向类目，可通过数组指定多个需要控制的纵向类目坐标轴Index，仅一个时可直接为数字
     */
    private Object yAxisIndex;

    /**
     * 数据缩放，选择起始比例，默认为0（%），从首个数据起选择
     */
    private Integer start;

    /**
     * 数据缩放，选择结束比例，默认为100（%），到最后一个数据选择结束
     */
    private Integer end;

    /**
     * 缩放变化是否实时显示，建议性能较低的浏览器或数据量巨大时不启动实时效果
     */
    private Boolean realtime;

    /**
     * 数据缩放锁，默认为false，当设置为true时选择区域不能伸缩，即(end - start)值保持不变，仅能做数据漫游
     */
    private Boolean zoomLock;

    /**
     * 缩放变化是否显示定位详情
     */
    private Boolean showDetail;

    /**
     * 获取orient值
     */
    public Orient orient() {
        return this.orient;
    }

    /**
     * 设置orient值
     * @param orient
     */
    public DataZoom orient(Orient orient) {
        this.orient = orient;
        return this;
    }

    /**
     * 获取dataBackgroundColor值
     */
    public String dataBackgroundColor() {
        return this.dataBackgroundColor;
    }

    /**
     * 设置dataBackgroundColor值
     * @param dataBackgroundColor
     */
    public DataZoom dataBackgroundColor(String dataBackgroundColor) {
        this.dataBackgroundColor = dataBackgroundColor;
        return this;
    }

    /**
     * 获取fillerColor值
     */
    public String fillerColor() {
        return this.fillerColor;
    }

    /**
     * 设置fillerColor值
     * @param fillerColor
     */
    public DataZoom fillerColor(String fillerColor) {
        this.fillerColor = fillerColor;
        return this;
    }

    /**
     * 获取handleColor值
     */
    public String handleColor() {
        return this.handleColor;
    }

    /**
     * 设置handleColor值
     * @param handleColor
     */
    public DataZoom handleColor(String handleColor) {
        this.handleColor = handleColor;
        return this;
    }

    /**
     * 获取xAxisIndex值
     */
    public Object xAxisIndex() {
        return this.xAxisIndex;
    }

    /**
     * 设置xAxisIndex值
     * @param xAxisIndex
     */
    public DataZoom xAxisIndex(Object xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
        return this;
    }

    /**
     * 获取yAxisIndex值
     */
    public Object yAxisIndex() {
        return this.yAxisIndex;
    }

    /**
     * 设置yAxisIndex值
     * @param yAxisIndex
     */
    public DataZoom yAxisIndex(Object yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
        return this;
    }

    /**
     * 获取start值
     */
    public Integer start() {
        return this.start;
    }

    /**
     * 设置start值
     * @param start
     */
    public DataZoom start(Integer start) {
        this.start = start;
        return this;
    }

    /**
     * 获取end值
     */
    public Integer end() {
        return this.end;
    }

    /**
     * 设置end值
     * @param end
     */
    public DataZoom end(Integer end) {
        this.end = end;
        return this;
    }

    /**
     * 获取realtime值
     */
    public Boolean realtime() {
        return this.realtime;
    }

    /**
     * 设置realtime值
     * @param realtime
     */
    public DataZoom realtime(Boolean realtime) {
        this.realtime = realtime;
        return this;
    }

    /**
     * 获取zoomLock值
     */
    public Boolean zoomLock() {
        return this.zoomLock;
    }

    /**
     * 设置zoomLock值
     * @param zoomLock
     */
    public DataZoom zoomLock(Boolean zoomLock) {
        this.zoomLock = zoomLock;
        return this;
    }

    /**
     * 获取showDetail值
     */
    public Boolean showDetail() {
        return this.showDetail;
    }

    /**
     * 设置showDetail值
     * @param showDetail
     */
    public DataZoom showDetail(Boolean showDetail) {
        this.showDetail = showDetail;
        return this;
    }

    /**
     * 获取orient值
     */
    public Orient getOrient() {
        return orient;
    }

    /**
     * 设置orient值
     * @param orient
     */
    public void setOrient(Orient orient) {
        this.orient = orient;
    }

    /**
     * 获取dataBackgroundColor值
     */
    public String getDataBackgroundColor() {
        return dataBackgroundColor;
    }

    /**
     * 设置dataBackgroundColor值
     * @param dataBackgroundColor
     */
    public void setDataBackgroundColor(String dataBackgroundColor) {
        this.dataBackgroundColor = dataBackgroundColor;
    }

    /**
     * 获取fillerColor值
     */
    public String getFillerColor() {
        return fillerColor;
    }

    /**
     * 设置fillerColor值
     * @param fillerColor
     */
    public void setFillerColor(String fillerColor) {
        this.fillerColor = fillerColor;
    }

    /**
     * 获取handleColor值
     */
    public String getHandleColor() {
        return handleColor;
    }

    /**
     * 设置handleColor值
     * @param handleColor
     */
    public void setHandleColor(String handleColor) {
        this.handleColor = handleColor;
    }

    /**
     * 获取xAxisIndex值
     */
    public Object getxAxisIndex() {
        return xAxisIndex;
    }

    /**
     * 设置xAxisIndex值
     * @param xAxisIndex
     */
    public void setxAxisIndex(Object xAxisIndex) {
        this.xAxisIndex = xAxisIndex;
    }

    /**
     * 获取yAxisIndex值
     */
    public Object getyAxisIndex() {
        return yAxisIndex;
    }

    /**
     * 设置yAxisIndex值
     * @param yAxisIndex
     */
    public void setyAxisIndex(Object yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    /**
     * 获取start值
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 设置start值
     * @param start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 获取end值
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * 设置end值
     * @param end
     */
    public void setEnd(Integer end) {
        this.end = end;
    }

    /**
     * 获取realtime值
     */
    public Boolean getRealtime() {
        return realtime;
    }

    /**
     * 设置realtime值
     * @param realtime
     */
    public void setRealtime(Boolean realtime) {
        this.realtime = realtime;
    }

    /**
     * 获取zoomLock值
     */
    public Boolean getZoomLock() {
        return zoomLock;
    }

    /**
     * 设置zoomLock值
     * @param zoomLock
     */
    public void setZoomLock(Boolean zoomLock) {
        this.zoomLock = zoomLock;
    }

    /**
     * 获取showDetail值
     */
    public Boolean getShowDetail() {
        return showDetail;
    }

    /**
     * 设置showDetail值
     * @param showDetail
     */
    public void setShowDetail(Boolean showDetail) {
        this.showDetail = showDetail;
    }
}
