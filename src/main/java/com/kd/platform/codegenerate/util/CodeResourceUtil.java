package com.kd.platform.codegenerate.util;

import java.util.ResourceBundle;

/**
 * <b>Application name:</b> CodeResourceUtil.java <br>
 * <b>Application describing: </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class CodeResourceUtil {
	// 自动生成代码conf/platform/platform_database  by yangm
    private static final ResourceBundle bundle = ResourceBundle.getBundle("conf/platform/platform_database");

    private static final ResourceBundle bundlePath = ResourceBundle.getBundle("conf/platform/platform_config");

    public static String DIVER_NAME = "com.mysql.jdbc.Driver";

    // modify by yangm 2015-9-20
//    public static String URL = "jdbc:mysql://localhost:3306/sys?useUnicode=true&characterEncoding=UTF-8";
    public static String URL = "jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=UTF-8";

    public static String USERNAME = "root";

    public static String PASSWORD = "axposf1";

//    public static String DATABASE_NAME = "sys";
    public static String DATABASE_NAME = "platform";

    public static String DATABASE_TYPE = "mysql";

    public static String PLATFORM_UI_FIELD_REQUIRED_NUM = "4";

    public static String PLATFORM_UI_FIELD_SEARCH_NUM = "3";

    public static String project_path = "c:/workspace/platform";

    public static String web_root_package = "WebRoot";

    public static String source_root_package = "src";

    public static String bussiPackage = "sun";

    public static String entity_package = "entity";

    public static String page_package = "page";

    public static boolean PLATFORM_FILED_CONVERT = true;

    public static String FREEMARKER_CLASSPATH = "/conf/platform";

    public static String PACKAGE_SERVICE_STYLE = "service";

    public static String PACKAGE_PROJECT_STYLE = "project";

    public static String ENTITY_URL;

    public static String PAGE_URL;

    public static String ENTITY_URL_INX;

    public static String PAGE_URL_INX;

    public static String TEMPLATEPATH;

    public static String CODEPATH;

    public static String JSPPATH;

    public static String PLATFORM_GENERATE_TABLE_ID;

    public static String PLATFORM_GENERATE_UI_FILTER_FIELDS;

    public static String SYSTEM_ENCODING;

    static {
        DIVER_NAME = getDIVER_NAME();
        URL = getURL();
        USERNAME = getUSERNAME();
        PASSWORD = getPASSWORD();
        DATABASE_NAME = getDATABASE_NAME();
        PLATFORM_FILED_CONVERT = getPLATFORM_FILED_CONVERT();

        SYSTEM_ENCODING = getSYSTEM_ENCODING();
        TEMPLATEPATH = getTEMPLATEPATH();
        source_root_package = getSourceRootPackage();
        web_root_package = getWebRootPackage();
        bussiPackage = getBussiPackage();

        PLATFORM_GENERATE_TABLE_ID = getPlatform_generate_table_id();

        PLATFORM_GENERATE_UI_FILTER_FIELDS = getPlatform_generate_ui_filter_fields();

        PLATFORM_UI_FIELD_SEARCH_NUM = getPlatform_ui_search_filed_num();

        if ((URL.indexOf("mysql") >= 0) || (URL.indexOf("MYSQL") >= 0))
            DATABASE_TYPE = "mysql";
        else if ((URL.indexOf("oracle") >= 0) || (URL.indexOf("ORACLE") >= 0))
            DATABASE_TYPE = "oracle";
        else if ((URL.indexOf("postgresql") >= 0) || (URL.indexOf("POSTGRESQL") >= 0)) {
            DATABASE_TYPE = "postgresql";
        } else if ((URL.indexOf("sqlserver") >= 0) || (URL.indexOf("sqlserver") >= 0)) {
            DATABASE_TYPE = "sqlserver";
        }

        source_root_package = source_root_package.replace(".", "/");
        web_root_package = web_root_package.replace(".", "/");
        String bussiPackageUrl = bussiPackage.replace(".", "/");

        ENTITY_URL = source_root_package + "/" + bussiPackageUrl + "/" + entity_package + "/";

        PAGE_URL = source_root_package + "/" + bussiPackageUrl + "/" + page_package + "/";

        ENTITY_URL_INX = bussiPackage + "." + entity_package + ".";

        PAGE_URL_INX = bussiPackage + "." + page_package + ".";

        CODEPATH = source_root_package + "/" + bussiPackageUrl + "/";

        JSPPATH = web_root_package + "/" + "webpage" + "/" + bussiPackageUrl + "/";
        
//        FREEMARKER_CLASSPATH = getTEMPLATEPATH();
    }

    public static final String getDIVER_NAME() {
        return bundle.getString("diver_name");
    }

    public static final String getURL() {
        return bundle.getString("url");
    }

    public static final String getUSERNAME() {
        return bundle.getString("username");
    }

    public static final String getPASSWORD() {
        return bundle.getString("password");
    }

    public static final String getDATABASE_NAME() {
        return bundle.getString("database_name");
    }

    public static final boolean getPLATFORM_FILED_CONVERT() {
        String s = bundlePath.getString("platform_filed_convert");
        return !s.toString().equals("false");
    }

    private static String getBussiPackage() {
        return bundlePath.getString("bussi_package");
    }

    public static final String getEntityPackage() {
        return bundlePath.getString("entity_package");
    }

    public static final String getPagePackage() {
        return bundlePath.getString("page_package");
    }

    public static final String getTEMPLATEPATH() {
        return bundlePath.getString("templatepath");
    }

    public static final String getSourceRootPackage() {
        return bundlePath.getString("source_root_package");
    }

    public static final String getWebRootPackage() {
        return bundlePath.getString("webroot_package");
    }

    public static final String getSYSTEM_ENCODING() {
        return bundlePath.getString("system_encoding");
    }

    public static final String getPlatform_generate_table_id() {
        return bundlePath.getString("platform_generate_table_id");
    }

    public static final String getPlatform_generate_ui_filter_fields() {
        return bundlePath.getString("ui_filter_fields");
    }

    public static final String getPlatform_ui_search_filed_num() {
        return bundlePath.getString("platform_ui_search_filed_num");
    }

    public static final String getPlatform_ui_field_required_num() {
        return bundlePath.getString("platform_ui_field_required_num");
    }

    public static String getProject_path() {
        String projp = bundlePath.getString("project_path");
        if ((projp != null) && (!"".equals(projp))) {
            project_path = projp;
        }
        return project_path;
    }

    public static void setProject_path(String project_path) {
        project_path = project_path;
    }
}
