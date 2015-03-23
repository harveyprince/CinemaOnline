$(".answer").click(function(){
	$(this).addClass("active");
	$(this).siblings(".active").removeClass("active");
});

$(".participate-button").click(function(){
	$modal = $("#modalParticipate");
	$sibBase = $(this).parent();
	$modal.find(".activityid-input").html($sibBase.siblings(".activityId").html());
	$modal.find(".title-panel").html($sibBase.siblings(".activityName").html());
	$answerPanel = $modal.find(".answers-panel");

	$answerPanel.html("");
	$sibBase.siblings(".activity-answers").children("li").each(function(){
		$("<div class='answer'>").attr('value',$(this).attr('value')).html($(this).html()).click(function(){
			$(this).addClass("active");
			$(this).siblings(".active").removeClass("active");
		}).appendTo($answerPanel);
	});
});

$(".participated-button").click(function(){
	var $modalshow = $("#modalParticipated");
	var $sibBaseshow = $(this).parent();
	$modalshow.find(".activityid-input").html($sibBaseshow.siblings(".activityId").html());
	$modalshow.find(".title-panel").html($sibBaseshow.siblings(".activityName").html());
	var $answerPanelshow = $modalshow.find(".answers-panel");

	$answerPanelshow.html("");
	$sibBaseshow.siblings(".activity-answers").children("li").each(function(){
		if($(this).attr("choosen")=="choosen"){
			$("<div class='answer active'>").attr('value',$(this).attr('value')).html($(this).html()).appendTo($answerPanelshow);
		}else{
			$("<div class='answer'>").attr('value',$(this).attr('value')).html($(this).html()).appendTo($answerPanelshow);
		}
	});
});

$("#modalParticipate").find(".save-button").click(function(){
	var action = $(this).attr("target");
	var data = new FormData();
	$modal = $("#modalParticipate")
	data.append("activityid",$modal.find(".activityid-input").html());
	if($modal.find(".answers-panel .answer.active").length<=0){
		$.scojs_message('you did not choose!', $.scojs_message.TYPE_ERROR);
	}else{
		data.append("answerid",$modal.find(".answers-panel .answer.active").attr("value"));
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					$.scojs_message(data, $.scojs_message.TYPE_OK);
					$("#modalParticipate").modal("hide");
					setTimeout(function(){window.location.reload();},500);
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