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
<script src="webpage/platform/demo/base/report/SmartSocketAnalyze.js"></script>
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
.about{
	height: 20%;
	width: 98%;
}
.content{
		height:20%;overflow:hidden;border:solid 1px;
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
		window.setInterval("changeChartForHour()",10000,10000);

	});
</script>
<div style="height: 10px"></div>
<div class="clearfix" >
	<ul class="cALump238">
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">插座总数</p>
							<a href="zzSmartsocketController.do?zzSmartsocket"><p id="socketTotalCount" class="cAPoolFont25 cALumpLableText cAColorOge" ></p></a>
						</li>
<!-- 						<li class="cABorder marginRight20"> -->
<!-- 							<span class="cALumpLiB1 fl"> -->
<!-- 								<p class="fontSize14 marginLeft20 cAFontWeightP">插座在线数量</p> -->
<!-- 								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="socketOnlineCount"></p> -->
<!-- 							</span> -->
<!-- 							<span class="cALumpLiB2 fl"> -->
<!-- 								<p class="fontSize14 cAFontWeightP textCenter">在线率</p> -->
<!-- 								<p class="cAPoolFont25 cALumpLableText cAColorOge" id="onlineRate"><span class="fontSize16"></span></p> -->
<!-- 							</span> -->
<!-- 						</li> -->
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">插座连通数量</p>
							<a href="zzSmartsocketController.do?zzSmartsocket_status_Y">
								<p id="socketOnlineCount" class="cAPoolFont25 cALumpLableText cAColorOge"></p>
							</a>
						</li>
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">插座关闭数量</p>
							<a href="zzSmartsocketController.do?zzSmartsocket_status_N">
								<p id="socketOfflineCount" class="cAPoolFont25 cALumpLableText cAColorOge"></p>
							</a>
						</li>
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">插座失联数量</p>
							<a href="zzSmartsocketController.do?zzSmartsocket_status_NS">
								<p id="lostCount" class="cAPoolFont25 cALumpLableText cAColorOge"></p>
							</a>
						</li>
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">在线率</p>
							<p class="cAPoolFont25 cALumpLableText cAColorOge" id="onlineRate"></p>
						</li>
<!-- 						<li class="cABorder marginRight20"> -->
<!-- 							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">失联</p> -->
<!-- 							<p class="cAPoolFont25 cALumpLableText cAColorOge" id="lostCount"></p> -->
<!-- 							<p class="textRight marginRight10"> -->
<!-- 								<a class="red1 cursorD" href="javascript:openAlertor();"> -->
<!-- 									<i id="alertorIcoHert" class="glyphicon glyphicon-warning-sign cAColorOge fontSize14" title="报警详情"></i> -->
<!-- 								</a> -->
<!-- 							</p> -->
<!-- 						</li> -->
						<li class="cABorder marginRight45">
							<p class="fontSize14 marginTop10 marginLeft20 cAFontWeightP">当前总功率（W）</p>
							<p class="cAPoolFont25 cALumpLableText cAColorOge" id="totalKw"></p>
						</li>
					</ul>
</div>
<div style="height: 10px"></div>
<div id="echart" title="功率分析" ></div>
<div style="height: 10px"></div>
<div id="datadiv" >
    <t:datagrid name="studentStatisticList"  title="" width="100%" height="100%" actionUrl="zzSmartsocketController.do?listAllStatisticByJdbc" idField="id" fit="true">
        <t:dgCol title="部门" field="department" width="130"></t:dgCol>
        <t:dgCol title="插座数" field="socketcount" width="130"></t:dgCol>
        <t:dgCol title="在线量" field="onlinecount" width="130"></t:dgCol>
        <t:dgCol title="在线率" field="rate" width="130"></t:dgCol>
        <t:dgCol title="当前功率(KW)" field="monitorpower" width="130"></t:dgCol>
    </t:datagrid>
</div>
