package com.cinemaonline.service.impl;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;
	private AccountServiceImpl(){}
	
//	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public OperaResult loginJudge(AccountLogin info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult signupJudge(AccountSignUp signup) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
}
