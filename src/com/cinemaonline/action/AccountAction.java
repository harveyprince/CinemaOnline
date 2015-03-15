package com.cinemaonline.action;

import com.cinemaonline.service.AccountService;

public class AccountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String welcome(){
		return SUCCESS;
	}
	
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
