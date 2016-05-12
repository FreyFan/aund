<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery,easyui"></t:base>
<script type="text/javascript" src="plug-in/Highcharts-2.2.5/js/highcharts.src.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-2.2.5/js/modules/exporting.src.js"></script>

<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=line",
				success : function(jsondata) {
					data = eval(jsondata);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerline',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.line.chart"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							shadow: false,
							percentageDecimals : 1,
							formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{  
			                filename:'pie',  
			                 url:'${ctxPath}/reportDemoController.do?export'  
			            },  
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' + Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>


<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=column",
				success : function(jsondata) {
					
					data = eval(jsondata);
					console.log(data);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerCol',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.histogram"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							 percentageDecimals : 1,
							 formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{ 
			                filename:'column',  
			                url:'${ctxPath}/reportDemoController.do?export'//
			            },
						plotOptions : {
							column : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' +Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>


<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=pie",
				success : function(jsondata) {
					data = eval(jsondata);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerPie',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.pie.chart"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							shadow: false,
							percentageDecimals : 1,
							formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{  
			                filename:'pie',  
			                 url:'${ctxPath}/reportDemoController.do?export'  
			            },  
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' + Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=pie",
				success : function(jsondata) {
					data = eval(jsondata);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerPie1',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.pie.chart"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							shadow: false,
							percentageDecimals : 1,
							formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{  
			                filename:'pie',  
			                 url:'${ctxPath}/reportDemoController.do?export'  
			            },  
						plotOptions : {
							pie : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' + Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=column",
				success : function(jsondata) {
					
					data = eval(jsondata);
					console.log(data);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerCol1',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.histogram"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							 percentageDecimals : 1,
							 formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{ 
			                filename:'column',  
			                url:'${ctxPath}/reportDemoController.do?export'//
			            },
						plotOptions : {
							column : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' +Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			var chart;
			$.ajax({
				type : "POST",
				url : "reportDemoController.do?studentCount&reportType=column",
				success : function(jsondata) {
					
					data = eval(jsondata);
					console.log(data);
					chart = new Highcharts.Chart({
						chart : {
							renderTo : 'containerCol2',
							plotBackgroundColor : null,
							plotBorderWidth : null,
							plotShadow : false
						},
						title : {
							text : '停电时户数分析-<b><t:mutiLang langKey="common.histogram"/></b>'
						},
						xAxis : {
							categories : ['2014-11', '2014-12', '2015-01', '2015-02', '2015-03']
						},
						tooltip : {
							 percentageDecimals : 1,
							 formatter: function() {
            					return  '<b>'+this.point.name + '</b>:' +  Highcharts.numberFormat(this.percentage, 1) +'%';
         					}

						},
						exporting:{ 
			                filename:'column',  
			                url:'${ctxPath}/reportDemoController.do?export'//
			            },
						plotOptions : {
							column : {
								allowPointSelect : true,
								cursor : 'pointer',
								showInLegend : true,
								dataLabels : {
									enabled : true,
									color : '#000000',
									connectorColor : '#000000',
									formatter : function() {
										return '<b>' + this.point.name + '</b>: ' +Highcharts.numberFormat(this.percentage, 1)+"%";
									}
								}
							}
						},
						series : data
					});
				}
			});
		});
	});
</script>

<span id="containerline" style="float: left; width: 30%; height: 50%"></span>
<span id="containerCol" style="float: left; width: 38%; height: 50%"></span>
<span id="containerPie" style="width: 30%; height: 50%"></span>
<span id="containerPie1" style="float: left; width: 30%; height: 50%"></span>
<span id="containerCol1" style="float: left; width: 38%; height: 50%"></span>
<span id="containerCol2" style="float: left; width: 30%; height: 50%"></span>


<!-- <div style="width: 98%; height: 38%"> -->
<!-- 	<t:datagrid name="studentStatisticList" title="停电时户数统计" actionUrl="reportDemoController.do?listAllStatisticByJdbc" idField="id" fit="true"> -->
<!-- 		<t:dgCol title="common.code" field="id" hidden="true"></t:dgCol> -->
<!-- 		<t:dgCol title="统计月份" field="classname" width="130"></t:dgCol> -->
<!-- 		<t:dgCol title="停电时户数（*10）" field="personcount" width="130"></t:dgCol> -->
<!-- 		<t:dgCol title="common.proportion" field="rate" width="130"></t:dgCol> -->
<!-- 	</t:datagrid> -->
<!-- <span id="containerline" style="float: left; width: 30%; height: 60%"></span> -->
<!-- <span id="containerPie1" style="float: left; width: 38%; height: 60%"></span> -->
</div>