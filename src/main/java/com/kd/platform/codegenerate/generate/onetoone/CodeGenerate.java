package com.kd.platform.codegenerate.generate.onetoone;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kd.platform.codegenerate.database.PlatformReadTable;
import com.kd.platform.codegenerate.generate.ICallBack;
import com.kd.platform.codegenerate.pojo.Columnt;
import com.kd.platform.codegenerate.pojo.CreateFileProperty;
import com.kd.platform.codegenerate.util.CodeDateUtils;
import com.kd.platform.codegenerate.util.CodeResourceUtil;
import com.kd.platform.codegenerate.util.NonceUtils;
import com.kd.platform.codegenerate.util.def.FtlDef;

/**
 * <b>Application name:</b> CodeGenerate.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CodeGenerate implements ICallBack {
    private static final Log log = LogFactory.getLog(CodeGenerate.class);

    private static String entityPackage = "test";

    private static String entityName = "Person";

    private static String tableName = "person";

    private static String ftlDescription = "公告";

    private static String primaryKeyPolicy = "uuid";

    private static String sequenceCode = "";

    private static String[] foreignKeys;

    private List<Columnt> originalColumns = new ArrayList();

    public static int FIELD_ROW_NUM = 1;

    private static CreateFileProperty createFileProperty = new CreateFileProperty();

    private List<Columnt> columns = new ArrayList();

    private PlatformReadTable dbFiledUtil = new PlatformReadTable();

    static {
        createFileProperty.setActionFlag(true);
        createFileProperty.setServiceIFlag(true);
        createFileProperty.setJspFlag(true);
        createFileProperty.setServiceImplFlag(true);
        createFileProperty.setJspMode("01");
        createFileProperty.setPageFlag(true);
        createFileProperty.setEntityFlag(true);
    }

    public CodeGenerate() {
    }

    public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, int fieldRowNum, String primaryKeyPolicy, String sequenceCode) {
        entityName = entityName;
        entityPackage = entityPackage;
        tableName = tableName;
        ftlDescription = ftlDescription;
        createFileProperty = createFileProperty;
        FIELD_ROW_NUM = fieldRowNum;
        primaryKeyPolicy = primaryKeyPolicy;
        sequenceCode = sequenceCode;
    }

    public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, String primaryKeyPolicy, String sequenceCode) {
        entityName = entityName;
        entityPackage = entityPackage;
        tableName = tableName;
        ftlDescription = ftlDescription;
        createFileProperty = createFileProperty;
        primaryKeyPolicy = primaryKeyPolicy;
        sequenceCode = sequenceCode;
    }

    public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, String primaryKeyPolicy, String sequenceCode, String[] foreignKeys) {
        entityName = entityName;
        entityPackage = entityPackage;
        tableName = tableName;
        ftlDescription = ftlDescription;
        createFileProperty = createFileProperty;
        primaryKeyPolicy = primaryKeyPolicy;
        sequenceCode = sequenceCode;
        foreignKeys = foreignKeys;
    }

    public Map<String, Object> execute() {
        Map data = new HashMap();

        data.put("bussiPackage", CodeResourceUtil.bussiPackage);

        data.put("entityPackage", entityPackage);

        data.put("entityName", entityName);

        data.put("tableName", tableName);

        data.put("ftl_description", ftlDescription);

        data.put(FtlDef.PLATFORM_TABLE_ID, CodeResourceUtil.PLATFORM_GENERATE_TABLE_ID);

        data.put(FtlDef.PLATFORM_PRIMARY_KEY_POLICY, primaryKeyPolicy);
        data.put(FtlDef.PLATFORM_SEQUENCE_CODE, sequenceCode);

        data.put("ftl_create_time", CodeDateUtils.dateToString(new Date()));

        data.put("foreignKeys", foreignKeys);

        data.put(FtlDef.FIELD_REQUIRED_NAME, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) : -1));

        data.put(FtlDef.SEARCH_FIELD_NUM, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) : -1));

        data.put(FtlDef.FIELD_ROW_NAME, Integer.valueOf(FIELD_ROW_NUM));
        try {
            this.columns = this.dbFiledUtil.readTableColumn(tableName);
            data.put("columns", this.columns);

            this.originalColumns = this.dbFiledUtil.readOriginalTableColumn(tableName);
            data.put("originalColumns", this.originalColumns);

            for (Columnt c : this.originalColumns) {
                if (c.getFieldName().toLowerCase().equals(CodeResourceUtil.PLATFORM_GENERATE_TABLE_ID.toLowerCase())) data.put("primary_key_type", c.getFieldType());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        long serialVersionUID = NonceUtils.randomLong() + NonceUtils.currentMills();
        data.put("serialVersionUID", String.valueOf(serialVersionUID));
        return data;
    }

    public void generateToFile() {
        log.info("----platform---Code----Generation----[单表模型:" + tableName + "]------- 生成中。。。");

        CodeFactory codeFactory = new CodeFactory();
        codeFactory.setCallBack(new CodeGenerate());

        if (createFileProperty.isJspFlag()) {
            if ("03".equals(createFileProperty.getJspMode())) {
                codeFactory.invoke("one2many/jspSubTemplate.ftl", "jspList");
            } else {
                if ("01".equals(createFileProperty.getJspMode())) {
                    codeFactory.invoke("one2one/jspTableTemplate.ftl", "jsp");
                }
                if ("02".equals(createFileProperty.getJspMode())) {
                    codeFactory.invoke("one2one/jspDivTemplate.ftl", "jsp");
                }
                codeFactory.invoke("one2one/jspListTemplate.ftl", "jspList");
            }
        }
        if (createFileProperty.isServiceImplFlag()) {
            codeFactory.invoke("one2one/serviceImplTemplate.ftl", "serviceImpl");
        }
        if (createFileProperty.isServiceIFlag()) {
            codeFactory.invoke("one2one/serviceITemplate.ftl", "service");
        }
        if (createFileProperty.isActionFlag()) {
            codeFactory.invoke("one2one/controllerTemplate.ftl", "controller");
        }
        if (createFileProperty.isEntityFlag()) {
            codeFactory.invoke("one2one/entityTemplate.ftl", "entity");
        }
        log.info("----platform----Code----Generation-----[单表模型：" + tableName + "]------ 生成完成。。。");
    }

    public static void main(String[] args) {
        System.out.println("----platform--------- Code------------- Generation -----[单表模型]------- 生成中。。。");
        new CodeGenerate().generateToFile();
        System.out.println("----platform--------- Code------------- Generation -----[单表模型]------- 生成完成。。。");
    }
}
