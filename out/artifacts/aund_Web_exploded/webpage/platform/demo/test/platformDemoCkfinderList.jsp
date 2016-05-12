<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;"><t:datagrid name="platformDemoCkfinderList" title="ckeditor+ckfinder例子" actionUrl="platformDemoCkfinderController.do?datagrid" idField="id" fit="true">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="图片" field="image" imageSize="90,50"></t:dgCol>
	<t:dgCol title="附件" field="attachment" downloadName="点击下载"></t:dgCol>
	<!-- 备注最好隐藏，不然你试试？ -->
	<t:dgCol title="备注" field="remark" hidden="true"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除" url="platformDemoCkfinderController.do?del&id={id}" />
	<t:dgToolBar title="录入" icon="icon-add" url="platformDemoCkfinderController.do?addorupdate" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="platformDemoCkfinderController.do?addorupdate" funname="update"></t:dgToolBar>
	<t:dgToolBar title="查看" icon="icon-search" url="platformDemoCkfinderController.do?addorupdate" funname="detail"></t:dgToolBar>
	<t:dgFunOpt funname="preview(id)" title="预览"></t:dgFunOpt>
</t:datagrid> <script type="text/javascript">
			function preview(id) {
				var url = 'platformDemoCkfinderController.do?preview&id=' + id;
				createwindow('预览', url, 830, 400);
			}
		</script></div>
</div>