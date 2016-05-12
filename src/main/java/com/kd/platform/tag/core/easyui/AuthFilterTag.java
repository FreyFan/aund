package com.kd.platform.tag.core.easyui;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.kd.platform.core.constant.Globals;
import com.kd.platform.core.util.ApplicationContextUtil;
import com.kd.platform.core.util.ResourceUtil;
import com.kd.platform.core.util.oConvertUtils;
import com.kd.platform.web.system.pojo.base.TSOperation;
import com.kd.platform.web.system.service.SystemService;

/**
 * @Title:AuthFilterTag
 * @description:列表按钮权限过滤
 * @author Frey.Fan
 * @date Aug 24, 2013 7:46:57 PM
 * @version V1.0
 */
public class AuthFilterTag extends TagSupport {
    /** 列表容器的ID */
    protected String name;

    @Autowired
    private static SystemService systemService;

    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    public int doEndTag() throws JspException {
        try {
            JspWriter out = this.pageContext.getOut();
            out.print(end().toString());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;

    }

    protected Object end() {
        StringBuilder out = new StringBuilder();
        getAuthFilter(out);
        return out;
    }

    /**
     * 获取隐藏按钮的JS代码
     * @param out
     */
    @SuppressWarnings("unchecked")
    protected void getAuthFilter(StringBuilder out) {
        out.append("<script type=\"text/javascript\">");
        out.append("$(document).ready(function(){");
        if (ResourceUtil.getSessionUserName().getUserName().equals("admin") || !Globals.BUTTON_AUTHORITY_CHECK) {
        } else {
            Set<String> operationCodes = (Set<String>) super.pageContext.getRequest().getAttribute(Globals.OPERATIONCODES);
            if (null != operationCodes) {
                for (String MyoperationCode : operationCodes) {
                    if (oConvertUtils.isEmpty(MyoperationCode)) break;
                    systemService = ApplicationContextUtil.getContext().getBean(SystemService.class);
                    TSOperation operation = systemService.getEntity(TSOperation.class, MyoperationCode);
                    if (operation.getOperationcode().startsWith(".") || operation.getOperationcode().startsWith("#")) {
                        if (operation.getOperationType().intValue() == Globals.OPERATION_TYPE_HIDE) {
                            out.append("$(\"" + operation.getOperationcode().replaceAll(" ", "") + "\").hide();");
                        } else {
                            out.append("$(\"" + operation.getOperationcode().replaceAll(" ", "") + "\").attr(\"disabled\",\"disabled\");");
                            out.append("$(\"" + operation.getOperationcode().replaceAll(" ", "") + "\").find(\":input\").attr(\"disabled\",\"disabled\");");
                        }
                    }
                }
            }

        }
        out.append("});");
        out.append("</script>");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
