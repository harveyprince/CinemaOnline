package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	private AccountServiceImpl(){}
	
//	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public OperaResult loginJudge(AccountLogin info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		String ac = info.getAccountName();
		Account ac_sql = accountDao.findByAccountName(ac);
		if(ac_sql==null){
			result.setResult(false);
			result.setComment("usernotfound");
		}else{
			if(ac_sql.getPassword().equals(info.getPassword())){
				result.setResult(true);
				result.setStatus(ac_sql.getIdentityId());;
			}else{
				result.setResult(false);
				result.setComment("pserror");
			}
		}
		return result;
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
