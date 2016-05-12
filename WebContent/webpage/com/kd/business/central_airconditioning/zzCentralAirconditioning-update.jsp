<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>中央空调实时监控</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzCentralAirconditioningController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzCentralAirconditioningPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzCentralAirconditioningPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzCentralAirconditioningPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzCentralAirconditioningPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zzCentralAirconditioningPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzCentralAirconditioningPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzCentralAirconditioningPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								MacId:
							</label>
						</td>
						<td class="value">
						     	 <input id="macid" name="macid" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzCentralAirconditioningPage.macid}'>
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
									               
										       value='${zzCentralAirconditioningPage.type}'>
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
									               
										       value='${zzCentralAirconditioningPage.status}'>
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
									               
										       value='${zzCentralAirconditioningPage.discribe}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								空调温度:
							</label>
						</td>
						<td class="value">
						     	 <input id="airTemperature" name="airTemperature" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzCentralAirconditioningPage.airTemperature}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">空调温度</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								室内温度:
							</label>
						</td>
						<td class="value">
						     	 <input id="indoorTemperature" name="indoorTemperature" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzCentralAirconditioningPage.indoorTemperature}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">室内温度</label>
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
									               
										       value='${zzCentralAirconditioningPage.department}'>
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
									               
										       value='${zzCentralAirconditioningPage.responsiblePerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/central_airconditioning/zzCentralAirconditioning.js"></script>		