jQuery(document).ready(function(e) {
	
	if(e("div.create-account") != null) {
		e("div.create-account").hide();
		e("input#createaccount").change(
			function() {
				e("div.create-account").hide();
				e(this).is(":checked")
						&& e("div.create-account")
								.slideDown();
			}).change();
	}
	
	e("a.showlogin").click(function() {
		e("form.login").slideToggle();
		return false;
	});
});