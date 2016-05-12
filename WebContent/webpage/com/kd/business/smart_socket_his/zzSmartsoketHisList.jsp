<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzSmartsoketHisList" checkbox="true" fitColumns="false" title="历史查询" actionUrl="zzSmartsoketHisController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="MAC标示"  field="macId"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="每小时电量"  field="electricQuantity"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="记录时间"  field="recordTime"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="state"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="部门"  field="department"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="责任人"  field="responsiblePerson"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="实时电量"  field="eStats"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzSmartsoketHisController.do?doDel&id={id}" />
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/smart_socket_his/zzSmartsoketHisList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zzSmartsoketHisListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zzSmartsoketHisListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zzSmartsoketHisController.do?upload', "zzSmartsoketHisList");
}

//导出
function ExportXls() {
	PlatformExcelExport("zzSmartsoketHisController.do?exportXls","zzSmartsoketHisList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("zzSmartsoketHisController.do?exportXlsByT","zzSmartsoketHisList");
}
 </script>