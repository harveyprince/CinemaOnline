$("select.sex-input").select2();

$(".btn-modify").click(function(){
	$(this).hide();
	$(".btn-save").show();
	$(".info-box .row-content").each(function(){
		$(this).show().css('display','inline');
		$(this).prev().hide();
		$(this).find("input").val($(this).prev().html());
		$(this).children("input").val($(this).prev().html());
		// some bugs may shown here
		$(this).children("select.sex-input").val($(this).prev().attr('value')).trigger("change");
	});
});

$(".btn-save").click(function(){
	var action = $("#info-form").attr("action");
	if(isFormValid($("#info-form"))){
		var data = new FormData();
		data = getFormData($("#info-form"),data);
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
	}
});