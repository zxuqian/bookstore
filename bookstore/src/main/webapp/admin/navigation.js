;(function( $, window, document, undefined ) {
	$(document).ready(function() {
		
		$("thead th.checkbox.t-first").prepend("<input type='checkbox' id='selectAll' style='margin-right: 5px' />");
		
		$("#selectAll").click(function() {
			if($(this).prop("checked")) {
				$(".checkbox input[type=checkbox]").each(function() {
					$(this).attr("checked", "checked");
				});
			} else {
				$(".checkbox input[type=checkbox]").each(function(element) {
					$(this).removeAttr("checked");
				});
			}
			
			
		});
		
	});
}) (jQuery, window, document)

