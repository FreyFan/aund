<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery"></t:base>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts-more.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/modules/data.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/modules/exporting.src.js"></script>


<script type="text/javascript">
$(function () {
    
    // Parse the data from an inline table using the Highcharts Data plugin
    $('#container').highcharts({
    	data: {
	    	table: 'freq',
	    	startRow: 1,
	    	endRow: 17,
	    	endColumn: 7
	    },
	    
	    chart: {
	        polar: true,
	        type: 'column'
	    },
	    
	    title: {
	        text: 'Wind rose for South Shore Met Station, Oregon'
	    },
	    
	    subtitle: {
	    	text: 'Source: or.water.usgs.gov'
	    },
	    
	    pane: {
	    	size: '85%'
	    },
	    
	    legend: {
	    	reversed: true,
	    	align: 'right',
	    	verticalAlign: 'top',
	    	y: 100,
	    	layout: 'vertical'
	    },
	    
	    xAxis: {
	    	tickmarkPlacement: 'on'
	    },
	        
	    yAxis: {
	        min: 0,
	        endOnTick: false,
	        showLastLabel: true,
	        title: {
	        	text: 'Frequency (%)'
	        },
	        labels: {
	        	formatter: function () {
	        		return this.value + '%';
	        	}
	        }
	    },
	    
	    tooltip: {
	    	valueSuffix: '%'
	    },
	        
	    plotOptions: {
	        series: {
	        	stacking: 'normal',
	        	shadow: false,
	        	groupPadding: 0,
	        	pointPlacement: 'on'
	        }
	    }
	});
});
</script>

<div id="container" style="min-width: 310px; max-width: 400px; height: 400px; margin: 0 auto"></div>

</body>