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
			//
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
		// $(".result-tab").click();
	}
});
function getFormData($which,formData){
	var data = formData;
	$which.find(".row-content input").each(function(){
		if($(this).attr('name')){
			data.append($(this).attr('name'),$(this).val());
		}
	});
	$which.find(".row-content select").each(function(){
		if($(this).attr('name')){
			data.append($(this).attr('name'),$(this).val());
		}
	});
	return data;
}
function isFormValid($which){
	var result = true;
	$which.find(".row-content").each(function(){
		var $temp = $(this).children();
		if($temp.attr("required")&&($temp.val()==""||$temp.val()==null)){
//			can not be empty
			$.scojs_message($temp.attr("name")+' can not be empty', $.scojs_message.TYPE_ERROR);
			result = false;
			return false;
		}
	});
	return result;
}