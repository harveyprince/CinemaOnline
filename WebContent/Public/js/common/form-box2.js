(function($){
	var settings = {
		// version
		version:'0.0.0',

		// options
		options:{
			loginAble:true,
			loginBox:['email','password'],
			loginAction:"",
			signupAble:true,
			signupBox:['name','email','password'],
			signupAction:"",

			//functions
			onformsubmit:null,
			onloginformsubmit:null,
			onsignupformsubmit:null
		},

	};

	var Constructer = function(){
		this.eventInit = function($holder,options){
			//
			if(options.onformsubmit){
				$holder.find("form").submit(function(e){
					options.onformsubmit();
				});
			}else{
				$holder.find("form").submit(function(e){
					formsubmit.submitFormData(e,this);
				});
			}
			if(options.onloginformsubmit){
				$holder.find("form[type='login']").submit(function(e){
					options.onloginformsubmit();
				});
			}
			if(options.onsignupformsubmit){
				$holder.find("form[type='signup']").submit(function(e){
					options.onsignupformsubmit();
				});
			}
		};
		this.actionInit = function($holder,options){
			//
			$holder.find(".switch-button").click(function(){
				var $tohide = $(".input-group:visible");
				var $toshow = $(".input-group:hidden");
				$tohide.hide();
				$toshow.fadeIn("normal");
			});

			function validate_email(field)
			{
				with (field)
				{
				apos=value.indexOf("@")
				dotpos=value.lastIndexOf(".")
				if (apos<1||dotpos-apos<2) 
				  {return false}
				else {return true}
				}
			}
			$holder.find('.box-button').click(function(e){
				//valid input
				var $box = $(this).parents('form').find('.alarm-box').alarmInit();
				$(this).parents('form').find('input').each(function(){
					if($(this).attr('required')){
						if(($(this).val()!="")&&($(this).val()!=null)){
							switch($(this).attr('type')){
								case 'email':
									if(!validate_email(this)){
										$box.alarm("email is invalid!");
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
		};
		this.createBox = function($holder,options){
			var box = [];
			var active = ['active'];
			if(options.loginAble){
				var inputcontent = [];
				for (var idx = 0 ; idx < options.loginBox.length ; idx++) {
					inputcontent.push(createInput(options.loginBox[idx]));
				};
				var inputHTML = inputcontent.join("");
				var content = [];
				content.push(options.signupAble?createSwitchNav('login','sign up'):"");
				content.push(createForm(options.loginAction,'login',inputHTML));
				var group = createGroup('login',content.join(""),active.pop());
				box.push(group);
			}
			if(options.signupAble){
				var inputcontent = [];
				for (var idx = 0 ; idx < options.signupBox.length ; idx++) {
					inputcontent.push(createInput(options.signupBox[idx]));
				};
				var inputHTML = inputcontent.join("");
				var content = [];
				content.push(options.loginAble?createSwitchNav('sign up','login'):"");
				content.push(createForm(options.signupAction,'signup',inputHTML));
				var group = createGroup('signup',content.join(""),active.pop());
				box.push(group);
			}
			$holder.append(box.join(""));
		};

		var createGroup = function(type,group,active){
			return '<div class="'+type+'-group input-group '+active+'">'
			+group
			+'</div>';
		};

		var createSwitchNav = function(tip,switcher){
			return '<div class="group-switch-nav">'
				+'<span class="nav-tip">'+tip+'</span>'
				+'<span class="switch-button">'
				+'<span class="nav-tip">'+switcher+'</span>'
				+'<i class="fa fa-arrow-circle-right"></i>'
				+'</span>'
				+'</div>';
		};

		var createForm = function(action,type,input_group){
			return '<form action="'+action+'" method="post" autocomplete="off" type="'+type+'">'
			+input_group
			+createAlarmbox()
			+createButton(type)
			+'</form>';
		};

		var createInput = function(type){
			var inputcontent = [];
			switch(type){
				case 'name':
				inputcontent.push('<input class="form-box-input name-input" placeholder="surname" type="text" name="surname" required="required">');
				inputcontent.push('<input class="form-box-input name-input" placeholder="psname" type="text" name="psname" required="required">');
				break;
				case 'email':
				inputcontent.push('<span class="fa fa-user"></span>');
				inputcontent.push('<input class="form-box-input" placeholder="email" type="email" style="ime-mode:disabled;" name="email" required="required">');
				break;
				case 'password':
				inputcontent.push('<span class="fa fa-key"></span>');
				inputcontent.push('<input class="form-box-input" placeholder="password" type="password" name="password" required="required">');
				break;
				case 'password_repeat':
				inputcontent.push('<span class="fa fa-key"></span>');
				inputcontent.push('<input class="form-box-input" placeholder="password repeat" type="password" name="password_repeat" required="required">');
				break;
				default:
				break;
			}
			return '<div class="input-box-pack block-input-box">'+inputcontent.join("")+'</div>';
		};

		var createAlarmbox = function(){
			return '<div class="input-box-pack block-input-box alarm-pack">'
			+'<div class="alarm-box"></div>'
			+'</div>';
		};

		var createButton = function(type){
			return '<div class="input-box-pack block-input-box">'
			+'<button class="box-button" type="submit">'+type+'</button>'
			+'</div>';
		};

		var formsubmit = {
			submitFormData:function(e,which){
				var $box = $(which).find('.alarm-box').alarmInit();
				var action = $(which).attr('action');
				var data = new FormData();
				$(which).find('input').each(function(){
					data.append($(this).attr('name'),$(this).val());
				});
				$.ajax({
					data: data,
					type: "POST",
					url: action,
					cache: false,
					contentType: false,
					processData: false,
					success: function(data) {
						//callback code
					},
					error:function(){
						$box.alarm("error occured");
					}
				});
				e.preventDefault();
			},
			submitWithoutFormData:function(e,which){
				var $box = $(which).find('.alarm-box').alarmInit();
				var action = $(which).attr('action');
				var email = $(which).find('input[name="email"]').val();
				var password = $(which).find('input[name="password"]').val();
				if($(which).attr('type')=='login'){
					$.post(action,{email:email,password:password},function(data,status){
						//callback code
					});
				}
				if($(which).attr('type')=='signup'){
					var surname = $(which).find('input[name="surname"]').val();
					var psname = $(which).find('input[name="psname"]').val();
					$.post(action,{email:email,password:password,surname:surname,psname:psname},function(data,status){
						//callback code
					});
				}
			}
		};
	};

	var constructer = new Constructer();

	// jQuery namespace for formbox
	$.formbox = $.formbox || {};

	// extends default `settings`
	$.extend($.formbox, settings);
	
	$.fn.extend({
		FormBoxInit: function(options) {
			//
			options = $.extend({}, $.formbox.options, options);

			this.each(function (idx, elHolder) {
				var $holder = $(elHolder);
				constructer.createBox($holder,options);
				constructer.actionInit($holder,options);
				constructer.eventInit($holder,options);
			});

			return this;
		}
	});
})(jQuery);