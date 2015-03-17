
$(".pay-button").click(function(){
	var action = $("#pay-form").attr("action");
	if(isFormValid($("#pay-form"))){
		var data = new FormData();
		data = getFormData($("#pay-form"),data);
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
					$("#modalMoney").modal("hide");
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
