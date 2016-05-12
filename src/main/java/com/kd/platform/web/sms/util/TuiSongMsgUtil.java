package com.kd.platform.web.sms.util;

import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.kd.platform.core.util.ApplicationContextUtil;
import com.kd.platform.web.sms.entity.TSSmsEntity;
import com.kd.platform.web.sms.entity.TSSmsSqlEntity;
import com.kd.platform.web.sms.entity.TSSmsTemplateEntity;
import com.kd.platform.web.sms.entity.TSSmsTemplateSqlEntity;
import com.kd.platform.web.system.service.SystemService;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * <b>Application name:</b> TuiSongMsgUtil.java <br>
 * <b>Application describing: TuiSongMsgUtil 统一发送消息的公用方法</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class TuiSongMsgUtil {

    @Autowired
    private static SystemService systemService;

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * sendMessage 统一消息发送接口
     * @Title: sendMessage
     * @param @param msgType 消息类型
     * @param @param code
     * @param @param map
     * @param @param sentTo
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String sendMessage(String title, String msgType, String code, Map<String, Object> map, String sentTo) {
        try {
            TSSmsEntity tss = new TSSmsEntity();
            tss.setEsType(msgType);
            tss.setEsTitle(title);
            tss.setEsReceiver(sentTo);
            tss.setEsStatus(Constants.SMS_SEND_STATUS_1);
            String hql = "from TSSmsTemplateSqlEntity as tempSql where tempSql.code=? ";
            String smsContent = "";
            List<TSSmsTemplateSqlEntity> tssmsTemplateSqlList = systemService.findHql(hql, code);
            for (TSSmsTemplateSqlEntity tsSmsTemplateSqlEntity : tssmsTemplateSqlList) {
                TSSmsSqlEntity tsSmsSqlEntity = systemService.getEntity(TSSmsSqlEntity.class, tsSmsTemplateSqlEntity.getSqlId());
                String templateSql = tsSmsSqlEntity.getSqlContent();// 获取对应业务sql表中的sql语句
                TSSmsTemplateEntity tsSmsTemplateEntity = systemService.getEntity(TSSmsTemplateEntity.class, tsSmsTemplateSqlEntity.getTemplateId());
                String templateContent = tsSmsTemplateEntity.getTemplateContent();// 获取模板表的对应的模板内容
                // 执行查询出来的模板sql
                Map<String, Object> rootMap = getRootMapBySql(templateSql, map);
                StringReader strR = new StringReader(templateContent);
                Template template = new Template("strTemplate", strR, new Configuration());
                StringWriter stringWriter = new StringWriter();
                BufferedWriter writer = new BufferedWriter(stringWriter);
                template.process(rootMap, writer);
                smsContent = stringWriter.toString();
            }
            tss.setEsContent(smsContent);
            systemService.save(tss); // 对库进行查询操作
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        if (namedParameterJdbcTemplate == null) {
            namedParameterJdbcTemplate = ApplicationContextUtil.getContext().getBean(NamedParameterJdbcTemplate.class);
        }
        return namedParameterJdbcTemplate;
    }

    /**
     * getRootMapBySql 获取业务SQL的配置数据
     * @Title: getSearchSql
     * @param @param templateSql
     * @param @param map
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static Map<String, Object> getRootMapBySql(String templateSql, Map<String, Object> map) {
        // 调用查询sql的方法执行此sql
        SqlParameterSource sqlp = new MapSqlParameterSource(map);
        return getNamedParameterJdbcTemplate().queryForMap(templateSql, sqlp);
    }

    /**
     * getTemplateServiceSql 获取短信sql具体的sql内容
     * @Title: getTemplateServiceSql
     * @param @param sqlId
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String getTemplateSql(String sqlId) {
        String hql = "from TSSmsSqlEntity as tssSql where tssSql.id=?";
        List<TSSmsSqlEntity> tssmsSqlList = systemService.findHql(hql, sqlId);
        String sqlContent = "";
        for (TSSmsSqlEntity tsSmsSqlEntity : tssmsSqlList) {
            sqlContent = tsSmsSqlEntity.getSqlContent();
        }
        return sqlContent;
    }

    /**
     * getTemplateContent 获取模板内容
     * @Title: getTemplateContent
     * @param @param templateId
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String getTemplateContent(String templateId) {
        String hql = "from TSSmsTemplateEntity as template where template.id=? ";
        List<TSSmsTemplateEntity> tSSmsTemplateList = systemService.findHql(hql, templateId);
        String templateConetent = "";
        for (TSSmsTemplateEntity tsSmsTemplateEntity : tSSmsTemplateList) {
            templateConetent = tsSmsTemplateEntity.getTemplateContent();
        }
        return templateConetent;
    }
}
