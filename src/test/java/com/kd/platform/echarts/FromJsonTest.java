package com.kd.platform.echarts;

import com.kd.platform.echarts.json.GsonUtil;
import com.kd.platform.echarts.series.Bar;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

/**
 * <b>Application name:</b> FromJsonTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class FromJsonTest {

    @Test
    public void testFromJson() {
        String json = "{\n" + "    tooltip : {\n" + "        trigger: 'axis',\n" + "        axisPointer : {            // 坐标轴指示器，坐标轴触发有效\n" + "            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'\n" + "        }\n" + "    },\n" + "    legend: {\n" + "        data:['利润', '支出', '收入']\n" + "    },\n" + "    toolbox: {\n" + "        show : true,\n" + "        feature : {\n" + "            mark : {show: true},\n" + "            dataView : {show: true, readOnly: false},\n"
                + "            magicType : {show: true, type: ['line', 'bar']},\n" + "            restore : {show: true},\n" + "            saveAsImage : {show: true}\n" + "        }\n" + "    },\n" + "    calculable : true,\n" + "    xAxis : [\n" + "        {\n" + "            type : 'value'\n" + "        }\n" + "    ],\n" + "    yAxis : [\n" + "        {\n" + "            type : 'category',\n" + "            axisTick : {show: false},\n"
                + "            data : ['周一','周二','周三','周四','周五','周六','周日']\n" + "        }\n" + "    ],\n" + "    series : [\n" + "        {\n" + "            name:'利润',\n" + "            type:'bar',\n" + "            itemStyle : { normal: {label : {show: true, position: 'inside'}}},\n" + "            data:[200, 170, 240, 244, 200, 220, 210]\n" + "        },\n" + "        {\n" + "            name:'收入',\n" + "            type:'bar',\n" + "            stack: '总量',\n"
                + "            barWidth : 5,\n" + "            itemStyle: {normal: {\n" + "                label : {show: true}\n" + "            }},\n" + "            data:[320, 302, 341, 374, 390, 450, 420]\n" + "        },\n" + "        {\n" + "            name:'支出',\n" + "            type:'bar',\n" + "            stack: '总量',\n" + "            itemStyle: {normal: {\n" + "                label : {show: true, position: 'left'}\n" + "            }},\n"
                + "            data:[-120, -132, -101, -134, -190, -230, -210]\n" + "        }\n" + "    ]\n" + "}";

        EnhancedOption option = GsonUtil.fromJSON(json, EnhancedOption.class);
        // 增加一些内容
        option.legend("测试");
        Bar bar = new Bar();
        bar.name("测试").stack("总量").data(142, 123, 65, 441, 341, 467, 90).itemStyle().normal().label().show(true);
        option.series(bar);
        option.view();
    }

    @Test
    public void testAxisFromJson() {
        String json = "{\"xAxis\": [{\"splitNumber\":10, \"type\": \"time\"}]}";
        EnhancedOption option = GsonUtil.fromJSON(json, EnhancedOption.class);
        System.out.println(option);
    }
}
