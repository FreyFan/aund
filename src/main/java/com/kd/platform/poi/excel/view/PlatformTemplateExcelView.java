package com.kd.platform.poi.excel.view;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import com.kd.platform.poi.excel.ExcelExportUtil;
import com.kd.platform.poi.excel.entity.TemplateExportParams;
import com.kd.platform.poi.excel.entity.vo.NormalExcelConstants;
import com.kd.platform.poi.excel.entity.vo.TemplateExcelConstants;
import org.springframework.stereotype.Controller;

/**
 * <b>Application name:</b> PlatformTemplateExcelView.java <br>
 * <b>Application describing: Excel模板视图</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@SuppressWarnings("unchecked")
@Controller(TemplateExcelConstants.PLATFORM_TEMPLATE_EXCEL_VIEW)
public class PlatformTemplateExcelView extends MiniAbstractExcelView {

    public PlatformTemplateExcelView() {
        super();
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codedFileName = "临时文件";
        Workbook workbook = ExcelExportUtil.exportExcel((TemplateExportParams) model.get(TemplateExcelConstants.PARAMS), (Class<?>) model.get(TemplateExcelConstants.CLASS), (List<?>) model.get(TemplateExcelConstants.LIST_DATA), (Map<String, Object>) model.get(TemplateExcelConstants.MAP_DATA));
        if (model.containsKey(NormalExcelConstants.FILE_NAME)) {
            codedFileName = (String) model.get(NormalExcelConstants.FILE_NAME);
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
