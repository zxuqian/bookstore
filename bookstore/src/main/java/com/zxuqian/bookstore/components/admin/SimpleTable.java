package com.zxuqian.bookstore.components.admin;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

public class SimpleTable {
	
	@Property
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String tableTitle;
	
	@Property
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private Block thead;
	
	@Property
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private Block tbody;

}
