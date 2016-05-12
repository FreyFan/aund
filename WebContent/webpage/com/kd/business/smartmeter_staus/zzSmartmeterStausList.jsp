<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzSmartmeterStausList" checkbox="true" fitColumns="false" title="智能电表状态" actionUrl="zzSmartmeterStausController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="description"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电流"  field="electricCurrent"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电压"  field="voltage"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="功率"  field="power"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="subDepartment"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="responsiblePerson"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用电用户"  field="electricUser"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzSmartmeterStausController.do?doDel&id={id}" />
   <t:dgToolBar title="连通" icon="icon-add" url="zzSmartmeterStausController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="关闭" icon="icon-edit" url="zzSmartmeterStausController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="录入" icon="icon-add" url="zzSmartmeterStausController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzSmartmeterStausController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zzSmartmeterStausController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzSmartmeterStausController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/smartmeter_staus/zzSmartmeterStausList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zzSmartmeterStausListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zzSmartmeterStausListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zzSmartmeterStausController.do?upload', "zzSmartmeterStausList");
}

//导出
function ExportXls() {
	PlatformExcelExport("zzSmartmeterStausController.do?exportXls","zzSmartmeterStausList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("zzSmartmeterStausController.do?exportXlsByT","zzSmartmeterStausList");
}
 </script>