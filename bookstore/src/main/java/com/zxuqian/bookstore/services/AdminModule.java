package com.zxuqian.bookstore.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.internal.hibernate.HibernateEntityValueEncoder;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.ioc.services.LoggingAdvisor;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.JavaScriptStackSource;
import org.got5.tapestry5.jquery.JQuerySymbolConstants;
import org.slf4j.Logger;

import com.zxuqian.bookstore.components.admin.LayoutStack;
import com.zxuqian.bookstore.dao.BookDao;
import com.zxuqian.bookstore.dao.CategoryDao;
import com.zxuqian.bookstore.dao.InventoryDao;
import com.zxuqian.bookstore.dao.MenuDao;
import com.zxuqian.bookstore.dao.UserDao;
import com.zxuqian.bookstore.dao.impl.BookDaoImpl;
import com.zxuqian.bookstore.dao.impl.CategoryDaoImpl;
import com.zxuqian.bookstore.dao.impl.InventoryDaoImpl;
import com.zxuqian.bookstore.dao.impl.MenuDaoImpl;
import com.zxuqian.bookstore.dao.impl.UserDaoImpl;
import com.zxuqian.bookstore.pages.admin.book.BookStack;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class AdminModule
{
    public static void bind(ServiceBinder binder)
    {
    	binder.bind(UserDao.class, UserDaoImpl.class);
    	binder.bind(UserService.class);
    	
    	binder.bind(MenuDao.class, MenuDaoImpl.class);
    	binder.bind(MenuService.class);
    	binder.bind(ValueEncoder.class, HibernateEntityValueEncoder.class);
    	
    	binder.bind(CategoryDao.class, CategoryDaoImpl.class);
    	binder.bind(CategoryService.class);
    	
    	binder.bind(BookDao.class, BookDaoImpl.class);
    	binder.bind(BookService.class);
    	
    	binder.bind(InventoryDao.class, InventoryDaoImpl.class);
    	binder.bind(InventoryService.class);
    	
    }
    
    /**
     * add log to my service
     * @param loggingAdvisor
     * @param logger
     * @param receiver
     */
    @Match("*Service")
    public static void adviseLoggin(LoggingAdvisor loggingAdvisor, Logger logger, MethodAdviceReceiver receiver) {
    	loggingAdvisor.addLoggingAdvice(logger, receiver);
    }
    
    /**
     * add transaction to Dao
     * @param advisor
     * @param receiver
     */
    @Match("*Dao")
    public static void adviseTransactions(HibernateTransactionAdvisor advisor, MethodAdviceReceiver receiver) {
    	advisor.addTransactionCommitAdvice(receiver);
    }
    
    @Contribute(JavaScriptStackSource.class)
    public static void addJavascriptStack(MappedConfiguration<String, JavaScriptStack> configuration) {
    	configuration.addInstance("layoutStack", LayoutStack.class);
    	configuration.addInstance("bookStack", BookStack.class);
    }
    
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration)
    {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
    	configuration.add("upload.filesize-max", 2097152);
    }

}
