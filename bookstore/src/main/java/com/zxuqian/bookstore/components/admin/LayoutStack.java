package com.zxuqian.bookstore.components.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

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
		//javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/libs/jquery-1.8.3.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/libs/jquery.mousewheel.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/libs/jquery.placeholder.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/custom-plugins/fileinput.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/jui/js/jquery-ui-1.9.2.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/jui/jquery-ui.custom.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/jui/js/jquery.ui.touch-punch.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/datatables/jquery.dataTables.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/flot/jquery.flot.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/flot/plugins/jquery.flot.tooltip.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/flot/plugins/jquery.flot.pie.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/flot/plugins/jquery.flot.stack.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/flot/plugins/jquery.flot.resize.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/colorpicker/colorpicker-min.js", null));
		//javascriptAssets.add(assetSource.getContextAsset("layout/admin/plugins/validate/jquery.validate-min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/custom-plugins/wizard/wizard.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/bootstrap/js/bootstrap.min.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/core/mws.js", null));
		javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/core/themer.js", null));
		//javascriptAssets.add(assetSource.getContextAsset("layout/admin/js/custom/validation.js", null));
		
		return javascriptAssets;
	}

	public List<StylesheetLink> getStylesheets() {
		List<StylesheetLink> styleSheets = new ArrayList<StylesheetLink>();
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/plugins/colorpicker/colorpicker.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/custom-plugins/wizard/wizard.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/bootstrap/css/bootstrap.min.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/fonts/ptsans/stylesheet.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/fonts/icomoon/style.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/mws-style.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/icons/icol16.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/icons/icol32.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/demo.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/jui/css/jquery.ui.all.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/jui/jquery-ui.custom.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/mws-theme.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/themer.css", null)));
		styleSheets.add(new StylesheetLink(assetSource.getContextAsset("layout/admin/css/table.css", null)));
		
		return styleSheets;
	}

	public String getInitialization() {
		return null;
	}

}
