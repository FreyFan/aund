package com.kd.platform.echarts.samples.radar;

import com.kd.platform.echarts.Polar;
import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Radar;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> RadarTest1.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class RadarTest1 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/radar1.html
        EnhancedOption option = new EnhancedOption();
        option.title("预算 vs 开销（Budget vs spending）", "纯属虚构");
        option.tooltip(Trigger.axis);
        option.legend().orient(Orient.vertical).x(X.right).y(Y.bottom).data("预算分配（Allocated Budget）", "实际开销（Actual Spending）");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.calculable(true);

        Polar polar = new Polar();
        polar.indicator(new Data().text("销售（sales）").max(6000), new Data().text("管理（Administration）").max(16000), new Data().text("信息技术（Information Techology）").max(30000), new Data().text("客服（Customer Support）").max(38000), new Data().text("研发（Development）").max(52000), new Data().text("市场（Marketing）").max(25000));
        option.polar(polar);

        Radar radar = new Radar("预算 vs 开销（Budget vs spending）");
        radar.data(new Data().name("预算分配（Allocated Budget）").value(4300, 10000, 28000, 35000, 50000, 19000), new Data().name("实际开销（Actual Spending）").value(5000, 14000, 28000, 31000, 42000, 21000));
        option.series(radar);
        option.exportToHtml("radar1.html");
        option.view();
    }
}
