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


function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	data.append("vipid",$(".vipid").html());
	$.ajax({
		data: data,
		type: "POST",
		url: "server_vip_record",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".record-tbody").html(data);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".record-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".record-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	if(page>0){
		queryPage(page-1);
	}
});
$(document).ready(function(){
	queryPage(0);
});