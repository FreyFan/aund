package com.kd.platform.echarts;

import com.kd.platform.echarts.axis.CategoryAxis;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.MarkType;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.data.LineData;
import com.kd.platform.echarts.series.Line;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> OptionTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class OptionTest {

    @Test
    public void basicOption() {
        EnhancedOption option = new EnhancedOption();
        option.legend().padding(5).itemGap(10).data("ios7", "android4");
        option.toolbox().show(true).feature(Tool.dataView, Tool.saveAsImage, Tool.dataZoom, Tool.magicType);
        option.tooltip().trigger(Trigger.item);
        option.xAxis(new CategoryAxis().data("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        option.yAxis(new ValueAxis().boundaryGap(new Double[] { 0.1, 0.1 }).splitNumber(10));

        Line line = new Line();
        line.name("ios7").data(112, 23, 45, 56, 233, 343, 454, 89, 343, 123, 45, 123).markLine().data(new LineData().type(MarkType.average).name("ios7"));
        option.series(line);

        line = new Line();
        line.name("android4").data(45, 123, 145, 526, 233, 343, 44, 829, 33, 123, 45, 13).itemStyle().normal().label().show(true);
        option.series(line);

        option.view();
    }
}
