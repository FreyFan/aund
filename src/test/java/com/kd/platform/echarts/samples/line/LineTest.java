package com.kd.platform.echarts.samples.line;

import com.kd.platform.echarts.axis.CategoryAxis;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.Symbol;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.data.LineData;
import com.kd.platform.echarts.series.Line;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> LineTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class LineTest {

    @Test
    public void test() {
        // 例子：http://echarts.baidu.com/doc/example/line.html
        EnhancedOption option = new EnhancedOption();
        option.tooltip().trigger(Trigger.axis);
        option.legend("邮件营销", "联盟广告", "直接访问", "搜索引擎");
        option.toolbox().show(true);
        option.calculable(true);
        option.xAxis(new CategoryAxis().boundaryGap(false).data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        option.yAxis(new ValueAxis());
        option.series(new Line().smooth(true).name("邮件营销").stack("总量").symbol(Symbol.none).data(120, 132, 301, 134, new LineData(90, Symbol.droplet, 5), 230, 210));

        // 实现不了js的这个效果
        // line.itemStyle.normal.areaStyle = new AreaStyle();
        LineData lineData = new LineData(201, Symbol.star, 15);
        lineData.itemStyle().normal().label().show(true);
        option.series(new Line().smooth(true).name("联盟广告").stack("总量").symbol("image://http://echarts.baidu.com/doc/asset/ico/favicon.png").symbolSize(8).data(120, 82, lineData, new LineData(134, Symbol.none), 190, new LineData(230, Symbol.emptypin, 8), 110));

        option.exportToHtml("line.html");
        option.view();
    }
}
