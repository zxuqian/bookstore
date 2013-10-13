package com.zxuqian.bookstore.dao;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.zxuqian.bookstore.entities.Address;
import com.zxuqian.bookstore.entities.Province;

public interface AddressDao {

	/**
	 * 获取所有省份
	 * @return 省份列表
	 */
	@CommitAfter
	List<Province> getProvinces();
	
	@CommitAfter
	void saveOrUpdateAddress(Address address);
	
}
