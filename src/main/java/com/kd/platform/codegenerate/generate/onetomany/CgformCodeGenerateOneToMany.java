package com.kd.platform.codegenerate.generate.onetomany;

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
import com.kd.platform.codegenerate.generate.onetoone.CgformCodeGenerate;
import com.kd.platform.codegenerate.pojo.CreateFileProperty;
import com.kd.platform.codegenerate.pojo.onetomany.CodeParamEntity;
import com.kd.platform.codegenerate.pojo.onetomany.SubTableEntity;
import com.kd.platform.codegenerate.util.CodeDateUtils;
import com.kd.platform.codegenerate.util.CodeResourceUtil;
import com.kd.platform.codegenerate.util.NonceUtils;
import com.kd.platform.codegenerate.util.def.FtlDef;
import com.kd.platform.web.cgform.entity.config.CgFormFieldEntity;
import com.kd.platform.web.cgform.entity.generate.GenerateEntity;

import freemarker.template.TemplateException;

/**
 * <b>Application name:</b> CgformCodeGenerateOneToMany.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CgformCodeGenerateOneToMany implements ICallBack {
    private static final Log log = LogFactory.getLog(CgformCodeGenerateOneToMany.class);

    private String entityPackage = "test";

    private String entityName = "Person";

    private String tableName = "person";

    private String ftlDescription = "用户";

    private String primaryKeyPolicy = "uuid";

    private String sequenceCode = "";

    private static String ftl_mode;

    public static String FTL_MODE_A = "A";

    public static String FTL_MODE_B = "B";

    private static List<SubTableEntity> subTabParam = new ArrayList();

    private static CreateFileProperty createFileProperty = new CreateFileProperty();

    public static int FIELD_ROW_NUM = 4;

    private List<SubTableEntity> subTabFtl = new ArrayList();

    private CodeParamEntity codeParamEntityIn;

    private GenerateEntity mainG;

    private Map<String, GenerateEntity> subsG;

    private List<SubTableEntity> subTabParamIn;

    static {
        createFileProperty.setActionFlag(true);
        createFileProperty.setServiceIFlag(true);
        createFileProperty.setJspFlag(true);
        createFileProperty.setServiceImplFlag(true);
        createFileProperty.setPageFlag(true);
        createFileProperty.setEntityFlag(true);
    }

    public CgformCodeGenerateOneToMany() {
    }

    public CgformCodeGenerateOneToMany(List<SubTableEntity> subTabParamIn, CodeParamEntity codeParamEntityIn, GenerateEntity mainG, Map<String, GenerateEntity> subsG) {
        this.entityName = codeParamEntityIn.getEntityName();
        this.entityPackage = codeParamEntityIn.getEntityPackage();
        this.tableName = codeParamEntityIn.getTableName();
        this.ftlDescription = codeParamEntityIn.getFtlDescription();
        subTabParam = codeParamEntityIn.getSubTabParam();
        ftl_mode = codeParamEntityIn.getFtl_mode();
        this.primaryKeyPolicy = "uuid";
        this.sequenceCode = codeParamEntityIn.getSequenceCode();
        this.subTabParamIn = subTabParamIn;
        this.mainG = mainG;
        this.subsG = subsG;
        this.codeParamEntityIn = codeParamEntityIn;
    }

    public Map<String, Object> execute() {
        Map data = new HashMap();

        data.put("bussiPackage", CodeResourceUtil.bussiPackage);

        data.put("entityPackage", this.entityPackage);

        data.put("entityName", this.entityName);

        data.put("tableName", this.tableName);

        data.put("ftl_description", this.ftlDescription);

        data.put("platform_table_id", CodeResourceUtil.PLATFORM_GENERATE_TABLE_ID);

        data.put(FtlDef.PLATFORM_PRIMARY_KEY_POLICY, this.primaryKeyPolicy);
        data.put(FtlDef.PLATFORM_SEQUENCE_CODE, this.sequenceCode);
        data.put("ftl_create_time", CodeDateUtils.dateToString(new Date()));

        data.put(FtlDef.FIELD_REQUIRED_NAME, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_REQUIRED_NUM) : -1));

        data.put(FtlDef.SEARCH_FIELD_NUM, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) ? Integer.parseInt(CodeResourceUtil.PLATFORM_UI_FIELD_SEARCH_NUM) : -1));

        data.put(FtlDef.FIELD_ROW_NAME, Integer.valueOf(FIELD_ROW_NUM));
        try {
            Map fieldMeta = new HashMap();
            List columns = mainG.deepCopy().getCgFormHead().getColumns();
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
                    cf.setType("javax.xml.soap.Text");
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

            String subtables[] = mainG.getCgFormHead().getSubTableStr().split(",");
            data.put("cgformConfig", mainG);
            data.put("fieldMeta", fieldMeta);
            data.put("columns", columns);
            data.put("pageColumns", pageColumns);
            data.put("buttons", mainG.getButtons() != null ? ((Object) (mainG.getButtons())) : ((Object) (new ArrayList(0))));
            data.put("buttonSqlMap", mainG.getButtonSqlMap() != null ? ((Object) (mainG.getButtonSqlMap())) : ((Object) (new HashMap(0))));
            data.put("subtables", subtables);
            data.put("subTab", subTabParamIn);
            Map subColumnsMap = new HashMap(0);
            Map subPageColumnsMap = new HashMap(0);
            Map subFieldMeta = new HashMap(0);
            Map subFieldMeta1 = new HashMap(0);
            for (Iterator iterator2 = subsG.keySet().iterator(); iterator2.hasNext(); data.put("packageStyle", mainG.getPackageStyle())) {
                String key = (String) iterator2.next();
                GenerateEntity subG = (GenerateEntity) subsG.get(key);
                List subColumns = subG.deepCopy().getCgFormHead().getColumns();
                List subPageColumns = new ArrayList();
                for (Iterator iterator3 = subColumns.iterator(); iterator3.hasNext(); subPageColumnsMap.put(key, subPageColumns)) {
                    CgFormFieldEntity cf = (CgFormFieldEntity) iterator3.next();
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
                        cf.setType("javax.xml.soap.Text");
                    else if ("Blob".equalsIgnoreCase(type)) cf.setType("java.sql.Blob");
                    String fieldName1 = cf.getFieldName();
                    String fieldNameV1 = PlatformReadTable.formatField(fieldName1);
                    cf.setFieldName(fieldNameV1);
                    subFieldMeta.put(fieldNameV1, fieldName1.toUpperCase());
                    subFieldMeta1.put(fieldName1.toUpperCase(), fieldNameV1);
                    if (StringUtils.isNotEmpty(cf.getIsShow()) && "Y".equalsIgnoreCase(cf.getIsShow())) subPageColumns.add(cf);
                    String mtable = cf.getMainTable();
                    String mfiled = cf.getMainField();
                    if (mtable != null && mtable.equalsIgnoreCase(mainG.getTableName())) data.put((new StringBuilder(String.valueOf(key))).append("_fk").toString(), mfiled);
                    subColumnsMap.put(key, subColumns);
                }

                data.put("subColumnsMap", subColumnsMap);
                data.put("subPageColumnsMap", subPageColumnsMap);
                data.put("subFieldMeta", subFieldMeta);
                data.put("subFieldMeta1", subFieldMeta1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long serialVersionUID = NonceUtils.randomLong() + NonceUtils.currentMills();
        data.put("serialVersionUID", String.valueOf(serialVersionUID));
        return data;
    }

    public void generateToFile() throws TemplateException, IOException {
        CgformCodeFactoryOneToMany codeFactoryOneToMany = new CgformCodeFactoryOneToMany();
        codeFactoryOneToMany.setProjectPath(this.mainG.getProjectPath());
        codeFactoryOneToMany.setPackageStyle(this.mainG.getPackageStyle());
        codeFactoryOneToMany.setCallBack(new CgformCodeGenerateOneToMany(this.subTabParamIn, this.codeParamEntityIn, this.mainG, this.subsG));

        if (createFileProperty.isJspFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_jspListTemplate.ftl", "jspList");
            codeFactoryOneToMany.invoke("one2many/cgform_jspTemplate_add.ftl", "jsp_add");
            codeFactoryOneToMany.invoke("one2many/cgform_jspTemplate_update.ftl", "jsp_update");
            codeFactoryOneToMany.invoke("one2many/cgform_jsEnhanceTemplate.ftl", "js");
            codeFactoryOneToMany.invoke("one2many/cgform_jsListEnhanceTemplate.ftl", "jsList");
        }
        if (createFileProperty.isServiceImplFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_serviceImplTemplate.ftl", "serviceImpl");
        }
        if (createFileProperty.isServiceIFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_serviceITemplate.ftl", "service");
        }
        if (createFileProperty.isActionFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_controllerTemplate.ftl", "controller");
        }
        if (createFileProperty.isEntityFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_entityTemplate.ftl", "entity");
        }
        if (createFileProperty.isPageFlag()) {
            codeFactoryOneToMany.invoke("one2many/cgform_pageTemplate.ftl", "page");
        }
    }

    public static void oneToManyCreate(List<SubTableEntity> subTabParamIn, CodeParamEntity codeParamEntityIn, GenerateEntity mainG, Map<String, GenerateEntity> subsG) throws TemplateException, IOException {
        log.info("----platform----Code-----Generation-----[一对多数据模型：" + codeParamEntityIn.getTableName() + "]------- 生成中。。。");

        CreateFileProperty subFileProperty = new CreateFileProperty();
        subFileProperty.setActionFlag(false);
        subFileProperty.setServiceIFlag(false);
        subFileProperty.setJspFlag(true);
        subFileProperty.setServiceImplFlag(false);
        subFileProperty.setPageFlag(false);
        subFileProperty.setEntityFlag(true);
        subFileProperty.setJspMode("03");

        for (SubTableEntity sub : subTabParamIn) {
            String[] foreignKeys = sub.getForeignKeys();
            GenerateEntity subG = (GenerateEntity) subsG.get(sub.getTableName());
            new CgformCodeGenerate(sub, subG, subFileProperty, "uuid", foreignKeys).generateToFile();
        }

        new CgformCodeGenerateOneToMany(subTabParamIn, codeParamEntityIn, mainG, subsG).generateToFile();
        log.info("----platform----Code----Generation------[一对多数据模型：" + codeParamEntityIn.getTableName() + "]------ 生成完成。。。");
    }
}
