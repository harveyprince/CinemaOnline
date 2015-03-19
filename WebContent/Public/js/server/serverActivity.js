selectInitial($("select.plan-input"),planslist);
$("select.plan-input").select2();

$(".film-edit-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalEdit");
	//plan
	var planarray = [];
	$row.children(".activity-plans").children("li").each(function(){
		planarray.push($(this).attr("value"));
	});
	$modal.find("select.plan-input").val(planarray).trigger("change");
	//answer
	$modal.find(".answers-panel").html("");
	$row.children(".activity-answers").children("li").each(function(){
		var row = $("<div class='answer-row'>").append($("<div value>").html($(this).html())).append($("<i class='fa fa-times answer-close'>")).click(function(){
			$(this).remove();
			answerCount();
		});
		$modal.find(".answers-panel").append(row);
		answerCount();
	});
	//title
	var title = $row.children(".activityName").html();
	$modal.find(".title-input").val(title);
	//id
	var id = $row.children(".activityId").html();
	$modal.find(".id-input").val(id);
});
function answerCount(){
	$("#modalEdit .answer-row").each(function(idx){
		$(this).children("div[value]").attr("value",idx);
	});
	$("#modalAdd .answer-row").each(function(idx){
		$(this).children("div[value]").attr("value",idx);
	});
}
$(".answer-input").keydown(function(event){
	if(event.which == 13){
		$(this).siblings(".add-answer-button").click();
	}
});
$(".add-answer-button").click(function(){
	var answercontent = $(this).siblings(".answer-input").val();
	if(answercontent.length>0){
		$(this).siblings(".answer-input").val("");
		var row = $("<div class='answer-row'>").append($("<div value>").html(answercontent)).append($("<i class='fa fa-times answer-close'>")).click(function(){
			$(this).remove();
			answerCount();
		});
		$(".answers-panel").append(row);
		answerCount();
	}else{
		$(this).siblings(".answer-input").focus();
	}
});
$(".answer-row").click(function(){
	$(this).remove();
	answerCount();
});

$("#modalEdit .save-button").click(function(){
	var $form = $("#activityedit-form");
	var data = new FormData();
	data = constructFormData($form);
	data.append("hv_activity.activityid",$form.find(".id-input").val());
	var action = $form.attr("action");
	$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					//plan
					var planarray = $modal.find("select.plan-input").val();
					$row.children(".activity-plans").html("");
					for(var temp in planarray){
						var singleplan = planarray[temp];
						$row.children(".activity-plans").append($("<li>").attr("value",singleplan).html(singleplan));
					}
					//answer
					$row.children(".activity-answers").html("");
					$modal.find(".answer-row").each(function(){
						var $answerval = $(this).children("div[value]");
						$row.children(".activity-answers").append($("<li>").attr("value",$answerval.attr("value")).html($answerval.html()));
					});
					//title
					var title = $modal.find(".title-input").val();
					$row.children(".activityName").html(title);
					
					$.scojs_message('success', $.scojs_message.TYPE_OK);
					$("#modalEdit").modal("hide");
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
	
});

$("#modalAdd .save-button").click(function(){
	var $form = $("#activityadd-form");
	var data = new FormData();
	data = constructFormData($form);
	var action = $form.attr("action");
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
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
});

function constructFormData($form){
	var data = new FormData();
	data.append("hv_activity.title",$form.find(".title-input").val());
	var planlist = $form.find("select.plan-input").val();
	for(var idx in planlist){
		data.append("hv_activity.planidlist["+idx+"]",planlist[idx]);
	}
	$form.find(".answer-row div[value]").each(function(idx){
		data.append("hv_activity.answerlistList["+idx+"].answerId",$(this).attr("value"));
		data.append("hv_activity.answerlistList["+idx+"].answerContent",$(this).html());
	});
	return data;
}