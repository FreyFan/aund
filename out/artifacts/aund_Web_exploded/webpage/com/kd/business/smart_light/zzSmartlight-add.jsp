<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能电灯</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzSmartlightController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzSmartlightPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzSmartlightPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzSmartlightPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzSmartlightPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zzSmartlightPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzSmartlightPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzSmartlightPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							MacId:
						</label>
					</td>
					<td class="value">
					     	 <input id="macid" name="macid" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">MacId</label>
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
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							描述:
						</label>
					</td>
					<td class="value">
					     	 <input id="discribe" name="discribe" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							电流:
						</label>
					</td>
					<td class="value">
					     	 <input id="electricCurrent" name="electricCurrent" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电流</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							电压:
						</label>
					</td>
					<td class="value">
					     	 <input id="voltage" name="voltage" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电压</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							所属部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="department" name="department" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属部门</label>
						</td>
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
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							亮度级别:
						</label>
					</td>
					<td class="value">
					     	 <input id="level" name="level" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">亮度级别</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/smart_light/zzSmartlight.js"></script>		