$(".switch-button").click(function(){
	//
});
//submit:use formdata
$("form").submit(function(e){
	var $box = $(this).find('.alarm-box').alarmInit();
	var action = $(this).attr('action');
	var data = new FormData();
	$(this).find('input').each(function(){
		if($(this).attr('name')=='password'){
			data.append($(this).attr('name'),$.md5($(this).val()));
		}else{
			data.append($(this).attr('name'),$(this).val());
		}
	});
	$.ajax({
		data: data,
		type: "POST",
		url: action,
		cache: false,
		contentType: false,
		processData: false,
		success: function(data) {
			if(data=="usernotfound"){
				$box.alarm("user not found!");
			}else if(data=="pserror"){
				$box.alarm("password error");
			}
		},
		error:function(){
			$box.alarm("error occured");
		}
	});
	e.preventDefault();
});
//submit:without formdata
/*
$("form").submit(function(e){
	var $box = $(this).find('.alarm-box').alarmInit();
	var action = $(this).attr('action');
	var email = $(this).find('input[name="email"]').val();
	var password = $(this).find('input[name="password"]').val();
	if($(this).attr('type')=='login'){
		$.post(action,{email:email,password:password},function(data,status){
			//callback code
		});
	}
	if($(this).attr('type')=='signup'){
		var surname = $(this).find('input[name="surname"]').val();
		var psname = $(this).find('input[name="psname"]').val();
		$.post(action,{email:email,password:password,surname:surname,psname:psname},function(data,status){
			//callback code
		});
	}
});
*/
function validate_number(field)
{
	with (field)
	{
	for(var i = 0;i<value.length;i++){
		if(isNaN(value.charAt(i))){
			return false;
		}
	}
	return true;
	}
}
$('.box-button').click(function(e){
	//valid input
	var $box = $(this).parents('form').find('.alarm-box').alarmInit();
	$(this).parents('form').find('input').each(function(){
		if($(this).attr('required')){
			if(($(this).val()!="")&&($(this).val()!=null)){
				switch($(this).attr('name')){
					case 'accountid':
						if(!validate_number(this)){
							$box.alarm("id is invalid!");
							e.preventDefault();
						}
						break;
					case 'password':
						break;
					default:
						break;
				}
			}else{
				$box.alarm($(this).attr('name') + " is required!");
				e.preventDefault();
			}
		}
	});
});