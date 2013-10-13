package com.zxuqian.bookstore.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.JavaScriptStackSource;

import com.zxuqian.bookstore.components.LayoutStack;


/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 */
public class FrontEndModule
{
    public static void bind(ServiceBinder binder)
    {
    	
    }
    
    @Contribute(JavaScriptStackSource.class)
    public static void addJavascriptStack(MappedConfiguration<String, JavaScriptStack> configuration) {
    	configuration.addInstance("frontEndLayoutStack", LayoutStack.class);
    }
    
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration)
    {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
    }

}
