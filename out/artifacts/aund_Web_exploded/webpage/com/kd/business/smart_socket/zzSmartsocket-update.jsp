<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能插座状态</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="zzSmartsocketController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${zzSmartsocketPage.id }">
					<input id="createName" name="createName" type="hidden" value="${zzSmartsocketPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${zzSmartsocketPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${zzSmartsocketPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${zzSmartsocketPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${zzSmartsocketPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${zzSmartsocketPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								Mac标识:
							</label>
						</td>
						<td class="value">
						     	 <input id="macId" name="macId" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartsocketPage.macId}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">Mac标识</label>
						</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						IP地址:
					</label>
				</td>
				<td class="value">
					<input id="ip" name="ip" type="text" style="width: 150px" class="inputxt" value='${zzSmartsocketPage.ip}'>
					<span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">ip地址</label>
				</td>
			</tr>
			<tr>
				<td align="right">
					<label class="Validform_label">
						端口号:
					</label>
				</td>
				<td class="value">
					<input id="port" name="port" type="text" style="width: 150px" class="inputxt" value='${zzSmartsocketPage.port}'>
					<span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">端口号</label>
				</td>
			</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								类型:
							</label>
						</td>
						<td class="value">
						     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartsocketPage.type}'>
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
									               
										       value='${zzSmartsocketPage.status}'>
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
						     	 <input id="discreprion" name="discreprion" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${zzSmartsocketPage.discreprion}'>
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
									               
										       value='${zzSmartsocketPage.electricCurrent}'>
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
									               
										       value='${zzSmartsocketPage.voltage}'>
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
									               
										       value='${zzSmartsocketPage.department}'>
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
									               
										       value='${zzSmartsocketPage.responsiblePerson}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/smart_socket/zzSmartsocket.js"></script>		