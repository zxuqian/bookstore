package com.zxuqian.bookstore.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

public class Layout {
	
	//@Inject
	//@Path("context:layout/frontend/js/lib.js")
	//private Asset lib;
	
	//@Environmental
	//private JavaScriptSupport javascriptSupport;
	
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
    @Import(stack = "frontEndLayoutStack")
    void afterRender() {
    	//javascriptSupport.importJavaScriptLibrary(lib);
    }
    
}
