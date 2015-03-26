
function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "vip_record",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".record-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".record-tbody .page-symbol").html());
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".record-tbody .page-symbol").html());
	if(page>0){
		queryPage(page-1);
	}
});
$(document).ready(function(){
	queryPage(0);
});