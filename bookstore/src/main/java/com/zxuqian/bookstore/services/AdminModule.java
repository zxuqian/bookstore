package com.zxuqian.bookstore.services;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor;
import org.apache.tapestry5.internal.hibernate.HibernateEntityValueEncoder;
import org.apache.tapestry5.ioc.MethodAdviceReceiver;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Match;
import org.apache.tapestry5.ioc.services.LoggingAdvisor;
import org.slf4j.Logger;

import com.zxuqian.bookstore.dao.CategoryDao;
import com.zxuqian.bookstore.dao.MenuDao;
import com.zxuqian.bookstore.dao.UserDao;
import com.zxuqian.bookstore.dao.impl.CategoryDaoImpl;
import com.zxuqian.bookstore.dao.impl.MenuDaoImpl;
import com.zxuqian.bookstore.dao.impl.UserDaoImpl;

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

}
