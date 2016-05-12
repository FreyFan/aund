<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能插座电量及相关信息历史表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzSmartsoketHisController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzSmartsoketHisPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzSmartsoketHisPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzSmartsoketHisPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzSmartsoketHisPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zzSmartsoketHisPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzSmartsoketHisPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzSmartsoketHisPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							MAC标示:
						</label>
					</td>
					<td class="value">
					     	 <input id="macId" name="macId" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">MAC标示</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							每小时电量:
						</label>
					</td>
					<td class="value">
					     	 <input id="electricQuantity" name="electricQuantity" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">每小时电量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							记录时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="recordTime" name="recordTime" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">记录时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="state" name="state" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="department" name="department" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部门</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value">
					     	 <input id="responsiblePerson" name="responsiblePerson" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实时电量:
						</label>
					</td>
					<td class="value">
					     	 <input id="eStats" name="eStats" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实时电量</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/smart_socket_his/zzSmartsoketHis.js"></script>		