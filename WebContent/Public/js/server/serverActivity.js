selectInitial($("select.plan-input"),planslist);
$("select.plan-input").select2();

$(".film-edit-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalEdit");

	var planIdList = $("select.plan-input").val();

	
});