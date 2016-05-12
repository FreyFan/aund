<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery"></t:base>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts-more.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/modules/exporting.src.js"></script>


<script type="text/javascript">
	$(function() {
		$('#container').highcharts({
			chart : {
				polar : true
			},

			title : {
				text : 'Highcharts Polar Chart'
			},

			pane : {
				startAngle : 0,
				endAngle : 360
			},

			xAxis : {
				tickInterval : 45,
				min : 0,
				max : 360,
				labels : {
					formatter : function() {
						return this.value + '°';
					}
				}
			},

			yAxis : {
				min : 0
			},

			plotOptions : {
				series : {
					pointStart : 0,
					pointInterval : 45
				},
				column : {
					pointPadding : 0,
					groupPadding : 0
				}
			},

			series : [ {
				type : 'column',
				name : 'Column',
				data : [ 8, 7, 6, 5, 4, 3, 2, 1 ],
				pointPlacement : 'between'
			}, {
				type : 'line',
				name : 'Line',
				data : [ 1, 2, 3, 4, 5, 6, 7, 8 ]
			}, {
				type : 'area',
				name : 'Area',
				data : [ 1, 8, 2, 7, 3, 6, 4, 5 ]
			} ]
		});
	});
</script>

<div id="container" style="min-width: 310px; max-width: 400px; height: 400px; margin: 0 auto"></div>

</body>