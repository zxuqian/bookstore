package com.zxuqian.bookstore.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.openqa.jetty.http.SSORealm;

import com.zxuqian.bookstore.entities.Book;

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
    
    @SessionState
    private Zone cartZone;
    private boolean cartZoneExists;
    
    @Inject
    private ComponentResources componentResources;
    
    @Property
	@SessionState
	private List<Book> cart;
    private boolean cartExists;
    
    void setupRender() {
    	if(!cartExists) {
    		this.cart = new ArrayList<Book>();
    	}
    	if(!cartZoneExists) {
    		this.cartZone = (Zone)this.componentResources.getEmbeddedComponent("cartZone");
    		System.out.println(this.cartZone);
    	}
    }
    
    @AfterRender
    @Import(stack = "frontEndLayoutStack")
    void afterRender() {
    	//javascriptSupport.importJavaScriptLibrary(lib);
    }
    
    /**
     * 获取商品数量
     * @return
     */
    public int getCartSize() {
    	return this.cart.size();
    }
    
    /**
     * 获取总价
     * @return
     */
    public double getTotal() {
    	double sum = 0.0;
    	for(Book book : cart) {
    		sum += (book.getPrice() * book.getQuantity());
    	}
    	
    	return sum;
    }
    
    public Object onTruncate() {
    	this.cart = new ArrayList<Book>();
    	return this.cartZone.getBody();
    }
    
}
