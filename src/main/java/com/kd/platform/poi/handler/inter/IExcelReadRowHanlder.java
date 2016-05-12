package com.kd.platform.poi.handler.inter;

/**
 * <b>Application name:</b> IExcelReadRowHanlder.java <br>
 * <b>Application describing: 接口自定义处理类</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public interface IExcelReadRowHanlder<T> {
    /**
     * 处理解析对象
     * @param t
     */
    public void hanlder(T t);

}
