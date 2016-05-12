<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout " fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="zzSmartsocketList" checkbox="true" fitColumns="false" title="智能插座状态" actionUrl="zzSmartsocketController.do?datagrid_status_NS&status=NS" idField="id" fit="true" queryMode="group" pageSize="20">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="Mac标识"  field="macId"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"    queryMode="single"  replace="has.conn_Y,has.noconn_N,has.nosignal_NS" style="background:#93E38E;_Y,background:#E5677C;_N,background:#909090;_NS"  query="true"  width="60"></t:dgCol>
   <t:dgCol title="描述"  field="discreprion"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电流"  field="electricCurrent"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电压"  field="voltage"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="department"    queryMode="single"  width="120"   query="true"></t:dgCol>
   <t:dgCol title="责任人"  field="responsiblePerson"    queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="zzSmartsocketController.do?doDel&id={id}" />
   <t:dgToolBar title="连通" icon="icon-add" url="zzSmartsocketController.do?connSocket" funname="connALLSelect"></t:dgToolBar>
   <t:dgToolBar title="断开" icon="icon-edit" url="zzSmartsocketController.do?cutDownSocket" funname="cutDownSocket"></t:dgToolBar>
   <t:dgToolBar title="添加" icon="icon-add" url="zzSmartsocketController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="zzSmartsocketController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="zzSmartsocketController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="zzSmartsocketController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/kd/business/smart_socket/zzSmartsocketList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#zzSmartsocketListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#zzSmartsocketListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'zzSmartsocketController.do?upload', "zzSmartsocketList");
}

//导出
function ExportXls() {
	PlatformExcelExport("zzSmartsocketController.do?exportXls","zzSmartsocketList");
}

//模板下载
function ExportXlsByT() {
	PlatformExcelExport("zzSmartsocketController.do?exportXlsByT","zzSmartsocketList");
}
function connALLSelect() {
	gname = "zzSmartsocketList";
    var ids = [];
    var rows = $("#zzSmartsocketList").datagrid('getSelections');
    if (rows.length > 0) {
    	$.dialog.confirm('你确定连接智能插座吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				$.ajax({
					url : "zzSmartsocketController.do?connSocket",
					type : 'post',
					data : {
						ids : ids.join(',')
					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							tip(msg);
							reloadTable();
							$("#"+gname).datagrid('reload');
							ids='';
						}
					}
				});
			}
		});
	} else {
		tip("请选择需要连接的智能插座");
	}
}
function cutDownSocket() {
	gname = "zzSmartsocketList";
    var ids = [];
    var rows = $("#zzSmartsocketList").datagrid('getSelections');
    if (rows.length > 0) {
    	$.dialog.confirm('你确定断开智能插座吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
				$.ajax({
					url : "zzSmartsocketController.do?cutDownSocket",
					type : 'post',
					data : {
						ids : ids.join(',')
					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							tip(msg);
							
							reloadTable();
							$("#"+gname).datagrid('reload');
							ids='';
						}
					}
				});
			}
		});
	} else {
		tip("请选择需要断开的智能插座");
	}
}
 </script>
