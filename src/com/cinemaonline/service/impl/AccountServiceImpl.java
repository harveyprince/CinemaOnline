package com.cinemaonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private VipDao vipDao;
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
	public OperaResult signupJudge(AccountSignUp info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		OperaResult result_check = signupCheckByEmail(info.getEmail()); 
		if(result_check.getResult()){
			Account ac = info.getAccount();
			ac = accountDao.insert(ac);
			ac.setAccountName(produceVipId(ac.getAccountId()));
			accountDao.update(ac);
			VipInfo vi = info.constructVipInfo(ac);
			vipDao.insert(vi);
			result.setResult(true);
		}else{
			result = result_check;
		}
		
		return result;
	}
	
	@Override
	public OperaResult signupCheckByEmail(String email) {
		// TODO Auto-generated method stub
		VipInfo vi_sql = vipDao.getVipInfoByEmail(email);
		OperaResult result = new OperaResult();
		if(vi_sql==null){
			result.setResult(true);
		}else{
			result.setResult(false);
			result.setComment("the same email exists");
		}
		return result;
	}
	
	public String produceVipId(long basenum){
		Date day = new Date();
		long num = Math.round(Math.sqrt(day.getTime()));
		num += basenum;
		return num+"";
	}

}
