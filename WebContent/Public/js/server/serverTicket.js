$(".identity-input").select2();
$(".payway-input").select2();
$(".film-plan-confirm").click(function(){
	$(".ticket-tab").click();
});
$(".ticket-confirm").click(function(){
	var action = $(this).attr("target");
	var data = new FormData();
	data.append("ticketOrder.planid",$(".planid-shown").html());
	data.append("ticketOrder.seatNum",$(".seatnum-input").val());
	data.append("ticketOrder.identity",$("select.identity-input").val());
	if($("select.identity-input").val()=="1"){
		data.append("ticketOrder.vip_account.accountName",$(".vip-no-input").val());
		data.append("ticketOrder.vip_account.password",$.md5($(".vip-password-input").val()));
	}
	$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data.indexOf("success")!=-1){
					var cost = data.split("#")[1];
					$(".bill-shown").html(cost);
					$(".pay-tab").click();
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
	
});
$(".ticket-finish-button").click(function(){
	var action = $(this).attr("target");
	var data = new FormData();
	data.append("ticketOrder.payway",$("select.payway-input").val());
	if($("select.payway-input").val()=="1"){
		data.append("ticketOrder.bank_account.userId",$(".bank-no-input").val());
		data.append("ticketOrder.bank_account.password",$(".bank-password-input").val());
	}
	$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data.indexOf("success")!=-1){
					$.scojs_message(data, $.scojs_message.TYPE_OK);
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
});
function identityJudge(){
	var i = $("select.identity-input").val();
	if(i==1){
		$(".vip-box").slideDown();
	}else{
		$(".vip-box").slideUp();
	}
}
function paywayJudge(){
	var i = $("select.payway-input").val();
	if(i==1){
		$(".bank-box").slideDown();
	}else{
		$(".bank-box").slideUp();
	}
}
$(".identity-input").click(function(){
	identityJudge();
});
$(".payway-input").click(function(){
	paywayJudge();
});
$(".identity-input").on("change",function(e){
	identityJudge();
});
$(".payway-input").on("change",function(e){
	paywayJudge();
});
$(".ticket-sale-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalSale");
	$modal.find(".planid-shown").html($row.children(".planId").html());
	$modal.find(".film-shown").html($row.children(".filmName").html());
	$modal.find(".hall-shown").html($row.children(".hallNo").html());
	$modal.find(".seat-shown").html($row.children(".seatLeft").html());
	$modal.find(".time-shown").html($row.children(".beginTime").html()+"~"+$row.children(".endTime").html());
	$modal.find(".price-shown").html($row.children(".price").html());
	modalSaleInit();
	$modal.find(".info-tab").click();
});
function modalSaleInit(){
	$modal = $("#modalSale");
	$modal.find(".seatnum-input").val("");
	$modal.find("select.identity-input").val(0).trigger("change");
	$modal.find(".vip-no-input").val("");
	$modal.find(".vip-password-input").val("");
	$modal.find(".bill-shown").html("0");
	$modal.find("select.payway-input").val(0).trigger("change");
	$modal.find("bank-no-input").val("");
	$modal.find(".bank-password-input").val("");
}