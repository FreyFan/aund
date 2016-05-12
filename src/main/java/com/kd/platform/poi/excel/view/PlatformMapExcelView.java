package com.kd.platform.poi.excel.view;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import com.kd.platform.poi.excel.ExcelExportUtil;
import com.kd.platform.poi.excel.entity.ExportParams;
import com.kd.platform.poi.excel.entity.params.ExcelExportEntity;
import com.kd.platform.poi.excel.entity.vo.MapExcelConstants;
import org.springframework.stereotype.Controller;

/**
 * <b>Application name:</b> PlatformMapExcelView.java <br>
 * <b>Application describing: Map 对象接口</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@SuppressWarnings("unchecked")
@Controller(MapExcelConstants.PLATFORM_MAP_EXCEL_VIEW)
public class PlatformMapExcelView extends MiniAbstractExcelView {

    public PlatformMapExcelView() {
        super();
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codedFileName = "临时文件";
        Workbook workbook = ExcelExportUtil.exportExcel((ExportParams) model.get(MapExcelConstants.PARAMS), (List<ExcelExportEntity>) model.get(MapExcelConstants.ENTITY_LIST), (Collection<? extends Map<?, ?>>) model.get(MapExcelConstants.MAP_LIST));
        if (model.containsKey(MapExcelConstants.FILE_NAME)) {
            codedFileName = (String) model.get(MapExcelConstants.FILE_NAME);
        }
        if (workbook instanceof HSSFWorkbook) {
            codedFileName += HSSF;
        } else {
            codedFileName += XSSF;
        }
        if (isIE(request)) {
            codedFileName = java.net.URLEncoder.encode(codedFileName, "UTF8");
        } else {
            codedFileName = new String(codedFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }

}
