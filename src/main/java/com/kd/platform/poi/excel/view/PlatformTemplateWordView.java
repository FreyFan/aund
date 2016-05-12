package com.kd.platform.poi.excel.view;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.kd.platform.poi.excel.entity.vo.TemplateWordConstants;
import com.kd.platform.poi.word.WordExportUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.AbstractView;

/**
 * <b>Application name:</b> PlatformTemplateWordView.java <br>
 * <b>Application describing: Word模板视图</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
@SuppressWarnings("unchecked")
@Controller(TemplateWordConstants.PLATFORM_TEMPLATE_WORD_VIEW)
public class PlatformTemplateWordView extends AbstractView {

    private static final String CONTENT_TYPE = "application/msword";

    public PlatformTemplateWordView() {
        setContentType(CONTENT_TYPE);
    }

    public boolean isIE(HttpServletRequest request) {
        return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0) ? true : false;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String codedFileName = "临时文件.docx";
        if (model.containsKey(TemplateWordConstants.FILE_NAME)) {
            codedFileName = (String) model.get(TemplateWordConstants.FILE_NAME) + ".docx";
        }
        if (isIE(request)) {
            codedFileName = java.net.URLEncoder.encode(codedFileName, "UTF8");
        } else {
            codedFileName = new String(codedFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
        XWPFDocument document = WordExportUtil.exportWord07((String) model.get(TemplateWordConstants.URL), (Map<String, Object>) model.get(TemplateWordConstants.MAP_DATA));
        ServletOutputStream out = response.getOutputStream();
        document.write(out);
        out.flush();
    }
}
