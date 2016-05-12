package com.kd.platform.poi.excel.entity.params;

import java.util.List;

/**
 * <b>Application name:</b> MergeEntity.java <br>
 * <b>Application describing:合并单元格使用对象 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MergeEntity {
    /**
     * 合并开始行
     */
    private int startRow;

    /**
     * 合并结束行
     */
    private int endRow;

    /**
     * 文字
     */
    private String text;

    /**
     * 依赖关系文本
     */
    private List<String> relyList;

    public MergeEntity() {

    }

    public MergeEntity(String text, int startRow, int endRow) {
        this.text = text;
        this.endRow = endRow;
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public List<String> getRelyList() {
        return relyList;
    }

    public int getStartRow() {
        return startRow;
    }

    public String getText() {
        return text;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public void setRelyList(List<String> relyList) {
        this.relyList = relyList;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public void setText(String text) {
        this.text = text;
    }
}
