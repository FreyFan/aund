package com.kd.platform.codegenerate.generate.onetoone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.kd.platform.codegenerate.database.PlatformReadTable;
import com.kd.platform.codegenerate.generate.ICallBack;
import com.kd.platform.codegenerate.pojo.CreateFileProperty;
import com.kd.platform.codegenerate.pojo.onetomany.SubTableEntity;
import com.kd.platform.codegenerate.util.CodeDateUtils;
import com.kd.platform.codegenerate.util.CodeResourceUtil;
import com.kd.platform.codegenerate.util.NonceUtils;
import com.kd.platform.codegenerate.util.def.FtlDef;
import com.kd.platform.web.cgform.entity.config.CgFormFieldEntity;
import com.kd.platform.web.cgform.entity.generate.GenerateEntity;

import freemarker.template.TemplateException;

/**
 * <b>Application name:</b> CgformCodeGenerate.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CgformCodeGenerate implements ICallBack {
    private static final Log log = LogFactory.getLog(CgformCodeGenerate.class);

    private String entityPackage = "test";

    private String entityName = "Person";

    private String tableName = "person";

    private String ftlDescription = "公告";

    private String primaryKeyPolicy = "uuid";

    private String sequenceCode = "";

    private String[] foreignKeys;

    public static int FIELD_ROW_NUM = 1;

    private SubTableEntity sub;

    private GenerateEntity subG;

    private CreateFileProperty subFileProperty;

    private String policy;

    private String[] array;

    private GenerateEntity cgformConfig;

    private static CreateFileProperty createFileProperty = new CreateFileProperty();

    static {
        createFileProperty.setActionFlag(true);
        createFileProperty.setServiceIFlag(true);
        createFileProperty.setJspFlag(true);
        createFileProperty.setServiceImplFlag(true);
        createFileProperty.setJspMode("01");
        createFileProperty.setPageFlag(true);
        createFileProperty.setEntityFlag(true);
    }

    public CgformCodeGenerate() {
    }

    public CgformCodeGenerate(CreateFileProperty createFileProperty2, GenerateEntity generateEntity) {
        this.entityName = generateEntity.getEntityName();
        this.entityPackage = generateEntity.getEntityPackage();
        this.tableName = generateEntity.getTableName();
        this.ftlDescription = generateEntity.getFtlDescription();
        FIELD_ROW_NUM = 1;
        createFileProperty = createFileProperty2;
        createFileProperty.setJspMode("01");
        this.primaryKeyPolicy = generateEntity.getPrimaryKeyPolicy();
        this.sequenceCode = "";
        this.cgformConfig = generateEntity;
    }

    public CgformCodeGenerate(SubTableEntity sub, GenerateEntity subG, CreateFileProperty subFileProperty, String policy, String[] array) {
        this.entityName = subG.getEntityName();
        this.entityPackage = subG.getEntityPackage();
        this.tableName = subG.getTableName();
        this.ftlDescription = subG.getFtlDescription();
        createFileProperty = subFileProperty;
        FIELD_ROW_NUM = 1;
        this.primaryKeyPolicy = policy;
        this.sequenceCode = "";
        this.cgformConfig = subG;
        this.foreignKeys = array;
        this.sub = sub;
        this.subG = subG;
        this.subFileProperty = subFileProperty;
        this.policy = policy;
    }

    public Map<String, Object> execute() {
        Map data = new HashMap();
        Map fieldMeta = new HashMap();

        data.put("bussiPackage", CodeResourceUtil.bussiPackage);

        data.put("entityPackage", this.entityPackage);

        data.put("entityName", this.entityName);

        data.put("tableName", this.tableName);

        data.put("ftl_description", this.ftlDescription);

        data.put(FtlDef.PLATFORM_TABLE_ID, CodeResourceUtil.PLATFORM_GENERATE_TABLE_ID);

        data.put(FtlDef.PLATFORM_PRIMARY_KEY_POLICY, this.primaryKeyPolicy);
        data.put(FtlDef.PLATFORM_SEQUENCE_CODE, this.sequenceCode);

        data.put("ftl_create_time", CodeDateUtils.dateToString(new Date()));

        data.put("foreignKeys", this.foreignKeys);

        data.put(FtlDef.FIELD_REQUIRED_NAME, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) : -1));

        data.put(FtlDef.SEARCH_FIELD_NUM, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) : -1));

        data.put(FtlDef.FIELD_ROW_NAME, Integer.valueOf(FIELD_ROW_NUM));
        try {
            List columns = cgformConfig.deepCopy().getCgFormHead().getColumns();
            String fieldName;
            String fieldNameV;
            for (Iterator iterator = columns.iterator(); iterator.hasNext(); fieldMeta.put(fieldNameV, fieldName.toUpperCase())) {
                CgFormFieldEntity cf = (CgFormFieldEntity) iterator.next();
                String type = cf.getType();
                if ("string".equalsIgnoreCase(type))
                    cf.setType("java.lang.String");
                else if ("Date".equalsIgnoreCase(type))
                    cf.setType("java.util.Date");
                else if ("double".equalsIgnoreCase(type))
                    cf.setType("java.lang.Double");
                else if ("int".equalsIgnoreCase(type))
                    cf.setType("java.lang.Integer");
                else if ("BigDecimal".equalsIgnoreCase(type))
                    cf.setType("java.math.BigDecimal");
                else if ("Text".equalsIgnoreCase(type))
                    cf.setType("java.lang.String");
                else if ("Blob".equalsIgnoreCase(type)) cf.setType("java.sql.Blob");
                fieldName = cf.getFieldName();
                fieldNameV = PlatformReadTable.formatField(fieldName);
                cf.setFieldName(fieldNameV);
            }

            List pageColumns = new ArrayList();
            for (Iterator iterator1 = columns.iterator(); iterator1.hasNext();) {
                CgFormFieldEntity cf = (CgFormFieldEntity) iterator1.next();
                if (StringUtils.isNotEmpty(cf.getIsShow()) && "Y".equalsIgnoreCase(cf.getIsShow())) pageColumns.add(cf);
            }

            data.put("cgformConfig", cgformConfig);
            data.put("fieldMeta", fieldMeta);
            data.put("columns", columns);
            data.put("pageColumns", pageColumns);
            data.put("buttons", cgformConfig.getButtons() != null ? ((Object) (cgformConfig.getButtons())) : ((Object) (new ArrayList(0))));
            data.put("buttonSqlMap", cgformConfig.getButtonSqlMap() != null ? ((Object) (cgformConfig.getButtonSqlMap())) : ((Object) (new HashMap(0))));
            data.put("packageStyle", cgformConfig.getPackageStyle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        long serialVersionUID = NonceUtils.randomLong() + NonceUtils.currentMills();
        data.put("serialVersionUID", String.valueOf(serialVersionUID));
        return data;
    }

    public void generateToFile() throws TemplateException, IOException {
        log.info("----platform---Code----Generation----[单表模型:" + this.tableName + "]------- 生成中。。。");

        CgformCodeFactory codeFactory = new CgformCodeFactory();
        codeFactory.setProjectPath(this.cgformConfig.getProjectPath());
        codeFactory.setPackageStyle(this.cgformConfig.getPackageStyle());
        if (this.cgformConfig.getCgFormHead().getJformType().intValue() == 1)
            codeFactory.setCallBack(new CgformCodeGenerate(createFileProperty, this.cgformConfig));
        else {
            codeFactory.setCallBack(new CgformCodeGenerate(this.sub, this.subG, this.subFileProperty, "uuid", this.foreignKeys));
        }

        if (createFileProperty.isJspFlag()) {
            if ("03".equals(createFileProperty.getJspMode())) {
                codeFactory.invoke("one2many/cgform_jspSubTemplate.ftl", "jspList");
            } else {
                if ("01".equals(createFileProperty.getJspMode())) {
                    codeFactory.invoke("one2one/cgform_jspTableTemplate_add.ftl", "jsp_add");
                    codeFactory.invoke("one2one/cgform_jspTableTemplate_update.ftl", "jsp_update");
                }
                if ("02".equals(createFileProperty.getJspMode())) {
                    codeFactory.invoke("one2one/cgform_jspDivTemplate_add.ftl", "jsp_add");
                    codeFactory.invoke("one2one/cgform_jspDivTemplate_update.ftl", "jsp_update");
                }
                codeFactory.invoke("one2one/cgform_jspListTemplate.ftl", "jspList");
                codeFactory.invoke("one2one/cgform_jsListEnhanceTemplate.ftl", "jsList");
                codeFactory.invoke("one2one/cgform_jsEnhanceTemplate.ftl", "js");
            }
        }
        if (createFileProperty.isServiceImplFlag()) {
            codeFactory.invoke("one2one/cgform_serviceImplTemplate.ftl", "serviceImpl");
        }
        if (createFileProperty.isServiceIFlag()) {
            codeFactory.invoke("one2one/cgform_serviceITemplate.ftl", "service");
        }
        if (createFileProperty.isActionFlag()) {
            codeFactory.invoke("one2one/cgform_controllerTemplate.ftl", "controller");
        }
        if (createFileProperty.isEntityFlag()) {
            codeFactory.invoke("one2one/cgform_entityTemplate.ftl", "entity");
        }
        log.info("----platform----Code----Generation-----[单表模型：" + this.tableName + "]------ 生成完成。。。");
    }

    public GenerateEntity getCgformConfig() {
        return this.cgformConfig;
    }

    public void setCgformConfig(GenerateEntity cgformConfig) {
        this.cgformConfig = cgformConfig;
    }
}
