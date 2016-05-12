function initData(){
	/*
	 * add by Frey.Fan 
	 * description : init socket analyze data 
	 * actionUrl : zzSmartsocketController.do?getSocketAnalyze
	 * */
	$.ajax({
		url:"zzSmartsoketHisController.do?getSocketAnalyze",
		type:"post",
		data:"",
		success:function(data){
			var data = $.parseJSON(data);
			if (data.success) {
				var d = data.attributes;
				var totalElectricQuantity = d.totalElectricQuantity;
				var totalElectricityFees = d.totalElectricityFees;
				var saveElectricQuantity = d.saveElectricQuantity;
				var saveElectricityFees = d.saveElectricityFees;
				var n_totalElectricQuantity = d.n_totalElectricQuantity;
				var n_totalElectricityFees = d.n_totalElectricityFees;
				var saveElectricityRate = d.saveElectricityRate;
				document.getElementById('totalElectricQuantity').innerHTML = totalElectricQuantity;
				document.getElementById('totalElectricityFees').innerHTML = totalElectricityFees;
				document.getElementById('saveElectricQuantity').innerHTML = saveElectricQuantity;
				document.getElementById('saveElectricityFees').innerHTML = saveElectricityFees;
				document.getElementById('n_totalElectricQuantity').innerHTML = n_totalElectricQuantity;
				document.getElementById('n_totalElectricityFees').innerHTML = n_totalElectricityFees;
				document.getElementById('saveElectricityRate').innerHTML = saveElectricityRate;
			}else{
			}
		},
		error:function(e){
			alert("出错了哦");
		}
	});
}
function initSokectReport(){
	initReport();
	initTimePicker();
}
function refresh (){
	var i = 0;
	setInterval(initReport(),10000);
}
function initReport(){
	var domain = document.getElementById("echart");
	var myChart = echarts.init(domain);
	var startDate =$('#startDate').datebox('getValue');
	var endDate = $('#endDate').datebox('getValue');
	// 过渡---------------------
	myChart.showLoading({
		text: '正在努力的读取数据中...',    //loading话术
	});
	$.ajax({
		url:"zzSmartsoketHisController.do?hisReport&startDate="+startDate+"&endDate="+endDate,
		type:"post",
		data:"",
		success:function(data){
			var data = $.parseJSON(data);
			if (data.success) {
				var d = data.attributes;
				var option = d.option;
				var optionJsonOV = jQuery.parseJSON(option);
				myChart.setOption(optionJsonOV);
			}else{
			}
		}
	});
	myChart.hideLoading();
}

function searchHis(){
	var startDate =$('#startDate').datebox('getValue');
	var endDate = $('#endDate').datebox('getValue');
	initReport();
	$.ajax({
		url:"zzSmartsoketHisController.do?querySocketAnalyze&startDate="+startDate+"&endDate="+endDate,
		type:"post",
		data:"",
		success:function(data){
			var data = $.parseJSON(data);
			if (data.success) {
				var d = data.attributes;
				var totalElectricQuantity = d.totalElectricQuantity;
				var totalElectricityFees = d.totalElectricityFees;
				var saveElectricQuantity = d.saveElectricQuantity;
				var saveElectricityFees = d.saveElectricityFees;
				var n_totalElectricQuantity = d.n_totalElectricQuantity;
				var n_totalElectricityFees = d.n_totalElectricityFees;
				var saveElectricityRate = d.saveElectricityRate;
				document.getElementById('totalElectricQuantity').innerHTML = totalElectricQuantity;
				document.getElementById('totalElectricityFees').innerHTML = totalElectricityFees;
				document.getElementById('saveElectricQuantity').innerHTML = saveElectricQuantity;
				document.getElementById('saveElectricityFees').innerHTML = saveElectricityFees;
				document.getElementById('n_totalElectricQuantity').innerHTML = n_totalElectricQuantity;
				document.getElementById('n_totalElectricityFees').innerHTML = n_totalElectricityFees;
				document.getElementById('saveElectricityRate').innerHTML = saveElectricityRate;
			}else{
			}
		},
		error:function(e){
			alert("出错了哦");
		}
	});
}

function initTimePicker(){
	//设置时间
	var curr_time = new Date();
	$("#startDate").datebox("setValue",GetDateStr(-1));
	$("#endDate").datebox("setValue",GetDateStr(-1));
}

function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}

function GetDateStr(AddDayCount) {
	var dd = new Date();
	dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
	var y = dd.getFullYear();
	var m = dd.getMonth()+1;//获取当前月份的日期
	var d = dd.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}