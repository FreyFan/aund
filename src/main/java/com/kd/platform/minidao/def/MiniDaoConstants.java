package com.kd.platform.minidao.def;

/**
 * <b>Application name:</b> MiniDaoConstants.java <br>
 * <b>Application describing:MiniDao 常量文件 </b> <br>
 * <b>Copyright:</b> Copyright &copy; 2015 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2015-6-10 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class MiniDaoConstants {

    /**
     * 接口方法定義規則 添加：insert,add,create 添加：update,modify,store 刪除：delete,remove 檢索：以上各单词之外
     */
    public static final String INF_METHOD_ACTIVE = "insert,add,create,update,modify,store,delete,remove";

    public static final String INF_METHOD_BATCH = "batch";

    /**
     * 方法有且只有一个参数 用户未使用@Arguments 标签 模板中引用参数默认为：dto
     */
    public static final String SQL_FTL_DTO = "dto";

    public static final String METHOD_SAVE_BY_HIBER = "saveByHiber";

    public static final String METHOD_GET_BY_ID_HIBER = "getByIdHiber";

    public static final String METHOD_GET_BY_ENTITY_HIBER = "getByEntityHiber";

    public static final String METHOD_UPDATE_BY_HIBER = "updateByHiber";

    public static final String METHOD_DELETE_BY_HIBER = "deleteByHiber";

    public static final String METHOD_LIST_BY_HIBER = "listByHiber";

    public static final String METHOD_DELETE_BY_ID_HIBER = "deleteByIdHiber";
}
