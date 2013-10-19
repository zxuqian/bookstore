package com.zxuqian.bookstore.pages.admin.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Loop;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.services.SelectModelFactory;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.slf4j.Logger;

import com.zxuqian.bookstore.entities.Category;
import com.zxuqian.bookstore.services.CategoryService;

public class IndexCategory {
	
	/**
	 * 类别管理的javascript文件
	 */
	@Inject
	@Path("context:admin/category.js")
	private Asset categoryAsset;
	
	/**
	 * 导入JavaScript文件的工具类
	 */
	@Inject
	private JavaScriptSupport javascriptSupport;
	
	/**
	 * 类别实体
	 */
	@Property
	private Category category;
	
	/**
	 * 父类别实体
	 */
	@Property
	private Category parent;
	
	/**
	 * 子类别集合
	 */
	@Property
	private List<Category> categoryChildren;
	
	/**
	 * 类别服务
	 */
	@Inject
	private CategoryService categoryService;
	
	/**
	 * 日志工具
	 */
	@Inject
	private Logger logger;
	
	/**
	 * 成功标志
	 */
	@Persist(PersistenceConstants.FLASH)
	@Property
	private boolean success;
	
	/**
	 * 结果消息
	 */
	@Property
	@Persist(PersistenceConstants.FLASH)
	private String msg;
	
	/**
	 * html select标签的选择模型
	 */
	@Inject
	private SelectModelFactory selectModelFactory;
	
	/**
	 * 类别表格序号
	 */
	private int tableIndex = 1;
	
	/**
	 * 类别表格需要Ajax更新的区域
	 */
	@InjectComponent
	private Zone rowZone;
	
	/**
	 * 类别表格循环组件
	 */
	@InjectComponent
	private Loop<Category> loopCategory;
	
	/**
	 * 是否在Ajax请求中
	 */
	@Property
	private boolean inZone = false;
	
	/**
	 * 当前类别是否已展开
	 */
	@Property
	private boolean isExpand = false;
	
	/**
	 * 类别表格数据，SESSION中保存，以展开和收缩
	 */
	@Persist(PersistenceConstants.SESSION)
	private List<Category> categoriesForTable;
	
	@Component(id = "form")
	private Form form;
	
	/**
	 * 页面初始化，导入JS
	 */
	public void setupRender() {
		this.javascriptSupport.importJavaScriptLibrary(categoryAsset);
		
	}
	
	
	/**
	 * 初始化category对象，render和submit之前
	 */
	public void onPrepare() {
		if(this.category == null) {
			this.category = new Category();
		}
		logger.debug("is category realy null?" + this.category);
	}
	
	public void onValidateFromForm() {
		//this.success = false;
		//this.msg = "请检查以下项目：";
		//this.form.recordError("类别名不能为空");
	}
	
	/**
	 * 提交保存
	 */
	public void onSuccess() {
		logger.debug("The category name is: " + this.category.getName()
				+ ", and description is: " + category.getDescription());
		
		//logger.debug("The parent category name is: " + this.parent.getName());
		
		this.category.setParent(parent);
		
		this.success = categoryService.saveOrUpdate(this.category);
		
		if(this.success) {
			this.msg = "保存成功";
		} else {
			this.msg = "保存失败";
		}
		
	}
	
	/**
	 * 删除category
	 */
	public void onActionFromDelete(Long categoryId) {
		logger.debug("获取到的类别id为：" + categoryId);
		this.categoryService.delete(categoryId);
	}
	
	
	/**
	 * 获取所有类别
	 * @return
	 */
	public SelectModel getCategories() {
		
		List<Category> treeCategory = new ArrayList<Category>();
		
		this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		
		return this.selectModelFactory.create(treeCategory, "name");
	}
	
	/**
	 * 为类别列表组装类别，由于点击的类别名称，把子类别加入进来，循环，当第二次点击时，就收缩树。（删除子list）
	 * @return
	 */
	public List<Category> getCategoriesForManagement() {
		//List<Category> treeCategory = new ArrayList<Category>();
		
		//this.categoryService.getTreeCategories(treeCategory, this.categoryService.getReadOnlyCategories(), "");
		//采用栈的方式取代递归
		if(this.inZone && this.categoryChildren != null && this.categoryChildren.size() > 0) {
			if(this.categoriesForTable.containsAll(this.categoryChildren)) {
				Stack<Category> categoryStack = new Stack<Category>();
				for(Category categoryChild : this.categoryChildren) {
					if(!categoryChild.isLeaf()) {
						categoryStack.push(categoryChild);
					} else {
						this.categoriesForTable.remove(categoryChild);
					}
				}
				
				while(!categoryStack.empty()) {
					Category categoryChild = categoryStack.pop();
					if(!categoryChild.isLeaf()) {
						for(Category category : categoryChild.getChildren()) {
							categoryStack.push(category);
						}
					} else {
						this.categoriesForTable.remove(categoryChild);
					}
				}
				
				this.categoriesForTable.removeAll(this.categoryChildren);
			} else {
				this.categoriesForTable.addAll(this.categoriesForTable.indexOf(category) + 1, this.categoryChildren);
			}
			return this.categoriesForTable;
		} else if(!this.inZone) {
			this.categoriesForTable = this.categoryService.getCategories();
			return this.categoriesForTable;
		} else {
			return this.categoriesForTable;
		}
		
	}
	
	/**
	 * 获取表格序号
	 * @return 序号
	 */
	public int getTableIndex() {
		return tableIndex++;
	}
	
	
	/**
	 * 当点击表格中的一个类别名称时，触发此事件，把category作为context传入进来，由于Ajax请求也属于第二次请求，
	 * 所有的变量都会丢失值，所以需要重新赋值
	 * @param category context变量
	 * @return 循环组件
	 */
	Object onExpand(Category category) {
		//System.out.println(categoryId + " in zone mothod.");
		this.category = category;
		this.categoryChildren = category.getChildren();
		if(this.categoriesForTable.get(this.categoriesForTable.indexOf(this.category)).isExpand()) {
			this.categoriesForTable.get(this.categoriesForTable.indexOf(this.category)).setExpand(false);
		} else {
			this.categoriesForTable.get(this.categoriesForTable.indexOf(this.category)).setExpand(true);
		}
		
		this.inZone = true;
		
		return this.loopCategory;
	}
	
	/**
	 * 是否为叶子节点或者已展开，若为true，则显示"-"，false显示"+"
	 * @return
	 */
	public boolean getIsExpandOrIsLeaf() {
		if(this.category.isLeaf() || this.category.isExpand()) {
			return true;
		} else {
			return false;
		}
	}
	
}
