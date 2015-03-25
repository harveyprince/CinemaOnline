$(".time-confirm").click(function(){
    var year = $("select.year-input").val();
    var month = $("select.month-input").val();
    //age
    var data = new FormData();
    data.append("year",year);
    data.append("month",month);
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsonage",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				ageChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				ageCharts(info);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsonsex",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				sexChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				sexCharts(info);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsonlocation",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				locationChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				locationCharts(info);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsoncard",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				cardChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				cardCharts(info.card);
				$(".consume-show").html(info.consume);
				$(".participate-show").html(info.activity);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsoncinema",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				personChartsEmp();
				filmAttendenceChartsEmp();
				hallAttendenceChartsEmp();
				paywayChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				$(".person-month-show").html(info.personmonth);
				personCharts(info.personday_y);
				filmAttendenceCharts(info.film_x,info.film_y);
				hallAttendenceCharts(info.hall_x,info.hall_y);
				paywayCharts(info.payway);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});


});