$("select.sex-input").select2();
$(".info-regist-button").click(function(){
//	$("#info-form").submit();
	if(isFormValid($("#info-form"))){
		$(".password-tab").click();
	}
	
});
$(".password-regist-button").click(function(){
//	$("#pass-form").submit();
	var action = $("#pass-form").attr("action");
	if(isFormValid($("#pass-form"))){
		var data = new FormData();
		data = getFormData($("#info-form"),data);
		data = getFormData($("#pass-form"),data);
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data.indexOf("success")>=0){
					var list = data.split("#");
					$(".regist-result-label").html(list[1]);
					$(".result-tab").click();
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
		// $(".result-tab").click();
	}
});
