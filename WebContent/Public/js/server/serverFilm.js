$("select").select2();

$(".film-edit-button").click(function(){
	$row = $(this).parent().parent();
	$modal = $("#modalEdit");
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
});