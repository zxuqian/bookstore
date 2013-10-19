package com.zxuqian.bookstore.pages.order;

import java.text.SimpleDateFormat;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import com.zxuqian.bookstore.entities.Order;

public class OrderReceived {
	
	@Persist(PersistenceConstants.FLASH)
	private Order order;
	
	/**
	 * 获取创建时间
	 * @return
	 */
	public String getCreatedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(order.getCreatedDate());
	}
	
	/**
	 * 获取支付方式
	 * @return
	 */
	public String getPayment() {
		switch (order.getPayment()) {
		case BANK_CARD:
			return "银行转账";
		case CASH:
			return "货到付款";
		case ALIPAY:
			return "支付宝";
		default:
			return "";
		}
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return this.order;
	}

}
