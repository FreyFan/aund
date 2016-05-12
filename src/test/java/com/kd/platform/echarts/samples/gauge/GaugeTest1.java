package com.kd.platform.echarts.samples.gauge;

import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Gauge;
import com.kd.platform.echarts.series.gauge.Detail;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> GaugeTest1.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class GaugeTest1 {

    @Test
    public void test() {
        // 地址： http://echarts.baidu.com/doc/example/gauge1.html
        EnhancedOption option = new EnhancedOption();
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("业务指标").detail(new Detail().formatter("{value}%")).data(new Data("完成率", 75)));
        option.exportToHtml("guage1.html");
        option.view();
    }
}
