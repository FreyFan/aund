<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 1px;">
		<t:datagrid name="thresholdList" title="硬件资源阀值管理" actionUrl="thresholdController.do?datagrid" idField="id" fit="true">
			<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
			<t:dgCol title="CPU使用率阀值" field="cpu"></t:dgCol>
			<t:dgCol title="内存占用量阀值" field="internalStorage"></t:dgCol>
			<t:dgCol title="硬盘占用量阀值" field="descSpace"></t:dgCol>
<%-- 			<t:dgCol title="网络输入输出量阀值（M）" field="io" ></t:dgCol>		 --%>
			<t:dgCol title="定时统计周期（毫秒）" field="timePeriod"></t:dgCol>			
			<t:dgCol title="告警是否提示声音" field="soundIsNo"  replace="否_0,是_1"></t:dgCol>		
			<t:dgToolBar title="编辑" icon="icon-edit" url="thresholdController.do?addorupdate" funname="update"></t:dgToolBar>
			
		</t:datagrid>
	</div>
</div>
