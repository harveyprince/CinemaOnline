$("select").select2();
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
	// 

	// kind
	$kindInput = $modal.find(".kind-input");
	$kindsource = $row.children(".kind");
	var kind = $kindsource.html();
	$kindInput.val(kind).trigger("change");
	// releaseTime
	$releaseTimeInput = $modal.find(".releaseTime-input");
	$releasesource = $row.children(".releaseTime");
	var releasetime = $releasesource.html();
	$releaseTimeInput.val(releasetime);
	// shelvesTime
	$shelvesTimeInput = $modal.find(".shelvesTime-input");
	$shelvessource = $row.children(".shelvesTime");
	var shelvestime = $shelvessource.html();
	$shelvesTimeInput.val(shelvestime);
});
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
					// 

					// kind
					$kindInput = $modal.find("select.kind-input");
					$kindsource.html($kindInput.val());
					// releaseTime
					$releaseTimeInput = $modal.find(".releaseTime-input");
					$releasesource.html($releaseTimeInput.val());
					// shelvesTime
					$shelvesTimeInput = $modal.find(".shelvesTime-input");
					$shelvessource.html($shelvesTimeInput.val());
					
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