<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzElectricEnergyList" checkbox="true" fitColumns="false" title="电表耗能" actionUrl="zzElectricEnergyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述"  field="description"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用电量"  field="electricity"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="subDepartment"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="责任人"  field="responsiblePerson"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日期"  field="statisDate"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="electricityUser"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzElectricEnergyController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="zzElectricEnergyController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzElectricEnergyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="zzElectricEnergyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzElectricEnergyController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/electric_energy/zzElectricEnergyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zzElectricEnergyListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zzElectricEnergyListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zzElectricEnergyController.do?upload', "zzElectricEnergyList");
}

//导出
function ExportXls() {
	PlatformExcelExport("zzElectricEnergyController.do?exportXls","zzElectricEnergyList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("zzElectricEnergyController.do?exportXlsByT","zzElectricEnergyList");
}
 </script>