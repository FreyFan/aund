<%--
  Created by IntelliJ IDEA.
  User: Fanchengwei
  Date: 2015/11/16
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui"></t:base>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="plug-in/echarts/echarts.js"></script>
<!-- <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script> -->
<script src="plug-in/echarts/echarts-all.js"></script>
<script src="webpage/platform/demo/base/report/SmartSocketHistoryAnalyze.js"></script>
<link href="webpage/platform/demo/base/report/smart.css" rel="stylesheet" type="text/css" />
<style>
#datadiv {
	height: 30%;
	width: 98%;
}
#echart{
	height:50%;
	width: 98%;
	border:#999 solid 1px;
}
#about{
	height: 20%;
	width: 98%;
}
.content{
		height:200;overflow:hidden;border:solid 1px;	
	}
.content{
	border-radius:10px;
	-webkit-border-radius:10px;
	-moz-border-radius:10px;
}
</style>
<script type="text/javascript">
	$(function(){
		initData();
		initSokectReport();
	});
</script>

<div style="height: 10px"></div>

<div class="form">
	<label class="Validform_label"> 开始日期： </label> <input name="date" id="startDate" class="easyui-datebox"> <span class="Validform_checktip"></span>
	<label class="Validform_label"> 结束日期： </label> <input name="date" id="endDate" class="easyui-datebox"> <span class="Validform_checktip"></span>
	<%--<span >
		<a class="button" onclick="searchHis()" iconcls="icon-search" href="#" style="padding-left: 30px; margin-right: 30px;text-align:center">查询</a>
		&lt;%&ndash;<a class="button" onclick="" iconcls="icon-reload" href="#">重置</a>&ndash;%&gt;
	</span>--%>
	<a onclick="searchHis()" iconcls="icon-search" class="easyui-linkbutton" style="margin-left:10px " href="#" id="">查询</a>
</div>

<div class="cAInfo cAGroupNum clearfix" >
	<ul class="cALump154">
						<li class="cABorder marginRight45 cALumpLi511">
							<span class="cALumpLiB1 marginLeft10 fl">
								<p class="fontSize14 marginLeft10 cAFontWeightP">实际用电量</p>
								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="totalElectricQuantity"></p>
							</span>
							<span class="cALumpLiB2 marginLeft10 fl">
								<p class="fontSize14 cAFontWeightP textCenter">电费</p>
								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="totalElectricityFees"></p>
							</span>
						</li>
						<li class="cABorder marginRight45 cALumpLi511">
							<span class="cALumpLiB1 marginLeft10 fl">
								<p class="fontSize14 marginLeft10 cAFontWeightP">未使用节能策略用电量</p>
								<p class="cAPoolFont25 cALumpLableText airBlue" id="n_totalElectricQuantity"></p>
							</span>
							<span class="cALumpLiB2 marginLeft10 fl">
								<p class="fontSize14 cAFontWeightP textCenter">电费</p>
								<p class="cAPoolFont25 cALumpLableText airBlue" id="n_totalElectricityFees"><span class="fontSize16"></span></p>
							</span>
						</li>
						<li class="cABorder marginRight45 cALumpLi511">
							<span class="cALumpLiB3 marginLeft10 fl">
								<p class="fontSize14 marginLeft10 cAFontWeightP">为您节约的电量</p>
								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="saveElectricQuantity"></p>
							</span>
							<span class="cALumpLiB4 marginLeft10 fl">
								<p class="fontSize14 cAFontWeightP textCenter">节约电费</p>
								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="saveElectricityFees"><span class="fontSize16"></span></p>
							</span> 
							<span class="cALumpLiB5 marginLeft10 fl">
								<p class="fontSize14 cAFontWeightP textCenter">节能率</p>
								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="saveElectricityRate"><span class="fontSize16"></span></p>
							</span> 
						</li>
					</ul>
</div>
<div style="height: 15px"></div>
<div id="echart" title="功率分析" class="content"></div>
<div style="height: 15px"></div>
<div id="datadiv" class="content">
    <t:datagrid name="studentStatisticList" title="" actionUrl="zzSmartsoketHisController.do?listAllStatisticByJdbc" idField="id" fit="true">
        <t:dgCol title="部门" field="department" width="130"></t:dgCol>
        <t:dgCol title="插座数" field="socketcount" width="130"></t:dgCol>
        <t:dgCol title="实际用电量" field="electric_quantity" width="130"></t:dgCol>
        <t:dgCol title="节省电量" field="saveElectricQuantity" width="130"></t:dgCol>
        <t:dgCol title="节省电费" field="saveElectricityFees" width="130"></t:dgCol>
        <t:dgCol title="节省率" field="saveElectricityRate" width="130"></t:dgCol>
    </t:datagrid>
</div>
