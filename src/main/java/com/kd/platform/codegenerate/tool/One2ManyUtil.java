package com.kd.platform.codegenerate.tool;

import java.util.ArrayList;
import java.util.List;


import com.kd.platform.codegenerate.generate.onetomany.CodeGenerateOneToMany;
import com.kd.platform.codegenerate.pojo.onetomany.CodeParamEntity;
import com.kd.platform.codegenerate.pojo.onetomany.SubTableEntity;

/**
 * <b>Application name:</b> PlatformOneToMainUtil.java <br>
 * <b>Application describing: 代码生成器入口【一对多】</b> <br>
 * <b>Copyright:</b> Copyright &copy; 2014 Frey.Fan 版权所有。<br>
 * <b>Company:</b> Frey.Fan <br>
 * <b>Date:</b> 2014-5-9 <br>
 * @author <a href="mailto:Frey.Fan@163.com"> Frey.Fan </a>
 * @version V1.0
 */
public class One2ManyUtil {

    /**
     * 一对多(父子表)数据模型，生成方法
     * @param args
     */
    public static void main(String[] args) {
        // 第一步：设置主表
        CodeParamEntity codeParamEntityIn = new CodeParamEntity();
        codeParamEntityIn.setTableName("platform_order_main");// 主表[表名]
        codeParamEntityIn.setEntityName("OrderMain"); // 主表[实体名]
        codeParamEntityIn.setEntityPackage("platform"); // 主表[包名]
        codeParamEntityIn.setFtlDescription("订单主数据"); // 主表[描述]

        // 第二步：设置子表集合
        List<SubTableEntity> subTabParamIn = new ArrayList<SubTableEntity>();
        // [1].子表一
        SubTableEntity po = new SubTableEntity();
        po.setTableName("platform_order_custom");// 子表[表名]
        po.setEntityName("OrderCustoms"); // 子表[实体名]
        po.setEntityPackage("platform"); // 子表[包]
        po.setFtlDescription("订单客户明细"); // 子表[描述]
        // 子表[外键:与主表关联外键]
        // 说明：这里面的外键是子表的外键字段,非主表和子表的对应关系 GORDER_ID修改为ID
        po.setForeignKeys(new String[] { "ID", "GO_ORDER_CODE" });
        subTabParamIn.add(po);
        // [2].子表二
        SubTableEntity po2 = new SubTableEntity();
        po2.setTableName("platform_order_product"); // 子表[表名]
        po2.setEntityName("OrderProduct"); // 子表[实体名]
        po2.setEntityPackage("platform"); // 子表[包]
        po2.setFtlDescription("订单产品明细"); // 子表[描述]
        // 子表[外键:与主表关联外键]
        // 说明：这里面的外键是子表的外键字段,非主表和子表的对应关系 GORDER_ID修改为ID
        po2.setForeignKeys(new String[] { "ID", "GO_ORDER_CODE" });
        subTabParamIn.add(po2);
        codeParamEntityIn.setSubTabParam(subTabParamIn);

        // 第三步：一对多(父子表)数据模型,代码生成
        CodeGenerateOneToMany.oneToManyCreate(subTabParamIn, codeParamEntityIn);
    }
}
