package com.kd.platform.echarts.samples.funnel;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.LabelLine;
import com.kd.platform.echarts.code.Position;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Funnel;
import com.kd.platform.echarts.style.TextStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> FunnelTest2.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class FunnelTest2 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/funnel2.html
        EnhancedOption option = new EnhancedOption();
        option.color("rgba(255, 69, 0, 0.5)", "rgba(255, 150, 0, 0.5)", "rgba(255, 200, 0, 0.5)", "rgba(155, 200, 50, 0.5)", "rgba(55, 200, 100, 0.5)");
        option.title().text("漏斗图").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.legend("展现", "点击", "访问", "咨询", "订单");
        option.calculable(true);

        Funnel funnel = new Funnel("预期");
        funnel.x("10%").y(60).width("80%");
        funnel.itemStyle().normal().label(new Label().formatter("{b}预期")).labelLine(new LabelLine().show(false));
        funnel.itemStyle().emphasis().label(new Label().formatter("{b}预期 : {c}%").position(Position.inside)).labelLine(new LabelLine().show(true));

        funnel.data(new Data().value(60).name("访问"), new Data().value(40).name("咨询"), new Data().value(20).name("订单"), new Data().value(80).name("点击"), new Data().value(100).name("展现"));

        Funnel funnel2 = new Funnel("实际");
        funnel2.x("10%").y(60).width("80%").maxSize("80%");
        funnel2.itemStyle().normal().label(new Label().formatter("{c}%").position(Position.inside).textStyle(new TextStyle().color("#fff"))).borderColor("#fff").borderWidth(2);
        funnel2.itemStyle().emphasis().label(new Label().formatter("{b}实际 : {c}%").position(Position.inside)).labelLine(new LabelLine().show(true));

        funnel2.data(new Data().value(30).name("访问"), new Data().value(10).name("咨询"), new Data().value(5).name("订单"), new Data().value(50).name("点击"), new Data().value(80).name("展现"));

        option.series(funnel, funnel2);
        option.exportToHtml("funnel2.html");
        option.view();
    }
}
