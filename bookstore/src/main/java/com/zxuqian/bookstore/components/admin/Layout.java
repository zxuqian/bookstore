package com.zxuqian.bookstore.components.admin;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SymbolConstants;

/**
 * Layout component for pages of application bookstore.
 */
@Import(stack = "layoutStack")
public class Layout
{
	@Inject
	@Path("context:layout/admin/js/custom/validation.js")
	private Asset validate;
	
	@Environmental
	private JavaScriptSupport javascriptSupport;
	
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title; 
    

    @Inject
    private ComponentResources resources;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;
    
    @AfterRender
    void afterRender() {
    	javascriptSupport.importJavaScriptLibrary(validate);
    }

}
