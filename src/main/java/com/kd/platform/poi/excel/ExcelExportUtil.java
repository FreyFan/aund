package com.kd.platform.poi.excel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.kd.platform.poi.excel.entity.ExportParams;
import com.kd.platform.poi.excel.entity.TemplateExportParams;
import com.kd.platform.poi.excel.entity.enmus.ExcelType;
import com.kd.platform.poi.excel.entity.params.ExcelExportEntity;
import com.kd.platform.poi.excel.export.ExcelExportServer;
import com.kd.platform.poi.excel.export.template.ExcelExportOfTemplateUtil;

/**
 * <b>Application name:</b> ExcelExportUtil.java <br>
 * <b>Application describing:excel 导出工具类 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public final class ExcelExportUtil {

    private ExcelExportUtil() {
    }

    /**
     * @param entity 表格标题属性
     * @param pojoClass Excel对象Class
     * @param dataSet Excel对象数据List
     */
    public static Workbook exportExcel(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet) {
        Workbook workbook;
        if (ExcelType.HSSF.equals(entity.getType())) {
            workbook = new HSSFWorkbook();
        } else if (dataSet.size() < 1000) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new SXSSFWorkbook();
        }
        new ExcelExportServer().createSheet(workbook, entity, pojoClass, dataSet);
        return workbook;
    }

    /**
     * 根据Map创建对应的Excel
     * @param entity 表格标题属性
     * @param pojoClass Excel对象Class
     * @param dataSet Excel对象数据List
     */
    public static Workbook exportExcel(ExportParams entity, List<ExcelExportEntity> entityList, Collection<? extends Map<?, ?>> dataSet) {
        Workbook workbook;
        if (ExcelType.HSSF.equals(entity.getType())) {
            workbook = new HSSFWorkbook();
        } else if (dataSet.size() < 1000) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new SXSSFWorkbook();
        }
        new ExcelExportServer().createSheetForMap(workbook, entity, entityList, dataSet);
        return workbook;
    }

    /**
     * 一个excel 创建多个sheet
     * @param list 多个Map key title 对应表格Title key entity 对应表格对应实体 key data Collection 数据
     * @return
     */
    public static Workbook exportExcel(List<Map<String, Object>> list, String type) {
        Workbook workbook;
        if (ExcelType.HSSF.equals(type)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }
        for (Map<String, Object> map : list) {
            ExcelExportServer server = new ExcelExportServer();
            server.createSheet(workbook, (ExportParams) map.get("title"), (Class<?>) map.get("entity"), (Collection<?>) map.get("data"));
        }
        return workbook;
    }

    /**
     * 导出文件通过模板解析,不推荐这个了,推荐全部通过模板来执行处理
     * @param params 导出参数类
     * @param pojoClass 对应实体
     * @param dataSet 实体集合
     * @param map 模板集合
     * @return
     */
    public static Workbook exportExcel(TemplateExportParams params, Class<?> pojoClass, Collection<?> dataSet, Map<String, Object> map) {
        return new ExcelExportOfTemplateUtil().createExcleByTemplate(params, pojoClass, dataSet, map);
    }

    /**
     * 导出文件通过模板解析只有模板,没有集合
     * @param params 导出参数类
     * @param map 模板集合
     * @return
     */
    public static Workbook exportExcel(TemplateExportParams params, Map<String, Object> map) {
        return new ExcelExportOfTemplateUtil().createExcleByTemplate(params, null, null, map);
    }

}
