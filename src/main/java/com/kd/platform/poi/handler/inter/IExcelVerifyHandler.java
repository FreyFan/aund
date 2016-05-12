package com.kd.platform.poi.handler.inter;

import com.kd.platform.poi.excel.entity.result.ExcelVerifyHanlderResult;

/**
 * <b>Application name:</b> IExcelVerifyHandler.java <br>
 * <b>Application describing: 导入校验接口</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface IExcelVerifyHandler {

    /**
     * 获取需要处理的字段,导入和导出统一处理了, 减少书写的字段
     * @return
     */
    public String[] getNeedVerifyFields();

    /**
     * 获取需要处理的字段,导入和导出统一处理了, 减少书写的字段
     * @return
     */
    public void setNeedVerifyFields(String[] arr);

    /**
     * 导出处理方法
     * @param obj 当前对象
     * @param name 当前字段名称
     * @param value 当前值
     * @return
     */
    public ExcelVerifyHanlderResult verifyHandler(Object obj, String name, Object value);

}
