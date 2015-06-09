selectInitial($("select.film-input"),filmslist);
$("select").select2();
$('#right-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
$('#profitplan-panel-link').panelslider({side: 'right', clickClose: true, duration: 200, easingOpen: 'easeInBack', easingClose: 'easeOutBack'});
$('.close-panel-bt').click(function() {
	$.panelslider.close();
});
$(".add-profitplan").click(function(){
	var action = $("#profitplan-form").attr("action");
	if(isFormValid($("#profitplan-form"))){
		var data = new FormData();
		data = getFormData($("#profitplan-form"),data);
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					$.scojs_message('success', $.scojs_message.TYPE_OK);
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