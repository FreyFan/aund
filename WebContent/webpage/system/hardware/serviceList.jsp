<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid title="系统服务监控" name="serviceList" actionUrl="serviceController.do?datagrid" idField="id" sortName="time" sortOrder="desc" pageSize="10" extendParams="view:scrollview,">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="服务器名称 " field="serveName" width="100"></t:dgCol>
	<t:dgCol title="IP地址" field="ip" width="100"></t:dgCol>
	<t:dgCol title="端口" field="port" width="50"></t:dgCol>
	<t:dgCol title="系统服务描述" field="serveDescribe" width="100"></t:dgCol>
	<t:dgCol title="系统服务url" field="url" width="300"></t:dgCol>
	<t:dgCol title="服务状态" field="status" width="50" replace="异常_1,正常_0"></t:dgCol>
	<t:dgCol title="服务类型" field="type" width="50" replace="http_0,tcp_1"></t:dgCol>
	<t:dgCol title="是否确认" field="isNoBeKnow" width="50" replace="未确认_0,确认_1"></t:dgCol>
	<t:dgCol title="统计时间" field="time" formatter="yyyy-MM-dd hh:mm:ss" width="200"></t:dgCol>
</t:datagrid>


