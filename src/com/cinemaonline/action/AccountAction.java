package com.cinemaonline.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;
@Repository
public class AccountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AccountService accountService;
	
	private String ajaxinfo;
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String welcome(){
		return SUCCESS;
	}
	
	public String loginJudge(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String accountname = request.getParameter("accountid");
		String password = request.getParameter("password");
		AccountLogin info = new AccountLogin();
		info.setAccountName(accountname);
		info.setPassword(password);
		OperaResult result = accountService.loginJudge(info);
		if(result.getResult()){
//			identity differs
			
		}else{
			System.out.println("login return error");
			ajaxinfo = result.getComment();
		}
		return SUCCESS;
	}
	
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}
}
