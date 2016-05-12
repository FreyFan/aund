package com.kd.platform.echarts.samples.eventriver;

import com.kd.platform.echarts.axis.TimeAxis;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.series.EventRiver;
import com.kd.platform.echarts.series.event.Event;
import com.kd.platform.echarts.series.event.Evolution;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> EventRiverTest1.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class EventRiverTest1 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/bar1.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("Event River").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.item);
        option.legend("财经事件", "政治事件");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.xAxis(new TimeAxis().boundaryGap(0.05, 0.1));

        EventRiver eventRiver1 = new EventRiver("财经事件", 123);
        eventRiver1.eventList(
                new Event("阿里巴巴上市", 123).evolution(new Evolution("2014-05-01", 14).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-02", 34).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-03", 60).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-04", 40).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-05", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")),
                new Event("阿里巴巴上市2", 123).evolution(new Evolution("2014-05-02", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-03", 34).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-04", 40).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-05", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")),
                new Event("三星业绩暴跌", 123).evolution(new Evolution("2014-05-03", 24).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-04", 34).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-05", 50).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-06", 30).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-07", 20).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")));

        EventRiver eventRiver2 = new EventRiver("政治事件", 123);
        eventRiver2.eventList(
                new Event("Apec峰会", 123).evolution(new Evolution("2014-05-06", 14).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-07", 34).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-08", 60).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-09", 40).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-10", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")),
                new Event("运城官帮透视", 123).evolution(new Evolution("2014-05-08", 4).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-09", 14).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-10", 30).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-11", 20).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-12", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")),
                new Event("底层公务员收入超过副部长", 123).evolution(new Evolution("2014-05-11", 4).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-12", 24).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-13", 40).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"),
                        new Evolution("2014-05-14", 20).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-15", 15).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png"), new Evolution("2014-05-16", 10).detail("http://www.baidu.com", "百度指数", "http://echarts.baidu.com/doc/asset/ico/favicon.png")));

        option.series(eventRiver1, eventRiver2);
        option.exportToHtml("eventRiver1.html");
        option.view();
    }
}
