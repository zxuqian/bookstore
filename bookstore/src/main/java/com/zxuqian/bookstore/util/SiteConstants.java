package com.zxuqian.bookstore.util;

import org.apache.tapestry5.json.JSONObject;

public class SiteConstants {
	
	/**
	 * 上传目录
	 */
	public static final String UPLOAD_FOLDER = "bookstore_upload";
	
	/**
	 * 库存状态
	 */
	public static final String BOOK_IN_STOCK = "有货";
	
	/**
	 * 库存状态
	 */
	public static final String BOOK_NOT_AVAILABLE = "无货";
	
	/**
	 * 运费
	 */
	public static final double SHIPPING = 0.0;
	
	
	/**
	 * 配置datatable
	 * @return
	 */
	public static JSONObject getOptions() {
		JSONObject options = new JSONObject();
		
		JSONObject oPaginate = new JSONObject();
		oPaginate.put("sFirst", "首页");
		oPaginate.put("sLast", "尾页");
		oPaginate.put("sNext", "下一页");
		oPaginate.put("sPrevious", "上一页");
		
		JSONObject oLanguage = new JSONObject();
		oLanguage.put("sLengthMenu", "每页显示  _MENU_ 条记录");
		oLanguage.put("sZeroRecords", "对不起，没有找到数据");
		oLanguage.put("sInfo", "显示第 _START_ 到 _END_ 条，共 _TOTAL_ 条记录");
		oLanguage.put("sInfoEmpty", "显示 0 到 0 条， 共 0 条记录");
		oLanguage.put("sInfoFiltered", "(从 _MAX_ 条记录中过滤)");
		oLanguage.put("sSearch", "搜索");
		
		oLanguage.put("oPaginate", oPaginate);
		
		options.put("oLanguage", oLanguage);
		
		return options;
	}

}
