package com.kd.platform.poi.handler.inter;

/**
 * <b>Application name:</b> IExcelDataHandler.java <br>
 * <b>Application describing: Excel 导入导出 数据处理接口</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface IExcelDataHandler {

    /**
     * 导出处理方法
     * @param obj 当前对象
     * @param name 当前字段名称
     * @param value 当前值
     * @return
     */
    public Object exportHandler(Object obj, String name, Object value);

    /**
     * 获取需要处理的字段,导入和导出统一处理了, 减少书写的字段
     * @return
     */
    public String[] getNeedHandlerFields();

    /**
     * 导入处理方法 当前对象,当前字段名称,当前值
     * @param obj 当前对象
     * @param name 当前字段名称
     * @param value 当前值
     * @return
     */
    public Object importHandler(Object obj, String name, Object value);

    /**
     * 设置需要处理的属性列表
     * @param fields
     */
    public void setNeedHandlerFields(String[] fields);

}
