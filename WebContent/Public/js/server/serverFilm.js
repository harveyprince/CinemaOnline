$("select").select2();
function eventInit(){
	$(".film-eye-button").click(function(){
	var $button = $(this);
	var filmid = $(this).parent().siblings(".filmId").html();
	var action = $(this).attr("target");
	var data = new FormData();
	data.append("filmid",filmid);
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
				setTimeout(function(){window.location.reload()},500);
			}else{
				$.scojs_message(data, $.scojs_message.TYPE_ERROR);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
});
$(".film-edit-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalEdit");
	// film-id
	$filmIdInput = $modal.find(".filmid-input");
	$filmIdsource = $row.children(".filmId");
	var filmid = $filmIdsource.html();
	$filmIdInput.val(filmid);
	
	// film-input
	$filmInput = $modal.find(".filmname-input");
	$filmsource = $row.children(".filmName");
	var filmname = $filmsource.html();
	$filmInput.val(filmname);
	// duration-input
	$durationInput = $modal.find(".duration-input");
	$durationsource = $row.children(".duration");
	var durationvalue = $durationsource.html();
	$durationInput.val(durationvalue);
	// cost
	$costInput = $modal.find("cost-input");
	$costsource = $row.children(".cost");
	var costvalue = $costsource.html();
	$costInput.val(costvalue);

	// kind
	$kindInput = $modal.find(".kind-input");
	$kindsource = $row.children(".kind");
	var kind = $kindsource.html();
	$kindInput.val(kind).trigger("change");
});
}

$("#modalEdit").find(".save-button").click(function(){
	var action = $("#filmedit-form").attr("action");
	if(isFormValid($("#filmedit-form"))){
		var data = new FormData();
		data = getFormData($("#filmedit-form"),data);
		$.ajax({
			data: data,
			type: "POST",
			url: action,
			cache: false,
			contentType: false,
			processData: false,
			success: function(data) {
				if(data=="success"){
					$modal = $("#modalEdit");
					// film-input
					$filmInput = $modal.find(".filmname-input");
					$filmsource.html($filmInput.val());
					// duration-input
					$durationInput = $modal.find(".duration-input");
					$durationsource.html($durationInput.val());
					// cost
					$costInput = $modal.find(".cost-input");
					$costsource.html($costInput.val());

					// kind
					$kindInput = $modal.find("select.kind-input");
					$kindsource.html($kindInput.val());
					
					$.scojs_message('success', $.scojs_message.TYPE_OK);
					$("#modalEdit").modal("hide");
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

$("#modalAdd").find(".save-button").click(function(){
	var action = $("#filmadd-form").attr("action");
	if(isFormValid($("#filmadd-form"))){
		var data = new FormData();
		data = getFormData($("#filmadd-form"),data);
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
					$("#modalAdd").modal("hide");
					setTimeout(function(){window.location.reload()},500);
				}
			},
			error:function(){
				$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
			}
		});
	}
});
function queryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "mainmanar_film",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".film-tbody").html(data);
				eventInit();
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.next").click(function(){
	var page = Number($(".film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	queryPage(page+1);
});
$(".btn.previous").click(function(){
	var page = Number($(".film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	if(page>0){
		queryPage(page-1);
	}
});
$(document).ready(function(){
	queryPage(0);
});

function oldqueryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "mainmanar_old_film",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".old-film-tbody").html(data);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.old-next").click(function(){
	var page = Number($(".old-film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	oldqueryPage(page+1);
});
$(".btn.old-previous").click(function(){
	var page = Number($(".old-film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	if(page>0){
		oldqueryPage(page-1);
	}
});
$(document).ready(function(){
	oldqueryPage(0);
});

function releasequeryPage(page){
	var data = new FormData();
	data.append("page",page);
	$.ajax({
		data: data,
		type: "POST",
		url: "mainmanar_release_film",
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data!="empty"){
				$(".release-film-tbody").html(data);
			}
		},
		error:function(){
			$.scojs_message('error occured!', $.scojs_message.TYPE_ERROR);
		}
	});
}
$(".btn.release-next").click(function(){
	var page = Number($(".release-film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	releasequeryPage(page+1);
});
$(".btn.release-previous").click(function(){
	var page = Number($(".release-film-tbody .page-symbol").html());
	if(isNaN(page)){return false;}
	if(page>0){
		releasequeryPage(page-1);
	}
});
$(document).ready(function(){
	releasequeryPage(0);
});