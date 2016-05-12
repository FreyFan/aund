package com.kd.platform.echarts.samples.funnel;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.LabelLine;
import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Funnel;
import com.kd.platform.echarts.style.LineStyle;
import com.kd.platform.echarts.style.TextStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> FunnelTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class FunnelTest {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/funnel.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("漏斗图").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.legend("展现", "点击", "访问", "咨询", "订单");
        option.calculable(true);

        Funnel funnel = new Funnel("漏斗图");
        funnel.x("10%").y(60).width("80%").min(0).max(100).minSize("0%").maxSize("100%").sort(Sort.descending).gap(10);
        funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).label(new Label().show(true).position(Position.inside)).labelLine(new LabelLine().show(false).length(10).lineStyle(new LineStyle().width(1).type(LineType.solid)));
        funnel.itemStyle().emphasis().borderColor("red").borderWidth(5).label(new Label().show(true).formatter("{b}:{c}%").textStyle(new TextStyle().fontSize(20))).labelLine(new LabelLine().show(true));

        funnel.data(new Data().value(60).name("访问"), new Data().value(40).name("咨询"), new Data().value(20).name("订单"), new Data().value(80).name("点击"), new Data().value(100).name("展现"));

        option.series(funnel);
        option.exportToHtml("funnel.html");
        option.view();
    }
}
