package com.kd.platform.echarts.feature;

import com.kd.platform.echarts.code.Magic;
import com.kd.platform.echarts.series.Funnel;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Application name:</b> MagicType.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MagicType extends Feature {
    /**
     * 内部类 Option
     */
    public static class Option {
        private Funnel funnel;

        public Option funnel(Funnel funnel) {
            this.funnel = funnel;
            return this;
        }

        public Funnel funnel() {
            return this.funnel;
        }

        public Funnel getFunnel() {
            return funnel;
        }

        public void setFunnel(Funnel funnel) {
            this.funnel = funnel;
        }
    }

    private Option option;

    /**
     * 设置Option
     * @param option
     * @return
     */
    public Feature option(Option option) {
        this.option = option;
        return this;
    }

    /**
     * 获取Option
     * @return
     */
    public Option option() {
        return this.option;
    }

    /**
     * 获取option值
     * @return
     */
    public Option getOption() {
        return option;
    }

    /**
     * 设置option
     * @param option
     */
    public void setOption(Option option) {
        this.option = option;
    }

    /**
     * 构造函数,参数:magics
     * @param magics
     */
    public MagicType(Magic... magics) {
        this.show(true);
        Map title = new HashMap<String, String>();
        title.put("line", "折线图切换");
        title.put("bar", "柱形图切换");
        title.put("stack", "堆积");
        title.put("tiled", "平铺");
        this.title(title);
        if (magics == null || magics.length == 0) {
            this.type(new Object[] { Magic.bar, Magic.line, Magic.stack, Magic.tiled });
        } else {
            this.type(magics);
        }
    }
}
