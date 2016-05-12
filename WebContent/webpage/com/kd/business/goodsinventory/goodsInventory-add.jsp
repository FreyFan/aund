<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>库存详情</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="goodsInventoryController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${goodsInventoryPage.id }">
					<input id="createName" name="createName" type="hidden" value="${goodsInventoryPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${goodsInventoryPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${goodsInventoryPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${goodsInventoryPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${goodsInventoryPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${goodsInventoryPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="productId" name="productId" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品编号</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品名字:
						</label>
					</td>
					<td class="value">
					     	 <input id="productName" name="productName" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品名字</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							库存数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="goodsNum" name="goodsNum" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">库存数量</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单位:
						</label>
					</td>
					<td class="value">
					     	 <input id="goodsUnit" name="goodsUnit" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							责任人:
						</label>
					</td>
					<td class="value">
					     	 <input id="responsibility" name="responsibility" type="text" style="width: 150px" class="inputxt"
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">责任人</label>
						</td>

			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/kd/business/goodsinventory/goodsInventory.js"></script>		