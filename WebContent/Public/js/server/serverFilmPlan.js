selectInitial($("select.film-input"),filmslist);
$("select.film-input").select2();
selectInitial($("select.hall-input"),hallslist);
$("select.hall-input").select2();

$(".film-edit-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalEdit");
	// planid-input
	$planIdInput = $modal.find(".planid-input");
	$plansource = $row.children(".planId");
	var planId = $plansource.html();
	$planIdInput.val(planId);
	// film-input
	$filmInput = $modal.find(".film-input");
	$filmsource = $row.children(".filmName");
	var filmId = $filmsource.attr("filmId");
	$filmInput.val(filmId).trigger("change");
	// hall-input
	$hallInput = $modal.find(".hall-input");
	$hallsource = $row.children(".hallNo");
	var hallId = $hallsource.attr("hallId");
	$hallInput.val(hallId).trigger("change");
	// seat-sum
	$seatInput = $modal.find(".seat-input");
	$seatsource = $row.children(".seatSum");
	var seat = $seatsource.html();
	$seatInput.val(seat);
	// price
	$priceInput = $modal.find(".price-input");
	$pricesource = $row.children(".price");
	var price = $pricesource.html();
	$priceInput.val(price);
	// beginTime
	$beginTimeInput = $modal.find(".beginTime-input");
	$beginsource = $row.children(".beginTime");
	var begintime = $beginsource.attr("date-time");
	$beginTimeInput.val(begintime);
	// endTime
	$endTimeInput = $modal.find(".endTime-input");
	$endsource = $row.children(".endTime");
	var endtime = $endsource.attr("date-time");
	$endTimeInput.val(endtime);
});
$("#modalEdit").find(".save-button").click(function(){
	var action = $("#planedit-form").attr("action");
	if(isFormValid($("#planedit-form"))){
		var data = new FormData();
		data = getFormData($("#planedit-form"),data);
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					//
					$modal = $("#modalEdit");
					// film-input
					$filmInput = $modal.find("select.film-input");
					$filmsource.attr("filmId",$filmInput.val());
					$filmsource.html(findValueByKey(filmslist,$filmInput.val()));
					// hall-input
					$hallInput = $modal.find("select.hall-input");
					$hallsource.attr("hallId",$hallInput.val());
					$hallsource.html(findValueByKey(hallslist,$hallInput.val()));
					// seat-sum
					$seatInput = $modal.find(".seat-input");
					$seatsource.html($seatInput.val());
					// price
					$priceInput = $modal.find(".price-input");
					$pricesource.html($priceInput.val());
					// beginTime
					$beginTimeInput = $modal.find(".beginTime-input");
					$beginsource.attr("date-time",$beginTimeInput.val());
					$beginsource.html($beginTimeInput.val().split("T")[1]);
					// endTime
					$endTimeInput = $modal.find(".endTime-input");
					$endsource.attr("date-time",$endTimeInput.val());
					$endsource.html($endTimeInput.val().split("T")[1]);

					$.scojs_message('success', $.scojs_message.TYPE_OK);
					$modal.modal("hide");
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
			});
			}

});

$("#modalAdd").find(".save-button").click(function(){
	var action = $("#planadd-form").attr("action");
	if(isFormValid($("#planadd-form"))){
		var data = new FormData();
		data = getFormData($("#planadd-form"),data);
		$.ajax({
		data: data,
		type: "POST",
		url: action,
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="success"){
				$.scojs_message('success', $.scojs_message.TYPE_OK);
				$("#modalAdd").modal("hide");
				setTimeout(function(){window.location.reload()},500);
			}else{
				$.scojs_message(data, $.scojs_message.TYPE_ERROR);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
	}
});

try{
	$(".submitforcheck-button").click(function(){
		var $button = $(this);
		var planid = $(this).parent().siblings(".planId").html();
		var action = $(this).attr("target");
		var data = new FormData();
		data.append("planid",planid);
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					$.scojs_message('success', $.scojs_message.TYPE_OK);
					setTimeout(function(){window.location.reload()},500);
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
	});
}catch(e){}

$(".hall-input").on("select2-selected", function (e) { 
	var i = e.val+"";
	var seatsum = hall_seat[i];
	var $input = $(this).parents(".row-line").next().find(".seat-input");
	$input.val(seatsum);
	$input.attr("max",seatsum);
});