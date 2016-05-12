package com.kd.platform.echarts.util;

import com.kd.platform.echarts.TestConfig;
import com.kd.platform.echarts.json.GsonOption;
import com.kd.platform.echarts.json.GsonUtil;
import com.kd.platform.echarts.json.OptionUtil;

/**
 * <b>Application name:</b> EnhancedOption.java <br>
 * <b>Application describing: 增强的Option - 主要用于测试、演示</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class EnhancedOption extends GsonOption implements TestConfig {
    private String filepath;

    /**
     * 输出到控制台
     */
    public void print() {
        GsonUtil.print(this);
    }

    /**
     * 输出到控制台
     */
    public void printPretty() {
        GsonUtil.printPretty(this);
    }

    /**
     * 在浏览器中查看
     */
    public void view() {
        if (!VIEW) {
            return;
        }
        if (this.filepath != null) {
            try {
                OptionUtil.browse(this.filepath);
            } catch (Exception e) {
                this.filepath = OptionUtil.browse(this);
            }
        } else {
            this.filepath = OptionUtil.browse(this);
        }
    }

    /**
     * 导出到指定文件名
     * @param fileName
     * @return 返回html路径
     */
    public String exportToHtml(String fileName) {
        return exportToHtml(EXPORT_PATH, fileName);
    }
}
