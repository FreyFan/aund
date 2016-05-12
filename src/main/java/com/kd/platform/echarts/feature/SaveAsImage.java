package com.kd.platform.echarts.feature;

/**
 * <b>Application name:</b> SaveAsImage.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class SaveAsImage extends Feature {
    /**
     * 构造函数
     */
    public SaveAsImage() {
        this.show(true);
        this.title("保存为图片");
        this.type("png");
        this.lang(new String[] { "点击保存" });
    }
}
