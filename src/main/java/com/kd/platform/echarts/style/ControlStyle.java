package com.kd.platform.echarts.style;

/**
 * <b>Application name:</b> ControlStyle.java <br>
 * <b>Application describing:时间轴控制器样式 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-5-19 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ControlStyle implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 正常
     */
    private Color normal;

    /**
     * 高亮
     */
    private Color emphasis;

    /**
     * 构造函数
     */
    public ControlStyle() {
    }

    /**
     * 获取normal值
     */
    public Color normal() {
        if (this.normal == null) {
            this.normal = new Color();
        }
        return this.normal;
    }

    /**
     * 设置normal值
     * @param normal
     */
    public ControlStyle normal(Color normal) {
        this.normal = normal;
        return this;
    }

    /**
     * 获取emphasis值
     */
    public Color emphasis() {
        if (this.emphasis == null) {
            this.emphasis = new Color();
        }
        return this.emphasis;
    }

    /**
     * 设置emphasis值
     * @param emphasis
     */
    public ControlStyle emphasis(Color emphasis) {
        this.emphasis = emphasis;
        return this;
    }

    /**
     * 获取normal值
     */
    public Color getNormal() {
        return normal;
    }

    /**
     * 设置normal值
     * @param normal
     */
    public void setNormal(Color normal) {
        this.normal = normal;
    }

    /**
     * 获取emphasis值
     */
    public Color getEmphasis() {
        return emphasis;
    }

    /**
     * 设置emphasis值
     * @param emphasis
     */
    public void setEmphasis(Color emphasis) {
        this.emphasis = emphasis;
    }

    public class Color {
        /**
         * 时间轴控制器样式颜色
         */
        private String color;

        /**
         * 获取color值
         */
        public String color() {
            return this.color;
        }

        /**
         * 设置color值
         * @param color
         */
        public Color color(String color) {
            this.color = color;
            return this;
        }

        /**
         * 获取color值
         */
        public String getColor() {
            return color;
        }

        /**
         * 设置color值
         * @param color
         */
        public void setColor(String color) {
            this.color = color;
        }
    }
}
