package com.kd.platform.core.constant;

import com.kd.platform.core.util.ResourceUtil;

/**
 * <b>Application name:</b> Globals.java <br>
 * <b>Application describing:全局变量定义 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-7-15 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public final class Globals {
    /**
     * 保存用户到SESSION
     */
    public static String USER_SESSION = "USER_SESSION";

    /**
     * 人员类型
     */
    public static Short User_Normal = 1;// 正常

    public static Short User_Forbidden = 0;// 禁用

    public static Short User_ADMIN = -1;// 超级管理员

    /**
     * 日志级别定义
     */
    public static Short Log_Leavel_INFO = 1;

    public static Short Log_Leavel_WARRING = 2;

    public static Short Log_Leavel_ERROR = 3;

    /**
     * 日志类型
     */
    public static Short Log_Type_LOGIN = 1; // 登陆

    public static Short Log_Type_EXIT = 2; // 退出

    public static Short Log_Type_INSERT = 3; // 插入

    public static Short Log_Type_DEL = 4; // 删除

    public static Short Log_Type_UPDATE = 5; // 更新

    public static Short Log_Type_UPLOAD = 6; // 上传

    public static Short Log_Type_OTHER = 7; // 其他

    /**
     * 词典分组定义
     */
    public static String TypeGroup_Database = "database";// 数据表分类

    /**
     * 权限等级
     */
    public static Short Function_Leave_ONE = 0;// 一级权限

    public static Short Function_Leave_TWO = 1;// 二级权限

    /**
     * 权限等级前缀
     */
    public static String Function_Order_ONE = "ofun";// 一级权限

    public static String Function_Order_TWO = "tfun";// 二级权限

    /**
     * 权限类型
     */
    public static Short Function_TYPE_PAGE = 0;// 页面（菜单：菜单类型）

    public static Short Function_TYPE_FROM = 1;// 表单/或者弹出（菜单：访问类型）

    /**
     * 没有勾选的操作code
     */
    public static String NOAUTO_OPERATIONCODES = "noauto_operationCodes";

    /**
     * 勾选了的操作code
     */
    public static String OPERATIONCODES = "operationCodes";

    /**
     * 权限类型
     */
    public static Short OPERATION_TYPE_HIDE = 0;// 页面

    public static Short OPERATION_TYPE_DISABLED = 1;// 表单/或者弹出

    /**
     * 数据权限 - 菜单数据规则集合
     */
    public static String MENU_DATA_AUTHOR_RULES = "MENU_DATA_AUTHOR_RULES";

    /**
     * 数据权限 - 菜单数据规则sql
     */
    public static String MENU_DATA_AUTHOR_RULE_SQL = "MENU_DATA_AUTHOR_RULE_SQL";

    /**
     * 新闻法规
     */
    public static Short Document_NEW = 0; // 新建

    public static Short Document_PUBLICH = 0; // 发布

    /**
     * 配置系统是否开启按钮权限控制
     */
    public static boolean BUTTON_AUTHORITY_CHECK = false;
    static {
        String button_authority_platform = ResourceUtil.getSessionattachmenttitle("button.authority.platform");
        if ("true".equals(button_authority_platform)) {
            BUTTON_AUTHORITY_CHECK = true;
        }
    }
}
