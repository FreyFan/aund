<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!-- context path -->
<t:base type="jquery"></t:base>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/highcharts-3d.js"></script>
<script type="text/javascript" src="plug-in/Highcharts-4.0.1/js/modules/exporting.src.js"></script>


<script type="text/javascript">
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'pie',
            options3d: {
				enabled: true,
                alpha: 45
            }
        },
        title: {
            text: 'Contents of Highsoft\'s weekly fruit delivery'
        },
        subtitle: {
            text: '3D donut in Highcharts'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Delivered amount',
            data: [
                ['Bananas', 8],
                ['Kiwi', 3],
                ['Mixed nuts', 1],
                ['Oranges', 6],
                ['Apples', 8],
                ['Pears', 4], 
                ['Clementines', 4],
                ['Reddish (bag)', 1],
                ['Grapes (bunch)', 1]
            ]
        }]
    });
});
</script>

<div id="container" style="min-width: 310px; max-width: 400px; height: 400px; margin: 0 auto"></div>

</body>