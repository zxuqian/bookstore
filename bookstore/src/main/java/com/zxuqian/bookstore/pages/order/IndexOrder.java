package com.zxuqian.bookstore.pages.order;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.services.SelectModelFactory;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Book;
import com.zxuqian.bookstore.entities.Order;
import com.zxuqian.bookstore.entities.Province;
import com.zxuqian.bookstore.entities.User;
import com.zxuqian.bookstore.entities.Order.Payment;
import com.zxuqian.bookstore.services.AddressService;
import com.zxuqian.bookstore.services.BookService;
import com.zxuqian.bookstore.services.OrderService;
import com.zxuqian.bookstore.services.UserService;
import com.zxuqian.bookstore.util.SiteConstants;

public class IndexOrder {
	
	@Environmental
	private JavaScriptSupport javascriptSupport;
	
	@Inject
	@Path("context:frontend/checkout.js")
	private Asset asset;
	
	@Inject
	private UserService userService;
	
	@Inject
	private AddressService addressService;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private BookService bookService;
	
	@Property
	@SessionState
	private User user;
	@Property
	private boolean userExists;
	
	@Property
	private Order order;
	
	@Property
	private Address address;
	
	@Property
	private List<Province> provinces;
	
	@Property
	private Province province;
	
	@Property
	@SessionState
	private List<Book> cart;
	
	@Property
	private Book book;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	@Property
	private boolean createUser;
	
	
	public void onActivate() {
		this.provinces = addressService.getProvinces();
		if(this.userExists && this.user.getAddress() != null) {
			this.address = this.user.getAddress();
			this.province = this.address.getProvince();
		} else {
			this.address = new Address();
		}
		
		order = new Order();
	}
	
	@AfterRender
	public void afterRender() {
		this.javascriptSupport.importJavaScriptLibrary(asset);
	}
	
	/**
	 * 获取省份Model
	 * @return
	 */
	public SelectModel getProvinceModel() {
		return this.selectModelFactory.create(this.provinces, "province");
	}
	
	/**
	 * 获取小计
	 * @return
	 */
	public double getSubTotal() {
		return this.bookService.getSubTotal(this.cart);
	}
	
	/**
	 * 获取总计
	 * @return
	 */
	public double getGrandTotal() {
		return this.bookService.getGrandTotal(this.cart);
	}
	
	/**
	 * 银行卡
	 * @return
	 */
	public Payment getBankCard() {
		return Payment.BANK_CARD;
	}
	
	/**
	 * 货到付款
	 * @return
	 */
	public Payment getCash() {
		return Payment.CASH;
	}
	
	/**
	 * 支付宝
	 * @return
	 */
	public Payment getAlipay() {
		return Payment.ALIPAY;
	}
	
	/**
	 * 保存订单
	 */
	public void onSuccessFromCheckout() {
		//保存或修改地址
		this.address.setProvince(this.province);
		this.order.setAddress(address);
		this.addressService.saveOrUpdateAddress(address);
		
		//修改库存
		this.bookService.updateInventory(cart);
		
		//运费与总价
		this.order.setShipping(SiteConstants.SHIPPING);
		this.order.setTotal(this.getGrandTotal());
		
		//如果是新创建用户
		if(createUser) {
			this.userService.saveOrUpdate(user);
		}
		//用户存在用户
		if(!createUser && this.userExists) {
			this.order.setUser(this.user);
		}
		
		this.order.setOrderNumber(this.orderService.getOrderNumber());
		
		//添加相关书籍
		this.order.setBooks(this.cart);
		
		this.orderService.saveOrUpdateOrder(order);
		
	}
	
}
