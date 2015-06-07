$(document).ready(function(){
	$.ajax({
		type: "GET",
		url: "statisticjsonprofit",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				profitChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				profitCharts(info);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
});