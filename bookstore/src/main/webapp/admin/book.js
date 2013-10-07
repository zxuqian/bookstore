;(function($, document, window, undefined) {
	$(document).ready(function() {
		$.datepicker.setDefaults({
			dateFormat: "yy-mm-dd"
		});
		// Data Tables
		$("#bookmanagement").addClass("mws-datatable-fn mws-table");
//        if( $.fn.dataTable ) {
//            //$(".mws-datatable").dataTable();
//            $(".mws-datatable-fn").dataTable({
//                sPaginationType: "full_numbers",
//                "oLanguage": {
//                    "sLengthMenu": "每页显示  _MENU_ 条记录",
//                    "sZeroRecords": "对不起，没有找到数据",
//                    "sInfo": "显示第 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
//                    "sInfoEmpty": "显示 0 到 0 条， 共 0 条记录",
//                    "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",
//                    "sSearch": "搜索",
//                    "oPaginate": {
//                    	"sFirst": "首页",
//                        "sLast": "尾页",
//                        "sNext": "下一页",
//                        "sPrevious": "上一页"
//                    }
//                    //"bProcessing": true,
//                    //"bServerSide": true,
//                    //"sAjaxSource": ""
//                }
//            });
//        }
	});
	
})(jQuery, document, window);