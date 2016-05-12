package com.kd.platform.echarts;

/**
 * <b>Application name:</b> Event.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public enum Event {
    // 全局通用
    REFRESH("refresh"), RESTORE("restore"), RESIZE("resize"), CLICK("click"), DBLCLICK("dblclick"), HOVER("hover"),
    // MOUSEWHEEL("mousewheel"),
    // 业务交互逻辑
    DATA_CHANGED("dataChanged"), DATA_ZOOM("dataZoom"), DATA_RANGE("dataRange"), LEGEND_SELECTED("legendSelected"), MAP_SELECTED("mapSelected"), PIE_SELECTED("pieSelected"), MAGIC_TYPE_CHANGED("magicTypeChanged"), DATA_VIEW_CHANGED("dataViewChanged"), TIMELINE_CHANGED("timelineChanged"), MAP_ROAM("mapRoam"),
    // 内部通信
    TOOLTIP_HOVER("tooltipHover"), TOOLTIP_IN_GRID("tooltipInGrid"), TOOLTIP_OUT_GRID("tooltipOutGrid");

    private String event;

    /**
     * 构造函数,参数:event
     * @param event
     */
    private Event(String event) {
        this.event = event;
    }

    @Override
    /**
     * 获取toString值
     */
    public String toString() {
        return this.event;
    }
}
