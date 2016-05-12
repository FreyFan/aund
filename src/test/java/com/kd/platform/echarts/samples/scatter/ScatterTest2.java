package com.kd.platform.echarts.samples.scatter;

import com.kd.platform.echarts.AxisPointer;
import com.kd.platform.echarts.Tooltip;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.data.ScatterData;
import com.kd.platform.echarts.series.Scatter;
import com.kd.platform.echarts.style.LineStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> ScatterTest2.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ScatterTest2 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/scatter2.html
        EnhancedOption option = new EnhancedOption();
        option.tooltip(new Tooltip().trigger(Trigger.axis).showDelay(0).axisPointer(new AxisPointer().type(PointerType.cross).lineStyle(new LineStyle().type(LineType.dashed).width(1))));
        option.legend("scatter1", "scatter2");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataZoom, Tool.dataView, Tool.restore, Tool.saveAsImage);
        ValueAxis valueAxis = new ValueAxis().power(1).splitNumber(4).scale(true);
        option.xAxis(valueAxis);
        option.yAxis(valueAxis);
        // 注：这里的结果是一种圆形一种方形，是因为默认不设置形状时，会循环形状数组
        option.series(new Scatter("scatter1").symbolSize("function (value){" + "                return Math.round(value[2] / 5);" + "            }").data(randomDataArray()), new Scatter("scatter2").symbolSize("function (value){" + "                return Math.round(value[2] / 5);" + "            }").data(randomDataArray()));
        option.exportToHtml("scatter2.html");
        option.view();
    }

    private ScatterData[] randomDataArray() {
        ScatterData[] scatters = new ScatterData[100];
        for (int i = 0; i < scatters.length; i++) {
            scatters[i] = new ScatterData(random(), random(), Math.abs(random()));
        }
        return scatters;
    }

    private int random() {
        int i = (int) Math.round(Math.random() * 100);
        return (i * (i % 2 == 0 ? 1 : -1));
    }
}
