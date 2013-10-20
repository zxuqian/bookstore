package com.zxuqian.bookstore.pages.admin.order;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONObject;

import com.zxuqian.bookstore.entities.Order;
import com.zxuqian.bookstore.services.OrderService;
import com.zxuqian.bookstore.util.SiteConstants;

public class IndexOrder {
	
	@Inject
	private OrderService orderService;
	
	@Property
	private Order order;
	
	@Property
	private List<Order> orders;
	
	public void onActivate() {
		this.orders = orderService.getAllOrders();
	}
	
	/**
	 * datatable配置
	 */
	public JSONObject getOptions() {
		return SiteConstants.getOptions();
	}

}
