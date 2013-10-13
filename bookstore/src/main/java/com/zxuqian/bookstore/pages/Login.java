package com.zxuqian.bookstore.pages;

import javax.inject.Inject;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

import com.zxuqian.bookstore.entities.User;
import com.zxuqian.bookstore.pages.user.MyAccount;
import com.zxuqian.bookstore.services.UserService;

public class Login {

	@Inject
	private UserService userService;
	
	@Property
	@Persist(PersistenceConstants.SESSION)
	private User user;
	
	@Component(id = "register")
	private Form registerForm;
	
	@InjectPage
	private MyAccount myAccount;
	
	public void onPrepare() {
		this.user = new User();
	}
	
	public void onSuccessFromLogin() {
		
	}
	
	public MyAccount onSuccessFromRegister() {
		this.userService.saveOrUpdate(this.user);
		System.out.println("xxxxxxxxxxxxxxxx  " + this.user.getId());
		this.myAccount.setId(this.user.getId());
		return this.myAccount;
	}
	
	public void onValidateFromRegister() {
		if((user.getPassword() != null) && (user.getRePassword() != null)) {
			if(!user.getPassword().equals(user.getRePassword())) {
				this.registerForm.recordError("两次密码输入不一致");
			}
		}
	}
	
}
