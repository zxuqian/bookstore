;(function($, document, window, undefined) {
	
	$(document).ready(function() {
		$.datepicker.setDefaults({
			dateFormat: "yy-mm-dd"
		});
		// Data Tables
		$("#bookmanagement").addClass("mws-datatable-fn mws-table");
        if( $.fn.dataTable ) {
        	$("tfoot").remove();
        }
        
        /**
         * Fortuenately I got this! Global ajax handler!
         */
        $(document).ajaxSuccess(function(event, xhr, options) {
        	$(".deleteBook").each(function(index, element) {
        		var a = $(this);
        		$(this).bind("click", function(event) {
        			$("#delete-book-dialog").dialog("option", {
    	    			model: true,
    	    			href: a.attr("href")
    	    		}).dialog("open");
    	    		event.preventDefault();
        		});
        	});
        });
        
        if($.fn.dialog) {
			$("#delete-book-dialog").dialog({
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
	});
	
})(jQuery, document, window);

