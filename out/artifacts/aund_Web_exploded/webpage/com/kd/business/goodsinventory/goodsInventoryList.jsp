<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="goodsInventoryList" checkbox="true" fitColumns="false" title="库存详情" actionUrl="goodsInventoryController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品编号"  field="productId"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品名字"  field="productName"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="库存数量"  field="goodsNum"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="goodsUnit"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="responsibility"   query="true" queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="时间"  field="recordTime"    queryMode="single"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="goodsInventoryController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="goodsInventoryController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="goodsInventoryController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="goodsInventoryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="goodsInventoryController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>

  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/goodsinventory/goodsInventoryList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#goodsInventoryListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#goodsInventoryListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'goodsInventoryController.do?upload', "goodsInventoryList");
}

//导出
function ExportXls() {
	PlatformExcelExport("goodsInventoryController.do?exportXls","goodsInventoryList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("goodsInventoryController.do?exportXlsByT","goodsInventoryList");
}
 </script>