package com.kd.platform.poi.excel.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.AbstractView;

/**
 * <b>Application name:</b> MiniAbstractExcelView.java <br>
 * <b>Application describing: 基础抽象Excel View</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public abstract class MiniAbstractExcelView extends AbstractView {

    private static final String CONTENT_TYPE = "application/vnd.ms-excel";

    protected static final String HSSF = ".xls";

    protected static final String XSSF = ".xlsx";

    public MiniAbstractExcelView() {
        setContentType(CONTENT_TYPE);
    }

    protected boolean isIE(HttpServletRequest request) {
        return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0) ? true : false;
    }

}
