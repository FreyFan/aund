<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>硬件资源阀值管理</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="thresholdController.do?save">
		<input id="id" name="id" type="hidden" value="${thresholdPage.id }">
		<fieldset class="step">
			<div class="form">
				<label class="Validform_label">CPU使用率阀值:</label> 
				<input class="inputxt" id="cpu" name="cpu" value="${thresholdPage.cpu}" datatype="*"> 
				<span class="Validform_checktip"></span>
			</div>
			<div class="form">
				<label class="Validform_label">内存占用量阀值:</label> 
				<input class="inputxt" id="internalStorage" name="internalStorage" value="${thresholdPage.internalStorage}" datatype="*"> 
				<span class="Validform_checktip"></span>
			</div>
			<div class="form">
				<label class="Validform_label">硬盘占用量阀值:</label> 
				<input class="inputxt" id="descSpace" name="descSpace" value="${thresholdPage.descSpace}" datatype="*"> 
				<span class="Validform_checktip"></span>
			</div>
			<div class="form">
				<label class="Validform_label">定时统计周期（毫秒）:</label> 
				<input class="inputxt" id="timePeriod" name="timePeriod" value="${thresholdPage.timePeriod}" datatype="*"> 
				<span class="Validform_checktip"></span>
			</div>
			<div class="form">
				<label class="Validform_label">告警是否提示声音:</label> 
				<input class="inputxt" id="soundIsNo" name="soundIsNo" value="${thresholdPage.soundIsNo}" datatype="*"> 
				<span class="Validform_checktip"></span>
			</div>
		</fieldset>
	</t:formvalid>
</body>