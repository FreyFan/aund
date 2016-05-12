package com.kd.platform.echarts.samples.chord;

import com.kd.platform.echarts.code.*;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Chord;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> ChordTest1.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ChordTest1 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/chord1.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("测试数据").subtext("From d3.js").x(X.right).y(Y.bottom);
        option.tooltip().trigger(Trigger.item);
        option.toolbox().show(true).feature(Tool.restore, Tool.saveAsImage);
        option.legend().x(X.left).data("group1", "group2", "group3", "group4");

        Chord chord = new Chord();
        chord.sort(Sort.ascending).sortSub(Sort.descending).showScale(true).showScaleText(true).data(new Data().name("group1"), new Data().name("group2"), new Data().name("group3"), new Data().name("group4")).matrix(new Object[][] { { 11975, 5871, 8916, 2868 }, { 1951, 10048, 2060, 6171 }, { 8010, 16145, 8090, 8045 }, { 1013, 990, 940, 6907 } }).itemStyle().normal().label().show(true);
        option.series(chord);
        option.exportToHtml("chord1.html");
        option.view();
    }
}
