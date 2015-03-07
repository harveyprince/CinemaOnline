$(document).ready(function(){
	$(".form-box").FormBoxInit({
			loginAble:true,
			loginBox:['email','password'],
			loginAction:"http://www.baidu.com",
			signupAble:true,
			signupBox:['email','password','password_repeat'],
			signupAction:"http://www.baidu.com",

			//functions
			onformsubmit:null,
			onloginformsubmit:null,
			onsignupformsubmit:null
		});
});