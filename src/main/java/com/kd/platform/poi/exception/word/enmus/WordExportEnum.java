package com.kd.platform.poi.exception.word.enmus;

/**
 * <b>Application name:</b> WordExportEnum.java <br>
 * <b>Application describing: 导出异常枚举</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public enum WordExportEnum {

    EXCEL_PARAMS_ERROR("Excel 导出 参数错误"), EXCEL_HEAD_HAVA_NULL("Excel 表头 有的字段为空"), EXCEL_NO_HEAD("Excel 没有表头");

    private String msg;

    WordExportEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
