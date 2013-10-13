package com.zxuqian.bookstore.dao.impl;

import java.util.List;

import org.hibernate.Session;

import javax.inject.Inject;

import com.zxuqian.bookstore.dao.AddressDao;
import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Province;

public class AddressDaoImpl implements AddressDao {

	@Inject
	private Session session;
	
	public List<Province> getProvinces() {
		return this.session.createQuery("from Province").list();
	}

	public void saveOrUpdateAddress(Address address) {
		this.session.saveOrUpdate(address);
	}

}
