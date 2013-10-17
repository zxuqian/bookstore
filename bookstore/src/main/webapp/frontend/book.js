$(document).ready(function(){
	$(".star").each(function() {
		$(this).raty({
			score: function() {
				return $(this).attr("data-number");
			},
			readOnly: true,
			path: "../../layout/frontend/js/raty/img/"
		});
		
	});
	
	
});