function selectInitial($st,list){
	$st.append();
	for(var temp in list){
		var optemp = $("<option value='"+list[temp].id+"'>").html(list[temp].text).appendTo($st);
	}
}

function findValueByKey(list,key){
	for (var temp in list) {
		if(list[temp].id==key){
			return list[temp].text;
		}
	};
}
$(".btn-group").click(function(){
	$btng = $(this);
	if($btng.find("ul").is(":hidden")){
		$btng.addClass("open");
	} else {
		$btng.removeClass("open");
	}
	
});
