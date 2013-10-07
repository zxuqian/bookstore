package com.zxuqian.bookstore.pages.admin.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

public class BookStack implements JavaScriptStack {
	
	private final AssetSource assetSource;
	
	public BookStack(final AssetSource assetSource) {
		this.assetSource = assetSource;
	}
	

	public List<String> getStacks() {
		return Collections.emptyList();
	}

	public List<Asset> getJavaScriptLibraries() {
		List<Asset> javascriptAssets = new ArrayList<Asset>();
		//javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/libs/jquery-1.8.3.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/cleditor/jquery.cleditor.min.js", null));
		//javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/custom/validation.js", null));
		
		return javascriptAssets;
	}

	public List<StylesheetLink> getStylesheets() {
		List<StylesheetLink> styleSheets = new ArrayList<StylesheetLink>();
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/plugins/cleditor/jquery.cleditor.css", null)));
		
		return styleSheets;
	}

	public String getInitialization() {
		return null;
	}

}
