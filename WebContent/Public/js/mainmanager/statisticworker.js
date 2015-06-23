$(document).ready(function(){
	var data = new FormData();
	data.append("year",Number(2015));
	data.append("month",Number(6));
	$.ajax({
		data: data,
		type: "POST",
		url: "statisticjsoncinema",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				profitAttendenceChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				profitAttendenceCharts(info.profit_x,info.profit_y);
				console.log(info.profit_x);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
});