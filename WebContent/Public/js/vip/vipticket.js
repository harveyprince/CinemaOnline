$(".identity-input").select2();
$(".payway-input").select2();
$(".info-tab").click(function(){
	return false;
});
$(".ticket-tab").click(function(){
	return false;
});
$(".pay-tab").click(function(){
	return false;
});
$(".seats-tab").click(function(){
	return false;
});
$(".film-plan-confirm").click(function(){
	$(".ticket-tab").tab("show");
});
$(".ticket-confirm").click(function(){
	var action = $(this).attr("target");
	var data = new FormData();
	data.append("ticketOrder.planid",$(".planid-shown").html());
	data.append("ticketOrder.seatNum",$(".seatnum-input").val());
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
					$(".pay-tab").tab("show");
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
	var payway_number = $(".payway-input").select2("val");
	if(payway_number==null){
		payway_number=2;
	}
	data.append("ticketOrder.payway",payway_number);
	if(payway_number=="1"){
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
					$(".seats-shown").html(data.replace("success#","").replace(/&/g,","));
					$.scojs_message("success", $.scojs_message.TYPE_OK);
					$(".seats-tab").tab("show");
				}else{
					$.scojs_message(data, $.scojs_message.TYPE_ERROR);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
});
$(".sale-close-button").click(function(){
	$("#modalSale").modal("hide");
	setTimeout(function(){window.location.reload()},500);
});

$(".payway-input").on("select2-selected", function (e) { 
	var i = e.val;
	if(i==1){
		$(".bank-box").slideDown();
	}else{
		$(".bank-box").slideUp();
	}
});
function eventInit(){
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
	$modal.find(".info-tab").tab("show");
});
}

function modalSaleInit(){
	$modal = $("#modalSale");
	$modal.find(".seatnum-input").val("1");
	$modal.find("select.identity-input").val(0).trigger("change");
	$modal.find(".bill-shown").html("0");
	$modal.find("select.payway-input").val(0).trigger("change");
	$modal.find("bank-no-input").val("");
	$modal.find(".bank-password-input").val("");
}

function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "vipserver_ticket",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".ticket-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".ticket-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".ticket-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	if(page>0){
		queryPage(page-1);
	}
});
$(document).ready(function(){
	queryPage(0);
});

