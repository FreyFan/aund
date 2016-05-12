var timeTicket ;
var timeTicketCache;
var oldHour = new Date().getHours();
function changeChartForHour(){
	var newTime = new Date();
	var newHour = newTime.getHours();
	var newMnite = newTime.getMinutes();
	//document.write(newMnite);
	if(newHour !=  oldHour && newMnite != 0){
		oldHour = newHour;
		initSokectReport();
	}
}
function initSokectReport(){

	var domain = document.getElementById("echart");
	var myChart = echarts.init(domain);
	// 过渡---------------------
	myChart.showLoading({
		text: '正在努力的读取数据中...',    //loading话术
	});
	$.ajax({
		url:"zzSmartsocketController.do?getOptionIntime",
		type:"post",
		data:"",
		/*async:false,
		beforeSend:function() {
			var h = document.body.clientHeight;
			$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:h}).appendTo("body");
			$("<div class=\"datagrid-mask-msg\"></div>").html("loading，wait...").appendTo("body").css({display:"block",
				left:($(document.body).outerWidth(true) - 190) / 2,
				top:(h - 45) / 2});

		},*/
		complete:function(data) {
			$('.datagrid-mask-msg').remove();
			$('.datagrid-mask').remove();
		},
		success:function(data){
			var data = $.parseJSON(data);
			if (data.success) {
				var d = data.attributes;
				var option = d.option;
				var optionJsonOV = jQuery.parseJSON(option);
				myChart.setOption(optionJsonOV);
				var series = myChart.getSeries();
				var currentData = series[0].data;
				var targetValue = currentData[currentData.length - 1];
				document.getElementById('totalKw').innerHTML = targetValue;
			}else{
			}
		}
	});
	myChart.hideLoading();



	clearInterval(timeTicket);
	timeTicket = window.setInterval(function (){

		var series = myChart.getSeries();
		var currentData = series[0].data;
		var dataLength = currentData == null?0:currentData.length;

		$.ajax({
			url:"zzSmartsocketController.do?getNewReportData",
			type:"post",
			data:"",
			/*async:false,
			beforeSend:function() {
				var h = document.body.clientHeight;
				$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:h}).appendTo("body");
				$("<div class=\"datagrid-mask-msg\"></div>").html("loading，wait...").appendTo("body").css({display:"block",
					left:($(document.body).outerWidth(true) - 190) / 2,
					top:(h - 45) / 2});

			},*/
			complete:function(data) {
				$('.datagrid-mask-msg').remove();
				$('.datagrid-mask').remove();
			},
			success:function(data){
				var data = $.parseJSON(data);
				if (data.success) {
					var d = data.attributes;
					var option = d.data;

					if (!(option != null && option.length > dataLength)) {
					} else {

						var targetValue = option[option.length - 1];
						document.getElementById('totalKw').innerHTML = targetValue;
						myChart.addData([[0, // 系列索引
									targetValue, // 新增数据
									false, // 新增数据是否从队列头部插入
									true // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
								]]
						);
					}
				}else{
				}
			}
		});

	},2000,1000);
}

function initData (){

	clearInterval(timeTicketCache);
	timeTicketCache = window.setInterval(function (){
		initDataFromCache();

	},2000,1000);
}
function initDataFromCache(){
	/*
	 * add by Frey.Fan 
	 * description : init socket analyze data 
	 * actionUrl : zzSmartsocketController.do?getSocketAnalyze
	 * */
	$.ajax({
		url:"zzSmartsocketController.do?getSocketAnalyzeFromCache",
		type:"post",
		data:"",
		/*async:false,
		beforeSend:function() {
			var h = document.body.clientHeight;
			$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:h}).appendTo("body");
			$("<div class=\"datagrid-mask-msg\"></div>").html("loading，wait...").appendTo("body").css({display:"block",
				left:($(document.body).outerWidth(true) - 190) / 2,
				top:(h - 45) / 2});

		},*/
		complete:function(data) {
			$('.datagrid-mask-msg').remove();
			$('.datagrid-mask').remove();
		},
		success:function(data){
			var data = $.parseJSON(data);
			if (data.success) {
				var d = data.attributes;
				var socketTotalCount = d.socketTotalCount;
				var socketOnlineCount = d.socketOnlineCount;
				var socketOfflineCount = d.socketOfflineCount;
				var onlineRate = d.onlineRate;
				//var totalKw = d.totalKw;
				var lostCount = d.lostCount;
				document.getElementById('socketTotalCount').innerHTML = socketTotalCount;
				document.getElementById('socketOnlineCount').innerHTML = socketOnlineCount;
				document.getElementById('socketOfflineCount').innerHTML = socketOfflineCount;
				document.getElementById('onlineRate').innerHTML = onlineRate;
				//document.getElementById('totalKw').innerHTML = totalKw;
				document.getElementById('lostCount').innerHTML = lostCount;
			}else{
			}
		}
	});
}