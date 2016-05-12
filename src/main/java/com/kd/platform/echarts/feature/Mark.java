package com.kd.platform.echarts.feature;

import com.kd.platform.echarts.code.LineType;
import com.kd.platform.echarts.style.LineStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Application name:</b> Mark.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class Mark extends Feature {
    /**
     * 构造函数
     */
    public Mark() {
        this.show(true);
        Map title = new HashMap<String, String>();
        title.put("mark", "辅助线开关");
        title.put("markUndo", "删除辅助线");
        title.put("markClear", "清空辅助线");
        this.title(title);
        this.lineStyle(new LineStyle());
        this.lineStyle().width(2);
        this.lineStyle().color("#1e90ff");
        this.lineStyle().type(LineType.dashed);
    }
}
