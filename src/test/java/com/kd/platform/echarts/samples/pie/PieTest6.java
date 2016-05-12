package com.kd.platform.echarts.samples.pie;

import com.kd.platform.echarts.Label;
import com.kd.platform.echarts.code.Orient;
import com.kd.platform.echarts.code.Tool;
import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.code.Y;
import com.kd.platform.echarts.data.Data;
import com.kd.platform.echarts.series.Pie;
import com.kd.platform.echarts.style.ItemStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> PieTest6.java <br>
 * <b>Application describing: 复杂的时间轴效果</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PieTest6 {

    @Test
    public void test() {
        // 地址：http://echarts.baidu.com/doc/example/pie6.html
        ItemStyle dataStyle = new ItemStyle();
        dataStyle.normal().label(new Label().show(false)).labelLine().show(false);

        ItemStyle placeHolderStyle = new ItemStyle();
        placeHolderStyle.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
        placeHolderStyle.emphasis().color("rgba(0,0,0,0)");

        EnhancedOption option = new EnhancedOption();
        option.title().text("你幸福吗？").subtext("From ExcelHome").sublink("http://e.weibo.com/1341556070/AhQXtjbqh").x(X.center).y(Y.center).itemGap(20).textStyle().color("rgba(30,144,255,0.8)").fontFamily("微软雅黑").fontSize(35).fontWeight("bolder");
        option.tooltip().show(true).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical).x("(function(){return document.getElementById('main').offsetWidth / 2;})()").y(56).itemGap(12).data("68%的人表示过的不错", "29%的人表示生活压力很大", "3%的人表示“我姓曾”");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);

        Pie p1 = new Pie("1");
        p1.clockWise(false).radius(125, 150).itemStyle(dataStyle).data(new Data("68%的人表示过的不错", 68), new Data("invisible", 32).itemStyle(placeHolderStyle));

        Pie p2 = new Pie("2");
        p2.clockWise(false).radius(100, 125).itemStyle(dataStyle).data(new Data("29%的人表示生活压力很大", 29), new Data("invisible", 71).itemStyle(placeHolderStyle));

        Pie p3 = new Pie("3");
        p3.clockWise(false).radius(75, 100).itemStyle(dataStyle).data(new Data("3%的人表示“我姓曾”", 3), new Data("invisible", 97).itemStyle(placeHolderStyle));

        option.series(p1, p2, p3);
        option.exportToHtml("pie6.html");
        option.view();
    }
}
