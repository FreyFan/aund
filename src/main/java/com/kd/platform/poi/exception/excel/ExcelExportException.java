package com.kd.platform.poi.exception.excel;

import com.kd.platform.poi.exception.excel.enums.ExcelExportEnum;

/**
 * <b>Application name:</b> ExcelExportException.java <br>
 * <b>Application describing: 导出异常</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ExcelExportException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ExcelExportEnum type;

    public ExcelExportException() {
        super();
    }

    public ExcelExportException(ExcelExportEnum type) {
        super(type.getMsg());
        this.type = type;
    }

    public ExcelExportException(ExcelExportEnum type, Throwable cause) {
        super(type.getMsg(), cause);
    }

    public ExcelExportException(String message) {
        super(message);
    }

    public ExcelExportException(String message, ExcelExportEnum type) {
        super(message);
        this.type = type;
    }

    public ExcelExportEnum getType() {
        return type;
    }

    public void setType(ExcelExportEnum type) {
        this.type = type;
    }

}
