package com.kd.platform.echarts.samples.scatter;

import com.kd.platform.echarts.AxisPointer;
import com.kd.platform.echarts.Tooltip;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.LineType;
import com.kd.platform.echarts.code.PointerType;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.series.Scatter;
import com.kd.platform.echarts.style.LineStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * <b>Application name:</b> ScatterTest3.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ScatterTest3 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/scatter3.html
        EnhancedOption option = new EnhancedOption();
        option.tooltip(new Tooltip().trigger(Trigger.axis).showDelay(0).axisPointer(new AxisPointer().type(PointerType.cross).lineStyle(new LineStyle().type(LineType.dashed).width(1))));
        option.legend("sin", "cos");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataZoom, Tool.dataView, Tool.restore, Tool.saveAsImage);
        ValueAxis valueAxis = new ValueAxis().power(1).precision(2).scale(true);
        option.xAxis(valueAxis);
        option.yAxis(valueAxis);

        Scatter sin = new Scatter("sin");
        sin.large(true);
        Double[][] sinData = new Double[10000][2];
        for (int i = sinData.length; i > 0; i--) {
            double x = round(Math.random() * 10) - 0;
            double y = Math.sin(x) - x * (i % 2 == 0 ? 0.1 : -0.1) * round(Math.random()) - 0;
            sinData[sinData.length - i] = new Double[] { x, y };
        }
        sin.data(sinData);

        Scatter cos = new Scatter("cos");
        cos.large(true);
        Double[][] cosData = new Double[10000][2];
        for (int i = cosData.length; i > 0; i--) {
            double x = round(Math.random() * 10) - 0;
            double y = Math.cos(x) - x * (i % 2 == 0 ? 0.1 : -0.1) * round(Math.random()) - 0;
            cosData[sinData.length - i] = new Double[] { x, y };
        }
        cos.data(cosData);
        option.series(sin, cos);
        option.exportToHtml("scatter3.html");
        option.view();
    }

    public Double round(Double d) {
        BigDecimal bigDecimal = new BigDecimal(d.toString());
        bigDecimal = bigDecimal.round(new MathContext(3, RoundingMode.HALF_UP));
        return bigDecimal.doubleValue();
    }
}
