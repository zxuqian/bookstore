package com.zxuqian.bookstore.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;
import org.apache.tapestry5.services.javascript.StylesheetOptions;

public class LayoutStack implements JavaScriptStack {
	
	private final AssetSource assetSource;
	
	public LayoutStack(final AssetSource assetSource) {
		this.assetSource = assetSource;
	}
	

	public List<String> getStacks() {
		return Collections.emptyList();
	}

	public List<Asset> getJavaScriptLibraries() {
		List<Asset> javascriptAssets = new ArrayList<Asset>();
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/lib.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/modernizr.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/easing.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/bs.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/bxslider.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/input-clear.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/range-slider.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/jquery.zoom.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/bookblock.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/custom.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/social.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/frontend/js/raty/jquery.raty.js", null));
		
		return javascriptAssets;
	}

	public List<StylesheetLink> getStylesheets() {
		List<StylesheetLink> styleSheets = new ArrayList<StylesheetLink>();
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/bs.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/main-slider.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/font-awesome.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/font-awesome-ie7.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/wostyle.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/frontend/css/style.css", null)));
		
		return styleSheets;
	}

	public String getInitialization() {
		//return "$.noConflict()";
		return null;
	}

}
