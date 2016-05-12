<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能电表状态</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzSmartmeterStausController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzSmartmeterStausPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzSmartmeterStausPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzSmartmeterStausPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzSmartmeterStausPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zzSmartmeterStausPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzSmartmeterStausPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzSmartmeterStausPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.type}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.status}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								描述:
							</label>
						</td>
						<td class="value">
						     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.description}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电流:
							</label>
						</td>
						<td class="value">
						     	 <input id="electricCurrent" name="electricCurrent" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.electricCurrent}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电流</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电压:
							</label>
						</td>
						<td class="value">
						     	 <input id="voltage" name="voltage" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.voltage}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">电压</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								功率:
							</label>
						</td>
						<td class="value">
						     	 <input id="power" name="power" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.power}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">功率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属部门:
							</label>
						</td>
						<td class="value">
						     	 <input id="subDepartment" name="subDepartment" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.subDepartment}'>
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
									               
										       value='${zzSmartmeterStausPage.responsiblePerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用电用户:
							</label>
						</td>
						<td class="value">
						     	 <input id="electricUser" name="electricUser" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartmeterStausPage.electricUser}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用电用户</label>
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
  <script src = "webpage/com/kd/business/smartmeter_staus/zzSmartmeterStaus.js"></script>		