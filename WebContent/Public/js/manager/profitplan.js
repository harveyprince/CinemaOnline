/*
	放置在获取到数据之后
	$('.right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
	$('.close-panel-bt').click(function() {
		$.panelslider.close();
	});
*/
var filmlist;
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
				$('.right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
				$('.close-panel-bt').click(function() {
					$.panelslider.close();
				});
				$(".profit-dispatch-button").click(function(){
					var planId = $(this).attr("planId");
					
				});
				$(".right-panel-link").click(function(){
					$(".profit-dispatch-submit").show();
					$.post("getPlanDispatch",{
						planId:$(this).attr("planId")
					},function(data){
						if(data!=null){
							var data = eval("("+data+")");
							profitDispatchData = data.data;
							filmlist = data.film;
							profitDispatchCharts(profitDispatchData);
						}
					});
				});
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
	var action = $(".dispatched-profit-plan-list").attr("action");
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
				$(".dispatched-profit-plan-list").html(data);
				$('.right-panel-link-dispatch').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
				$('.close-panel-bt').click(function() {
					$.panelslider.close();
				});
				$(".profit-dispatch-button").click(function(){
					var planId = $(this).attr("planId");
					
				});
				
				$(".right-panel-link-dispatch").click(function(){
					$(".profit-dispatch-submit").hide();
					$.post("getPlanDispatch",{
						planId:$(this).attr("planId")
					},function(data){
						if(data!=null){
							var data = eval("("+data+")");
							profitDispatchData = data.data;
							filmlist = data.film;
							profitDispatchCharts(profitDispatchData,false);
						}
					});
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

$(".profit-dispatch-submit").click(function(){
	console.log(profitDispatchData);
	var action = "submitPlanDispatch";
	var data = new FormData();
	for(var idx in profitDispatchData){
		data.append("filmProfitPercentlist["+idx+"].filmId",filmlist[idx][1]);
		data.append("filmProfitPercentlist["+idx+"].profitPercent",profitDispatchData[idx].y);
	}
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
});