package com.kd.platform.echarts.samples.map;

import com.kd.platform.echarts.code.SelectedMode;
import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.code.Y;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Map;
import com.kd.platform.echarts.series.MapLocation;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> MapTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MapTest {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/map.html
        EnhancedOption option = new EnhancedOption();
        Map map = new Map("Map");
        map.mapLocation(new MapLocation(X.left, Y.top, 500));
        map.selectedMode(SelectedMode.multiple);
        map.itemStyle().normal().borderWidth(2).borderColor("lightgreen").color("orange").label().show(true);

        map.itemStyle().emphasis().borderWidth(2).borderColor("#fff").color("#32cd32").label().show(true).textStyle().color("#fff");
        Data data = new Data("广东");
        data.value(Math.round(Math.random() * 1000));
        data.itemStyle().normal().color("#32cd32").label().show(true).textStyle().color("#fff").fontSize(15);
        data.itemStyle().emphasis().borderColor("yellow").color("#cd5c5c").label().show(false).textStyle().color("blue");

        map.data(data);
        map.markPoint().itemStyle().normal().color("skyblue");
        map.markPoint().data(new Data("天津", 350), new Data("上海", 103));

        map.geoCoord("上海", "121.4648", "31.2891").geoCoord("天津", "117.4219", "39.4189");

        option.series(map);
        option.exportToHtml("map.html");
        option.view();
    }
}
