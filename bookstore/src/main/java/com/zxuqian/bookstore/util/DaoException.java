package com.zxuqian.bookstore.util;

import org.apache.log4j.Logger;


public class DaoException extends RuntimeException {
	
	private static final long serialVersionUID = 225733653016305039L;
	private Logger logger = Logger.getLogger(DaoException.class);

	public DaoException(String message) {
		logger.error("数据库操作异常： " + message);
	}
	
}
