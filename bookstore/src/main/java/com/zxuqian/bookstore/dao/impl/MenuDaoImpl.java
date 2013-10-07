package com.zxuqian.bookstore.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;

import com.zxuqian.bookstore.dao.MenuDao;
import com.zxuqian.bookstore.entities.Menu;

public class MenuDaoImpl implements MenuDao {
	
	@Inject
	private Session session;

	public void addMenu(Menu menu) {
		
		session.save(menu);

	}

	public List<Menu> getParentMenus() {
		return session.createQuery("from Menu m where m.parent.id=null order by menu_order").list();
	}

}
