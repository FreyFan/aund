/*******************************************************************************
 * @(#)BaseCodeFactory.java 2015-6-9
 *
 * Copyright 2015 Frey.Fan. All rights reserved.
 *******************************************************************************/
package com.kd.platform.codegenerate.generate;

import freemarker.template.Configuration;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import com.kd.platform.codegenerate.util.CodeResourceUtil;
import com.kd.platform.codegenerate.util.CodeStringUtils;

/**
 * <b>Application name:</b> BaseCodeFactory.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class BaseCodeFactory {
    protected String packageStyle;

    public Configuration getConfiguration() throws IOException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(getClass(), CodeResourceUtil.FREEMARKER_CLASSPATH);
        cfg.setLocale(Locale.CHINA);
        cfg.setDefaultEncoding("UTF-8");
        return cfg;
    }

    public String getCodePathServiceStyle(String path, String type, String entityPackage, String entityName) {
        StringBuilder str = new StringBuilder();
        if (StringUtils.isNotBlank(type)) {
            String codeType = ((CodeType) Enum.valueOf(CodeType.class, type)).getValue();
            str.append(path);
            if (("jsp".equals(type)) || ("jspList".equals(type)) || ("js".equals(type)) || ("jsList".equals(type)) || ("jsp_add".equals(type)) || ("jsp_update".equals(type)))
                str.append(CodeResourceUtil.JSPPATH);
            else {
                str.append(CodeResourceUtil.CODEPATH);
            }
            str.append(StringUtils.lowerCase(entityPackage));
            str.append("/");
            if ("Action".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("action"));
            else if ("ServiceImpl".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("service/impl"));
            else if ("ServiceI".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("service"));
            else if (!"List".equalsIgnoreCase(codeType)) {
                str.append(StringUtils.lowerCase(codeType));
            }
            str.append("/");

            if (("jsp".equals(type)) || ("jspList".equals(type))) {
                String jspName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jspName));
                str.append(codeType);
                str.append(".jsp");
            } else if (("jsp_add".equals(type)) || ("jspList_add".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append("-add.jsp");
            } else if (("jsp_update".equals(type)) || ("jspList_update".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append("-update.jsp");
            } else if (("js".equals(type)) || ("jsList".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append(".js");
            } else {
                str.append(StringUtils.capitalize(entityName));
                str.append(codeType);
                str.append(".java");
            }
        } else {
            throw new IllegalArgumentException("type is null");
        }
        return str.toString();
    }

    public String getCodePathProjectStyle(String path, String type, String entityPackage, String entityName) {
        StringBuilder str = new StringBuilder();
        if (StringUtils.isNotBlank(type)) {
            String codeType = ((CodeType) Enum.valueOf(CodeType.class, type)).getValue();
            str.append(path);
            if (("jsp".equals(type)) || ("jspList".equals(type)) || ("js".equals(type)) || ("jsList".equals(type)) || ("jsp_add".equals(type)) || ("jsp_update".equals(type)))
                str.append(CodeResourceUtil.JSPPATH);
            else {
                str.append(CodeResourceUtil.CODEPATH);
            }
            if ("Action".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("action"));
            else if ("ServiceImpl".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("service/impl"));
            else if ("ServiceI".equalsIgnoreCase(codeType))
                str.append(StringUtils.lowerCase("service"));
            else if (!"List".equalsIgnoreCase(codeType)) {
                str.append(StringUtils.lowerCase(codeType));
            }
            str.append("/");
            str.append(StringUtils.lowerCase(entityPackage));
            str.append("/");

            if (("jsp".equals(type)) || ("jspList".equals(type))) {
                String jspName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jspName));
                str.append(codeType);
                str.append(".jsp");
            } else if (("jsp_add".equals(type)) || ("jspList_add".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append("-add.jsp");
            } else if (("jsp_update".equals(type)) || ("jspList_update".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append("-update.jsp");
            } else if (("js".equals(type)) || ("jsList".equals(type))) {
                String jsName = StringUtils.capitalize(entityName);

                str.append(CodeStringUtils.getInitialSmall(jsName));
                str.append(codeType);
                str.append(".js");
            } else {
                str.append(StringUtils.capitalize(entityName));
                str.append(codeType);
                str.append(".java");
            }
        } else {
            throw new IllegalArgumentException("type is null");
        }
        return str.toString();
    }

    public String getPackageStyle() {
        return this.packageStyle;
    }

    public void setPackageStyle(String packageStyle) {
        this.packageStyle = packageStyle;
    }

    public static enum CodeType {
        serviceImpl("ServiceImpl"), dao("Dao"), service("ServiceI"), controller("Controller"), page("Page"), entity("Entity"), jsp(""), jsp_add(""), jsp_update(""), js(""), jsList("List"), jspList("List"), jspSubList("SubList");

        private String type;

        private CodeType(String type) {
            this.type = type;
        }

        public String getValue() {
            return this.type;
        }
    }
}
