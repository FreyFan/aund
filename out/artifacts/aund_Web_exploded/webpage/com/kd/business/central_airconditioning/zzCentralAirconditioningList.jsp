<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzCentralAirconditioningList" checkbox="true" fitColumns="false" title="中央空调实时监控" actionUrl="zzCentralAirconditioningController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="MacId"  field="macid"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="discribe"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="空调温度"  field="airTemperature"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="室内温度"  field="indoorTemperature"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="department"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="responsiblePerson"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzCentralAirconditioningController.do?doDel&id={id}" />
   <t:dgToolBar title="开通" icon="icon-add" url="zzCentralAirconditioningController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="关闭" icon="icon-edit" url="zzCentralAirconditioningController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="调节温度" icon="icon-add" url="zzCentralAirconditioningController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzCentralAirconditioningController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="录入" icon="icon-add" url="zzCentralAirconditioningController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zzCentralAirconditioningController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzCentralAirconditioningController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/central_airconditioning/zzCentralAirconditioningList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zzCentralAirconditioningListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zzCentralAirconditioningListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zzCentralAirconditioningController.do?upload', "zzCentralAirconditioningList");
}

//导出
function ExportXls() {
	PlatformExcelExport("zzCentralAirconditioningController.do?exportXls","zzCentralAirconditioningList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("zzCentralAirconditioningController.do?exportXlsByT","zzCentralAirconditioningList");
}
 </script>