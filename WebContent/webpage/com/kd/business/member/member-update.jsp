<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>会员表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="memberController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${memberPage.id }">
					<input id="createName" name="createName" type="hidden" value="${memberPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${memberPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${memberPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${memberPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${memberPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${memberPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="userName" name="userName" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.userName}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								出生年月:
							</label>
						</td>
						<td class="value">
									  <input id="birthday" name="birthday" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${memberPage.birthday}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出生年月</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="sex" type="list"
										typeGroupCode="sex" defaultVal="${memberPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								联系方式:
							</label>
						</td>
						<td class="value">
						     	 <input id="tel" name="tel" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.tel}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系方式</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="adress" name="adress" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.adress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								消费店面:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="store" type="list"
										typeGroupCode="store" defaultVal="${memberPage.store}" hasLabel="false"  title="消费店面"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消费店面</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								消费产品明细:
							</label>
						</td>
						<td class="value">
						     	 <input id="detail" name="detail" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.detail}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消费产品明细</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								消费金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.amount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消费金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								线上线下:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="type" type="list"
										typeGroupCode="type" defaultVal="${memberPage.type}" hasLabel="false"  title="线上线下"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">线上线下</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								发货地点:
							</label>
						</td>
						<td class="value">
						     	 <input id="dispatchPlace" name="dispatchPlace" type="text" style="width: 150px" class="inputxt"  
									               
										       value='${memberPage.dispatchPlace}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">发货地点</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								等级:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="level" type="list"
										typeGroupCode="level" defaultVal="${memberPage.level}" hasLabel="false"  title="等级"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">等级</label>
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
  <script src = "webpage/com/kd/business/member/member.js"></script>		