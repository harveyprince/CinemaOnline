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