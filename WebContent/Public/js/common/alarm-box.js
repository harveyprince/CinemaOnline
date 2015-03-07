(function($){
	$.fn.alarmInit = function(){
		var $box = $(this);

		($box.destroy = function(){
			$box.fadeOut("slow");
			$box.find('li').remove();
		})();

		$box.find('ul').remove();
		$box.append('<ul></ul>');

		$box.alarm = function(a) {
			switch(typeof(a)){
				case 'string':
					$box.children('ul').append('<li><i class="fa fa-exclamation-circle"></i>'+a+'</li>');
					break;
				case 'object':
					for (var i = 0; i < a.length; i++) {
						$box.children('ul').append('<li><i class="fa fa-exclamation-circle"></i>'+a[i]+'</li>');
					};
					break;
				default:
					break;
			}
			$box.fadeIn("normal");
		};

		return $box;
	}
})(jQuery);