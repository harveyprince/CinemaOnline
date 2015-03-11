$(".vip-search .form-control").focus(function(){
	$(this).parent().addClass("focus");
});
$(".vip-search .form-control").blur(function(){
	$(this).parent().removeClass("focus");
});