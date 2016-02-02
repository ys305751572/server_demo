var findPageMenuByCurrentUser = function(){
	$menu = $(".active");
	var menuId = $menu.prop("id");
	
	var url = ${contextPath} + "";
	$.post(url,function(data) {
		rendPageElement();
	});
	
}

var rendPageElement = function() {
	
}