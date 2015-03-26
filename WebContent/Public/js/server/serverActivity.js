selectInitial($("select.plan-input"),planslist);
$("select.plan-input").select2();
function eventInit(){
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

try{
$(".act-publish-button").click(function(){
	var $button = $(this);
	var actid = $(this).parent().siblings(".activityId").html();
	var action = $(this).attr("target");
	var data = new FormData();
	data.append("activityid",actid);
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
}
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

function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "server_activity",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".film-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".film-tbody .page-symbol").html());
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".film-tbody .page-symbol").html());
	if(page>0){
		queryPage(page-1);
	}
});
$(document).ready(function(){
	queryPage(0);
});

function endedqueryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "server_ended_activity",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".ended-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.ended-next").click(function(){
	var page = Number($(".ended-tbody .page-symbol").html());
	endedqueryPage(page+1);
});
$(".btn.ended-previous").click(function(){
	var page = Number($(".ended-tbody .page-symbol").html());
	if(page>0){
		endedqueryPage(page-1);
	}
});
$(document).ready(function(){
	endedqueryPage(0);
});