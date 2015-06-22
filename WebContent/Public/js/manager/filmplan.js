$(".publish").click(function(){
	var data = new FormData();
	var $parent = $(this).parent().parent();
	var $film = $parent.find("th[filmId]");
	data.append("filmReleasePlan.filmId",$film.attr("filmId"));
	var $price = $parent.find(".price-input");
	data.append("filmReleasePlan.price",$price.val());
	var $halltimeslist = $parent.find(".times-input");
	$halltimeslist.each(function(idx){
		data.append("filmReleasePlan.playTimeslist["+idx+"]",$(this).val());
		data.append("filmReleasePlan.hallNolist["+idx+"]",$(this).parent().attr("hallId"));
	});
	var $date = $parent.find(".date-input");
	var datearray = $date.val().split("-");
	var datestamp = new Date(Number(datearray[0]),Number(datearray[1])-1,Number(datearray[2]));
	data.append("filmReleasePlan.beginTime",datestamp.getTime());
	var $timelength = $parent.find(".timeLength-input");
	data.append("filmReleasePlan.dayslength",$timelength.val());
	var action = "submitManagerFilmPlan";
	$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
			});
});

$(".number-input").change(function(){
	var $parent = $(this).parent().parent();
	/**
		盈利计算方式：
			盈利=【所有影厅的（座位数×票价-厅成本每小时×单次时长）×在该影厅播放次数】
	*/
	var profit = 0;
	// 票价
	var price = $parent.find(".price-input").val();
	// 总播放次数：单厅播放次数、上映天数
	var $halltimeslist = $parent.find(".times-input");
	$halltimeslist.each(function(idx){
		var $hall = $(this);
		//单厅播放次数
		var playtimes = $hall.val();
		//上映天数
		var releaselength = $parent.find(".timeLength-input").val();
		// 座位数
		var seats = $hall.parent().attr("seats");
		// 厅成本每小时
		var cost = $hall.parent().attr("cost");
		var filmcost = $parent.find("th[filmcost]").attr("filmcost");
		profit += (Number(seats)*Number(price)-Number(cost)*2)*(Number(playtimes)*Number(releaselength))-Number(filmcost);

	});
	$parent.find(".actual-profit").html(profit);
});