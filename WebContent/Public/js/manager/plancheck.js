function eventInit(){
	$(".plan-judge-button").click(function(){
	var  planid = $(this).parent().siblings(".planId").html();
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
				if(data.indexOf("success")!=-1){
					$.scojs_message("success", $.scojs_message.TYPE_OK);
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
}

function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "manar_filmplan",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".filmplan-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".filmplan-tbody .page-symbol").html());
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".filmplan-tbody .page-symbol").html());
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
		url: "manar_old_filmplan",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".old-filmplan-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.old-next").click(function(){
	var page = Number($(".old-filmplan-tbody .page-symbol").html());
	endedqueryPage(page+1);
});
$(".btn.old-previous").click(function(){
	var page = Number($(".old-filmplan-tbody .page-symbol").html());
	if(page>0){
		endedqueryPage(page-1);
	}
});
$(document).ready(function(){
	endedqueryPage(0);
});