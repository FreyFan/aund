package com.kd.platform.poi.word.entity.params;

import java.util.List;

import com.kd.platform.poi.excel.entity.ExcelBaseParams;
import com.kd.platform.poi.handler.inter.IExcelDataHandler;

/**
 * <b>Application name:</b> ExcelListEntity.java <br>
 * <b>Application describing: Excel 导出对象</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class ExcelListEntity extends ExcelBaseParams {

    /**
     * 数据源
     */
    private List<?> list;

    /**
     * 实体类对象
     */
    private Class<?> clazz;

    /**
     * 表头行数
     */
    private int headRows = 1;

    public ExcelListEntity() {

    }

    public ExcelListEntity(List<?> list, Class<?> clazz) {
        this.list = list;
        this.clazz = clazz;
    }

    public ExcelListEntity(List<?> list, Class<?> clazz, IExcelDataHandler dataHanlder) {
        this.list = list;
        this.clazz = clazz;
        setDataHanlder(dataHanlder);
    }

    public ExcelListEntity(List<?> list, Class<?> clazz, IExcelDataHandler dataHanlder, int headRows) {
        this.list = list;
        this.clazz = clazz;
        this.headRows = headRows;
        setDataHanlder(dataHanlder);
    }

    public ExcelListEntity(List<?> list, Class<?> clazz, int headRows) {
        this.list = list;
        this.clazz = clazz;
        this.headRows = headRows;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public int getHeadRows() {
        return headRows;
    }

    public List<?> getList() {
        return list;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setHeadRows(int headRows) {
        this.headRows = headRows;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
