$(".time-confirm").click(function(){
    var time = $(".time-input").val();
    if(time==""){return false;}
    var timeblock = time.split("-");
    var year = Number(timeblock[0]);
    var month = Number(timeblock[1]);
    //age
    var data = new FormData();
    data.append("year",year);
    data.append("month",month);
    $.ajax({
		data: data,
		type: "POST",
		url: "statisticjsoncinema",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="empty"){
				filmAttendenceChartsEmp();
				typeAttendenceChartsEmp();
				hallAttendenceChartsEmp();
				$.scojs_message('no record!', $.scojs_message.TYPE_ERROR);
			}else{
				var info = eval('('+data+')');
				filmAttendenceCharts(info.film_x,info.film_y);
				typeAttendenceCharts(info.type_x,info.type_y);
				hallAttendenceCharts(info.hall_x,info.hall_y);
			}
		},
		error:function(){
			// $.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});


});
