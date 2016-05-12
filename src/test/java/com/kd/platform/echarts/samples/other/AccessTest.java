package com.kd.platform.echarts.samples.other;

import com.kd.platform.echarts.axis.AxisLine;
import com.kd.platform.echarts.axis.CategoryAxis;
import com.kd.platform.echarts.axis.SplitLine;
import com.kd.platform.echarts.axis.ValueAxis;
import com.kd.platform.echarts.code.X;
import com.kd.platform.echarts.code.Y;
import com.kd.platform.echarts.series.Line;
import com.kd.platform.echarts.style.LineStyle;
import com.kd.platform.echarts.util.EnhancedOption;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Application name:</b> AccessTest.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class AccessTest {
    // 数据对象
    class AccessData {
        // 日期
        private String date;

        // 访问量
        private Integer nums;

        AccessData(String date, Integer nums) {
            this.date = date;
            this.nums = nums;
        }

        public String getDate() {
            return date;
        }

        public Integer getNums() {
            return nums;
        }
    }

    /**
     * 模拟从数据库获取数据
     * @return
     */
    public List<AccessData> getWeekData() {
        List<AccessData> list = new ArrayList<AccessData>(7);
        list.add(new AccessData("09-16", 4));
        list.add(new AccessData("09-17", 7));
        list.add(new AccessData("09-18", 14));
        list.add(new AccessData("09-19", 304));
        list.add(new AccessData("09-20", 66));
        list.add(new AccessData("09-21", 16));
        list.add(new AccessData("09-22", 205));
        return list;
    }

    @Test
    public void test() {
        // 获取数据
        List<AccessData> datas = getWeekData();
        // 创建Option对象
        EnhancedOption option = new EnhancedOption();
        // 设置图表标题，并且居中显示
        option.title().text("最近7天访问量图表").x(X.center);
        // 设置图例,居中底部显示，显示边框
        option.legend().data("访问量").x(X.center).y(Y.bottom).borderWidth(1);
        // 设置y轴为值轴，并且不显示y轴，最大值设置400（实际上这个属性不必设置，默认即可）
        option.yAxis(new ValueAxis().name("IP").axisLine(new AxisLine().show(true).lineStyle(new LineStyle().width(0))).max(400).min(-100));
        // 创建类目轴，并且不显示竖着的分割线
        CategoryAxis categoryAxis = new CategoryAxis().splitLine(new SplitLine().show(false)).axisLine(new AxisLine().onZero(false));
        // 不显示表格边框，就是围着图标的方框
        option.grid().borderWidth(0);
        // 创建Line数据
        Line line = new Line("访问量").smooth(true);
        // 根据获取的数据赋值
        for (AccessData data : datas) {
            // 增加类目，值为日期
            categoryAxis.data(data.getDate());
            // 日期对应的数据
            line.data(data.getNums());
        }
        // 设置x轴为类目轴
        option.xAxis(categoryAxis);
        // 设置数据
        option.series(line);
        // 打开浏览器预览
        option.exportToHtml("access.html");
        option.view();
    }
}
