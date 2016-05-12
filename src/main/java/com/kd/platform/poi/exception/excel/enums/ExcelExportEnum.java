package com.kd.platform.poi.exception.excel.enums;

/**
 * <b>Application name:</b> ExcelExportEnum.java <br>
 * <b>Application describing: 导出异常类型枚举</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public enum ExcelExportEnum {

    PARAMETER_ERROR("Excel 导出   参数错误"), EXPORT_ERROR("Excel导出错误");

    private String msg;

    ExcelExportEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
