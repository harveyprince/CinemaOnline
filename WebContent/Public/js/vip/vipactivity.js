$(".answer").click(function(){
	$(this).addClass("active");
	$(this).siblings(".active").removeClass("active");
});

$(".participate-button").click(function(){
	$modal = $("#modalParticipate");
	$sibBase = $(this).parent();
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