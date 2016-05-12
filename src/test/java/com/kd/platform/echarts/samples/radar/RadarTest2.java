package com.kd.platform.echarts.samples.radar;

import com.kd.platform.echarts.Polar;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Radar;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> RadarTest2.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class RadarTest2 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/radar2.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("罗纳尔多 vs 舍普琴科").subtext("完全实况球员数据");
        option.tooltip().trigger(Trigger.axis);
        option.legend().data("罗纳尔多", "舍普琴科").x(X.center);
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.calculable(true);

        Polar polar = new Polar();
        polar.indicator(new Data().text("进攻").max(100), new Data().text("防守").max(100), new Data().text("体能").max(100), new Data().text("速度").max(100), new Data().text("力量").max(100), new Data().text("技巧").max(100)).radius(130);
        option.polar(polar);

        Radar radar = new Radar("完全实况球员数据");
        radar.itemStyle().normal().areaStyle().typeDefault();
        radar.data(new Data().name("舍普琴科").value(97, 42, 88, 94, 90, 86), new Data().name("罗纳尔多").value(97, 32, 74, 95, 88, 92));
        option.series(radar);
        option.exportToHtml("radar2.html");
        option.view();
    }
}
