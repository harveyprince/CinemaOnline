/*
	放置在获取到数据之后
	$('#right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
	$('.close-panel-bt').click(function() {
		$.panelslider.close();
	});
*/
$(document).ready(function(){
	var action = $(".profit-plan-list").attr("action");
	var data = new FormData();
	data.append("page",0);
	$.ajax({
		data: data,
		type: "POST",
		url: action,
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!=null){
				$(".profit-plan-list").html(data);
				$('#right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
				$('.close-panel-bt').click(function() {
					$.panelslider.close();
				});
				$(".profit-dispatch-button").click(function(){
					var planId = $(this).attr("planId");
					
				});
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
});
function getDataForProfitDispatch(){
	var action = "";
	var data = new FormData();
	var planId = $(".profit-dispatch-button").attr("planId");
	data.append("planId",planId);
	$.ajax({
		data: data,
		type: "POST",
		url: action,
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!=null){
				//
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}