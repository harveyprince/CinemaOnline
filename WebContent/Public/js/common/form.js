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