<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="memberList" checkbox="true" fitColumns="false" title="会员表" actionUrl="memberController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="userName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出生年月"  field="birthday" formatter="yyyy-MM-dd"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"   query="true" queryMode="single" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="联系方式"  field="tel"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="adress"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="消费店面"  field="store"   query="true" queryMode="single" dictionary="store" width="120"></t:dgCol>
   <t:dgCol title="消费产品明细"  field="detail"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="消费金额"  field="amount"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="线上线下"  field="type"   query="true" queryMode="single" dictionary="type" width="120"></t:dgCol>
   <t:dgCol title="发货地点"  field="dispatchPlace"   query="true" queryMode="single" dictionary="place" width="120"></t:dgCol>
   <t:dgCol title="等级"  field="level"   query="true" queryMode="single" dictionary="level" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="memberController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="memberController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="memberController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="memberController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="memberController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>

  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/member/memberList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#memberListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#memberListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#memberListtb").find("input[name='birthday']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'memberController.do?upload', "memberList");
}

//导出
function ExportXls() {
	PlatformExcelExport("memberController.do?exportXls","memberList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("memberController.do?exportXlsByT","memberList");
}
 </script>