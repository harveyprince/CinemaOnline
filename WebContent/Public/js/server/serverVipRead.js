$(".vip-search .form-control").focus(function(){
	$(this).parent().addClass("focus");
});
$(".vip-search .form-control").blur(function(){
	$(this).parent().removeClass("focus");
});
$(".vip-search-input").keydown(function(event){
	if(event.which == 13){
		if($(this).val()!=""){
			window.location.href=$(this).attr("target")+"?searchkey="+$(this).val();
		}
		
	}
});