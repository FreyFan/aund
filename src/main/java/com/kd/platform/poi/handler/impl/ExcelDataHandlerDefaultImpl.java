package com.kd.platform.poi.handler.impl;

import com.kd.platform.poi.handler.inter.IExcelDataHandler;

/**
 * <b>Application name:</b> ExcelDataHandlerDefaultImpl.java <br>
 * <b>Application describing: 数据处理默认实现,返回空</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public abstract class ExcelDataHandlerDefaultImpl implements IExcelDataHandler {
    /**
     * 需要处理的字段
     */
    private String[] needHandlerFields;

    public Object exportHandler(Object obj, String name, Object value) {
        return value;
    }

    public String[] getNeedHandlerFields() {
        return needHandlerFields;
    }

    public Object importHandler(Object obj, String name, Object value) {
        return value;
    }

    public void setNeedHandlerFields(String[] needHandlerFields) {
        this.needHandlerFields = needHandlerFields;
    }
}
