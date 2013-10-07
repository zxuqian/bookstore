package com.zxuqian.bookstore.components.admin;

import java.util.List;

import org.apache.tapestry5.CSSClassConstants;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.internal.InternalMessages;

public class MyErrors {
	
    /**
     * The CSS class for the div element rendered by the component. The default value is "t-error".
     */
    @Parameter(name = "class")
    private String className = CSSClassConstants.ERROR;

    // Allow null so we can generate a better error message if missing
    @Environmental(false)
    private ValidationTracker tracker;

    void beginRender(MarkupWriter writer){
        if (tracker == null)
            throw new RuntimeException(InternalMessages.encloseErrorsInForm());

        if (!tracker.getHasErrors())
            return;
        
        writer.element("div", "class", className);

        List<String> errors = tracker.getErrors();

        if (!errors.isEmpty()) {
            // Only write out the <UL> if it will contain <LI> elements. An empty <UL> is not
            // valid XHTML.

            writer.element("ul");

            for (String message : errors){
                writer.element("li");
                writer.write(message);
                writer.end();
            }

            writer.end(); // ul
            
        }

        writer.end(); // div

    }

}
