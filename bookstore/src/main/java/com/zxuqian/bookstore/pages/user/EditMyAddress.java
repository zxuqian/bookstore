package com.zxuqian.bookstore.pages.user;

import java.util.List;

import javax.inject.Inject;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.services.SelectModelFactory;

import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Province;
import com.zxuqian.bookstore.entities.User;
import com.zxuqian.bookstore.services.AddressService;
import com.zxuqian.bookstore.services.UserService;

public class EditMyAddress {
	
	@Inject
	private AddressService addressService;
	
	@Property
	private Province province;
	
	@Property
	private List<Province> provinces;
	
	@Inject
	private SelectModelFactory selectModelFactory;
		
	@Property
	private Address address;
	
	@Property
	@SessionState
	private User user;
	
	private boolean userExists;
	
	@Inject
	private UserService userService;
	
	@InjectPage
	private MyAccount myAccount;
	
	public void onActivate() {
		this.provinces = addressService.getProvinces();
		if(this.user.getAddress() == null) {
			this.address = new Address();
		} else {
			this.address = this.user.getAddress();
			this.province = this.address.getProvince();
		}
		
	}
	
	/**
	 * 获取省份的select model
	 * @return
	 */
	public SelectModel getProvincesModel() {
		return this.selectModelFactory.create(this.provinces, "province");
	}
	
	/**
	 * 保存收货地址
	 */
	public MyAccount onSuccessFromEditAddress() {
		if(userExists) {
			if(province != null) {
				this.address.setProvince(this.province);
				this.addressService.saveOrUpdateAddress(address);
				this.user.setAddress(this.address);
				this.userService.saveOrUpdate(user);
				return this.myAccount;
			}
		}
		
		return null;
	}

}
