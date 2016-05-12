<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>电表耗能</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzElectricEnergyController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzElectricEnergyPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzElectricEnergyPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzElectricEnergyPage.createBy }">
					<input id="updateName" name="updateName" type="hidden" value="${zzElectricEnergyPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzElectricEnergyPage.updateBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzElectricEnergyPage.createDate }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzElectricEnergyPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzElectricEnergyPage.type}'>
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
									               
										       value='${zzElectricEnergyPage.status}'>
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
									               
										       value='${zzElectricEnergyPage.description}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								使用电量:
							</label>
						</td>
						<td class="value">
						     	 <input id="electricity" name="electricity" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzElectricEnergyPage.electricity}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用电量</label>
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
									               
										       value='${zzElectricEnergyPage.subDepartment}'>
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
									               
										       value='${zzElectricEnergyPage.responsiblePerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								日期:
							</label>
						</td>
						<td class="value">
						     	 <input id="statisDate" name="statisDate" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzElectricEnergyPage.statisDate}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日期</label>
						</td>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户:
							</label>
						</td>
						<td class="value">
						     	 <input id="electricityUser" name="electricityUser" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzElectricEnergyPage.electricityUser}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/electric_energy/zzElectricEnergy.js"></script>		