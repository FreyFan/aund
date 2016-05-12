<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid title="系统硬件资源监控" name="hardwareList" actionUrl="hardwareController.do?datagrid" idField="id" sortName="timestamp" sortOrder="desc" pageSize="10" extendParams="view:scrollview,">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="服务器名称 " field="computerName" width="200"></t:dgCol>
	<t:dgCol title="IP地址" field="ip" width="100"></t:dgCol>
	<t:dgCol title="CPU使用率（%）" field="cpu" width="100"></t:dgCol>
	<t:dgCol title="内存使用率（%）" field="memory" width="100"></t:dgCol>
	<t:dgCol title="磁盘使用率（%）" field="disk" width="100"></t:dgCol>
	<t:dgCol title="网络输入量" field="i" width="100"></t:dgCol>
	<t:dgCol title="网络输出量" field="o" width="100"></t:dgCol>
	<t:dgCol title="告警状态" field="status" width="100" replace="告警_0,正常_1"></t:dgCol>
	<t:dgCol title="是否确认" field="isNoBeKnow" width="100" replace="未确认_0,确认_1"></t:dgCol>
	<t:dgCol title="统计时间" field="timestamp" formatter="yyyy-MM-dd hh:mm:ss" width="200"></t:dgCol>
</t:datagrid>


