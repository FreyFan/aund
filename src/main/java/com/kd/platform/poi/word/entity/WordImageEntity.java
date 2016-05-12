package com.kd.platform.poi.word.entity;

/**
 * <b>Application name:</b> WordImageEntity.java <br>
 * <b>Application describing: word导出,图片设置和图片信息</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class WordImageEntity {

    public static String URL = "url";

    public static String Data = "data";

    /**
     * 图片输入方式
     */
    private String type = URL;

    /**
     * 图片宽度
     */
    private int width;

    // 图片高度
    private int height;

    // 图片地址
    private String url;

    // 图片信息
    private byte[] data;

    public WordImageEntity() {

    }

    public WordImageEntity(byte[] data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;
        this.type = Data;
    }

    public WordImageEntity(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public byte[] getData() {
        return data;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
