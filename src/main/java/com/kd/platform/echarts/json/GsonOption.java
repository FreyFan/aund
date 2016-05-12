package com.kd.platform.echarts.json;

import com.kd.platform.echarts.Option;

/**
 * <b>Application name:</b> GsonOption.java <br>
 * <b>Application describing:增强的Option - 主要用于测试、演示 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class GsonOption extends Option {

    /**
     * 在浏览器中查看
     */
    public void view() {
        OptionUtil.browse(this);
    }

    @Override
    /**
     * 获取toString值
     */
    public String toString() {
        return GsonUtil.format(this);
    }

    /**
     * 获取toPrettyString值
     */
    public String toPrettyString() {
        return GsonUtil.prettyFormat(this);
    }

    /**
     * 导出到指定文件名
     * @param fileName
     * @return 返回html路径
     */
    public String exportToHtml(String fileName) {
        return exportToHtml(System.getProperty("java.io.tmpdir"), fileName);
    }

    /**
     * 导出到指定文件名
     * @param fileName
     * @return 返回html路径
     */
    public String exportToHtml(String filePath, String fileName) {
        return OptionUtil.exportToHtml(this, filePath, fileName);
    }

}
