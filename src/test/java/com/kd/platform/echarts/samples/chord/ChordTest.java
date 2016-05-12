package com.kd.platform.echarts.samples.chord;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.data.PointData;
import com.kd.platform.echarts.series.Chord;
import com.kd.platform.echarts.series.MarkPoint;
import com.kd.platform.echarts.style.ChordStyle;
import com.kd.platform.echarts.style.ItemStyle;
import com.kd.platform.echarts.style.LineStyle;
import com.kd.platform.echarts.style.itemstyle.Emphasis;
import com.kd.platform.echarts.style.itemstyle.Normal;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> ChordTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ChordTest {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/chord.html
        EnhancedOption option = new EnhancedOption();
        option.title("测试数据").tooltip(Trigger.item);
        option.toolbox().show(true).y(Y.bottom).feature(Tool.restore, Tool.saveAsImage);
        option.legend().x(X.right).data("g1", "g2", "g3", "g4");

        Chord chord = new Chord();
        chord.sort(Sort.descending).sortSub(Sort.descending).radius("55%", "75%").startAngle(90).clockWise(false).showScale(true).showScaleText(true).data(new Data("g1").itemStyle(new ItemStyle().normal(new Normal().color("rgba(255,30,30,0.5)").lineStyle(new LineStyle().width(1).color("green"))).emphasis(new Emphasis().color("yellow").lineStyle(new LineStyle().width(2).color("blue")))), new Data("g2"), new Data("g3"), new Data("g4"))
                .matrix(new Object[][] { { 11975, 5871, 8916, 2868 }, { 1951, 10048, 2060, 6171 }, { 8010, 16145, 8090, 8045 }, { 1013, 990, 940, 6907 } }).markPoint(new MarkPoint().symbol(Symbol.star).data(new PointData("打酱油的标注", 100).x("5%").y("50%").symbolSize(32), new PointData("打酱油的标注", 100).x("95%").y("50%").symbolSize(32))).itemStyle()
                .normal(new Normal().lineStyle(new LineStyle().width(0).color("#000")).chordStyle(new ChordStyle().width(1).color("#333")).label(new Label().show(true).color("red"))).emphasis(new Emphasis().lineStyle(new LineStyle().width(0).color("#000")).chordStyle(new ChordStyle().width(2).color("black")));
        option.series(chord);
        option.exportToHtml("chord.html");
        option.view();
    }
}
