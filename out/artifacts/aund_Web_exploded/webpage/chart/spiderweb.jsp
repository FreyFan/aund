<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery"></t:base> --%>
<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts-more.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/modules/exporting.js"></script>


<script type="text/javascript">
$(function () {

	$('#container').highcharts({
	            
	    chart: {
	        polar: true,
	        type: 'line'
	    },
	    
	    title: {
	        text: 'Budget vs spending',
	        x: -80
	    },
	    
	    pane: {
	    	size: '80%'
	    },
	    
	    xAxis: {
	        categories: ['Sales', 'Marketing', 'Development', 'Customer Support', 
	                'Information Technology', 'Administration'],
	        tickmarkPlacement: 'on',
	        lineWidth: 0
	    },
	        
	    yAxis: {
	        gridLineInterpolation: 'polygon',
	        lineWidth: 0,
	        min: 0
	    },
	    
	    tooltip: {
	    	shared: true,
	        pointFormat: '<span style="color:{series.color}">{series.name}: <b>${point.y:,.0f}</b><br/>'
	    },
	    
	    legend: {
	        align: 'right',
	        verticalAlign: 'top',
	        y: 70,
	        layout: 'vertical'
	    },
	    
	    series: [{
	        name: 'Allocated Budget',
	        data: [43000, 19000, 60000, 35000, 17000, 10000],
	        pointPlacement: 'on'
	    }, {
	        name: 'Actual Spending',
	        data: [50000, 39000, 42000, 31000, 26000, 14000],
	        pointPlacement: 'on'
	    }]
	
	});
});
</script>

<div id="container" style="min-width: 400px; max-width: 600px; height: 400px; margin: 0 auto"></div>

</body>