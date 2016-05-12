package com.kd.platform.echarts.samples.scatter;

import com.kd.platform.echarts.axis.TimeAxis;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.Orient;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.Trigger;
import com.kd.platform.echarts.code.Y;
import com.kd.platform.echarts.series.Scatter;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>Application name:</b> ScatterTest6.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ScatterTest6 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/scatter6.html
        // TODO echarts只能认识js的Date...
        EnhancedOption option = new EnhancedOption();
        option.title("时间坐标散点图", "dataZoom支持");
        option.tooltip().trigger(Trigger.item).formatter("function (params) {" + "            return params.seriesName + ' （'  + '类目' + params.value[0] + '）<br/>'" + "                   + params.value[1] + ', ' " + "                   + params.value[2];" + "        }");
        option.legend("series1");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.dataZoom().show(true).start(30).end(70);
        option.dataRange().min(0).max(100).orient(Orient.horizontal).x(30).y(Y.center).color("lightgreen", "orange").splitNumber(5);
        option.grid().y2(80);
        option.xAxis(new TimeAxis().splitNumber(10));
        option.yAxis(new ValueAxis());
        option.animation(false);

        Scatter series1 = new Scatter("series1");
        series1.symbolSize("function (value){" + "                return Math.round(value[2]/10);" + "            }");
        series1.data(getData().toArray());

        option.series(series1);
        option.exportToHtml("scatter6.html");
        option.view();
    }

    public List<Object[]> getData() {
        List<Object[]> dataList = new ArrayList<Object[]>(1500);
        for (int i = 0; i < 1500; i++) {
            dataList.add(new Object[] { getDateStr(new Date(114, 9, 1, 0, (int) Math.round(Math.random() * 10000))), (int) (round(Math.random() * 30) - 0), (int) (round(Math.random() * 100) - 0) });
        }
        return dataList;
    }

    public String getDateStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    public Double round(Double d) {
        BigDecimal bigDecimal = new BigDecimal(d.toString());
        bigDecimal = bigDecimal.round(new MathContext(2, RoundingMode.HALF_UP));
        return bigDecimal.doubleValue();
    }
}
