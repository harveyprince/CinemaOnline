$("select.sex-input").select2();
$(".info-regist-button").click(function(){
//	$("#info-form").submit();
	isFormValid($("#info-form"));
//	$(".password-tab").click();
});
$(".password-regist-button").click(function(){
//	$("#pass-form").submit();
//	$(".result-tab").click();
});
function isFormValid(which){
	$(which).find(".row-content").each(function(){
		var $temp = $(this).children();
		if($temp.attr("required")&&($temp.val()==""||$temp.val()==null)){
//			can not be empty
			$.scojs_message($temp.attr("name")+' can not be empty', $.scojs_message.TYPE_ERROR);
		}
	});
}