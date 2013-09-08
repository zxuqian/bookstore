package com.zxuqian.bookstore.admin.system;

import static org.easymock.EasyMock.*;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.ioc.test.IOCTestCase;
import org.apache.tapestry5.ioc.test.MockTester;
import org.apache.tapestry5.ioc.test.TestUtils;
import org.apache.tapestry5.test.PageTester;
import org.easymock.IMocksControl;
import org.easymock.internal.ReflectionUtils;
import org.junit.Test;

import com.zxuqian.bookstore.dao.MenuDao;
import com.zxuqian.bookstore.entities.Menu;
import com.zxuqian.bookstore.services.MenuService;

public class TestSystem {

	@Test
	public void testSystemIndex() {
		String appPackage = "com.zxuqian.bookstore";
		String appName = "app";
		String contextPath = "src/main/webapp";
		
		PageTester tester = new PageTester(appPackage, appName, contextPath);
		
		Document doc = tester.renderPage("admin/system/Index");
		System.out.println(doc.getRootElement().getName());
		
	}
	
	@Test
	public void testMenuDao() {
		MenuService menuService = new MenuService();
		
		MenuDao mock = createMock(MenuDao.class);
		
		menuService = TestUtils.set(menuService, "menuDao", mock);
		
		Menu menu = new Menu();
		
		mock.addMenu(menu);
		replay(mock);
		
		menuService.addMenu(menu);
		
		verify(mock);
	}

}
