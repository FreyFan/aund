package com.kd.platform.codegenerate.util;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * <b>Application name:</b> PlatformCodeDeleteUtil.java <br>
 * <b>Application describing: 删除自动生成的代码</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-4-18 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class PlatformCodeDeleteUtil {
    private static String buss_package = CodeResourceUtil.bussiPackage;

    private static final String src_url = "src/" + buss_package;

    private static final String web_url = "WebRoot/" + buss_package;

    private static final String action_inx = "action";

    private static final String entity_inx = "entity";

    private static final String page_inx = "page";

    private static final String service_inx = "service";

    private static final String impl_inx = "impl";

    private static String action_url;

    private static String entity_url;

    private static String page_url;

    private static String service_url;

    private static String service_impl_url;

    private static String jsp_url;

    private static String jsp_add_url;

    private static String jsp_edit_url;

    public static void init(String gn_package, String name) {
        action_url = src_url + "/" + "action" + "/" + gn_package + "/" + name + "Action.java";
        entity_url = src_url + "/" + "entity" + "/" + gn_package + "/" + name + "Entity.java";
        page_url = src_url + "/" + "page" + "/" + gn_package + "/" + name + "Page.java";
        service_url = src_url + "/" + "service" + "/" + gn_package + "/" + name + "ServiceI.java";
        service_impl_url = src_url + "/" + "service" + "/" + "impl" + "/" + gn_package + "/" + name + "ServiceImpl.java";
        jsp_url = web_url + "/" + gn_package + "/" + name + ".jsp";
        jsp_add_url = web_url + "/" + gn_package + "/" + name + "-main-add.jsp";
        jsp_edit_url = web_url + "/" + gn_package + "/" + name + "-main-edit.jsp";

        String path = getProjectPath();
        action_url = path + "/" + action_url;
        entity_url = path + "/" + entity_url;
        page_url = path + "/" + page_url;
        service_url = path + "/" + service_url;
        service_impl_url = path + "/" + service_impl_url;
        jsp_url = path + "/" + jsp_url;
        jsp_add_url = path + "/" + jsp_add_url;
        jsp_edit_url = path + "/" + jsp_edit_url;
    }

    public static void main(String[] args) {
        String name = "Company";
        String subPackage = "test";
        delCode(subPackage, name);
    }

    public static void delCode(String subPackage, String codeName) {
        init(subPackage, codeName);

        delete(action_url);
        delete(entity_url);
        delete(page_url);
        delete(service_url);
        delete(service_impl_url);
        delete(jsp_edit_url);
        delete(jsp_url);
        delete(jsp_add_url);

        System.out.println("--------------------删除动作结束-----------------------");
    }

    public static String getProjectPath() {
        String path = System.getProperty("user.dir").replace("\\", "/") + "/";
        return path;
    }

    public static boolean delete(String strFileName) {
        File fileDelete = new File(strFileName);

        if ((!fileDelete.exists()) || (!fileDelete.isFile())) {
            return false;
        }

        System.out.println("--------成功删除文件---------" + strFileName);
        return fileDelete.delete();
    }
}
