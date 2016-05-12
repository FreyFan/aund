package com.kd.platform.minidao.util;

import java.io.StringWriter;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @Title:FreemarkerHelper
 * @description:Freemarker引擎协助类
 * @author Frey.Fan
 * @date Jul 5, 2013 2:58:29 PM
 * @version V1.0
 */
public class FreemarkerParseFactory {
    private static final Logger logger = LoggerFactory.getLogger(FreemarkerParseFactory.class);

    private static final String ENCODE = "UTF-8";

    private static final Configuration _tplConfig = new Configuration();

    private static final Configuration _sqlConfig = new Configuration();

    private static StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();

    private static final Pattern p = Pattern.compile("(?ms)/\\*.*?\\*/|^\\s*//.*?$");

    static {
        _tplConfig.setClassForTemplateLoading(new FreemarkerParseFactory().getClass(), "/");
        _tplConfig.setNumberFormat("0.#####################");
        _sqlConfig.setTemplateLoader(stringTemplateLoader);
        _sqlConfig.setNumberFormat("0.#####################");
    }

    public static boolean isExistTemplate(String tplName) {
        try {
            Template mytpl = _tplConfig.getTemplate(tplName, ENCODE);
            if (mytpl == null) return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String parseTemplate(String tplName, Map<String, Object> paras) {
        try {
            StringWriter swriter = new StringWriter();
            Template mytpl = _tplConfig.getTemplate(tplName, ENCODE);
            mytpl.process(paras, swriter);
            return getSqlText(swriter.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            logger.error("发送一次的模板key:{}", tplName);
        }
        throw new RuntimeException("解析SQL模板异常");
    }

    public static String parseTemplateContent(String tplContent, Map<String, Object> paras) {
        try {
            StringWriter swriter = new StringWriter();
            if (stringTemplateLoader.findTemplateSource("sql_" + tplContent.hashCode()) == null) {
                stringTemplateLoader.putTemplate("sql_" + tplContent.hashCode(), tplContent);
            }
            Template mytpl = _sqlConfig.getTemplate("sql_" + tplContent.hashCode(), ENCODE);
            mytpl.process(paras, swriter);
            return getSqlText(swriter.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e.fillInStackTrace());
            logger.error("发送一次的模板key:{}", tplContent);
        }
        throw new RuntimeException("解析SQL模板异常");
    }

    private static String getSqlText(String sql) {
        sql = p.matcher(sql).replaceAll("");
        sql = sql.replaceAll("\\n", " ").replaceAll("\\t", " ").replaceAll("\\s{1,}", " ").trim();
        if (StringUtils.endsWithIgnoreCase(sql, "where")) {
            sql = sql.substring(0, sql.length() - 5);
        }
        int index = 0;
        while ((index = StringUtils.indexOfIgnoreCase(sql, "where and", index)) != -1) {
            sql = sql.substring(0, index + 5) + sql.substring(index + 9, sql.length());
        }
        return sql;
    }
}
