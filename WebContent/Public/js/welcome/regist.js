$("select.sex-input").select2();
$("select.location-input").select2();
$(".password-tab").click(function(){
	return false;
});
$(".info-tab").click(function(){
	return false;
});
$(".result-tab").click(function(){
	return false;
});
$(".info-regist-button").click(function(){
//	$("#info-form").submit();
	if(isFormValid($("#info-form"))){
		$(".password-tab").tab("show");
	}
	
});
$(".password-confirm-input").blur(function(){
	if($(this).val()!=$(".password-input").val()){
		$.scojs_message('password should be the same', $.scojs_message.TYPE_ERROR);
		$(this).focus();
	}
});
$(".password-regist-button").click(function(){
//	$("#pass-form").submit();
	if($(".password-confirm-input").val()!=$(".password-input").val()){
		return false;
	}
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
					$(".result-tab").tab("show");
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

$(".result-regist-button").click(function(){
	window.location.href = "login";
});