package com.zxuqian.bookstore.services;

import java.util.List;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.AddressDao;
import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Province;

public class AddressService {

	@Inject
	private AddressDao addressDao;
	
	public List<Province> getProvinces() {
		return this.addressDao.getProvinces();
	}
	
	public void saveOrUpdateAddress(Address address) {
		this.addressDao.saveOrUpdateAddress(address);
	}
	
}
