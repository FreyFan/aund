package com.kd.platform.echarts.samples.pie;

import com.kd.platform.echarts.Option;
import com.kd.platform.echarts.code.Magic;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.data.LineData;
import com.kd.platform.echarts.data.PieData;
import com.kd.platform.echarts.feature.MagicType;
import com.kd.platform.echarts.series.Funnel;
import com.kd.platform.echarts.series.Pie;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> PieTest7.java <br>
 * <b>Application describing: 复杂的时间轴效果</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PieTest7 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/pie7.html
        EnhancedOption option = new EnhancedOption();
        // 时间轴
        option.timeline().data("2013-01-01", "2013-02-01", "2013-03-01", "2013-04-01", "2013-05-01", new LineData("2013-06-01", "emptyStart6", 8), "2013-07-01", "2013-08-01", "2013-09-01", "2013-10-01", "2013-11-01", new LineData("2013-12-01", "star6", 8));
        option.timeline().autoPlay(true).label().formatter("function(s){return s.slice(0,7);}");
        // timeline变态的地方在于多个Option
        Option basic = new Option();
        basic.title().text("浏览器占比变化").subtext("纯属虚构");
        basic.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        basic.legend().data("Chrome", "Firefox", "Safari", "IE9+", "IE8-");
        basic.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage, new MagicType(Magic.pie, Magic.funnel).option(new MagicType.Option().funnel(new Funnel().x("25%").width("50%").funnelAlign(X.left).max(1548))));

        int idx = 1;
        basic.series(getPie(idx++).center("50%", "45%").radius("50%"));
        // 加入
        option.options(basic);
        // 构造11个数据
        Option[] os = new Option[11];
        for (int i = 0; i < os.length; i++) {
            os[i] = new Option().series(getPie(idx++));
        }
        option.options(os);
        option.exportToHtml("pie7.html");
        option.view();
    }

    /**
     * 获取饼图数据
     * @param idx
     * @return
     */
    public Pie getPie(int idx) {
        return new Pie().name("浏览器（数据纯属虚构）").data(new PieData("Chrome", idx * 128 + 80), new PieData("Firefox", idx * 64 + 160), new PieData("Safari", idx * 32 + 320), new PieData("IE9+", idx * 16 + 640), new PieData("IE8-", idx * 8 + 1280));
    }
}
