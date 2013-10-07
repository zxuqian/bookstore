;(function( $, window, document, undefined ) {
	$(document).ready(function() {
		
		if($.fn.dialog) {
			$("#delete-category-dialog").dialog({
                autoOpen: false,
                title: "确认删除",
                modal: true,
                width: "340",
                buttons: [{
                    text: "取消",
                    click: function () {
                        $(this).dialog("close");
                    }
                },{
                    text: "是的，我确认",
                    click: function (event) {
                        $(this).dialog("close");
                        window.location.href = $(this).dialog("option", "href");
                    },
                }]
            });
		}
		
		$(".deleteCategory").each(function(index, actionElement) {
			$(actionElement).bind("click", function(event){
				var a = $(this);
	    		$("#delete-category-dialog").dialog("option", {
	    			model: true,
	    			href: a.attr("href")
	    		}).dialog("open");
	    		event.preventDefault();
	    	});
		});
		
		//Ajax loading
		$("#categoryTable").on(Tapestry.TRIGGER_ZONE_UPDATE_EVENT, ".expand",function(event) {
			var anchor = event.target;
			var loading = $(anchor).find("img.loading");
			$(loading).show();
		});
		
		//Delete all automaticly added image icons
		$(".t-error-icon").remove();

		
    });
	
}) (jQuery, window, document);

//$.noConflict();
//Tapestry.onDOMLoaded(function() {
//	$(document.body).on(Tapestry.TRIGGER_ZONE_UPDATE_EVENT, function(event, element) {
//		var loading = element.childElements()[0];
//		$(loading).show();
//	});
//});


