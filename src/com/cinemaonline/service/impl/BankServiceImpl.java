package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.BankDao;
import com.cinemaonline.model.Bank;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.BankService;
@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDao bankDao;
	@Override
	public OperaResult pay(BankOperaInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Bank bank = bankDao.findById(info.getUserId());
		if(bank==null){
			result.setResult(false);
			result.setComment("bankidnotfound");
		}
		if(bank.getPassword().equals(info.getPassword())){
			double bank_left = bank.getBalance();
			double info_now = info.getOperateNum();
			if((bank_left+info_now)<0){
				result.setResult(false);
				result.setComment("notenough");
			}else{
				bank.setBalance(bank_left+info_now);
				bankDao.update(bank);
				result.setResult(true);
				
			}
		}else{
			result.setResult(false);
			result.setComment("bankpserror");
		}
		return result;
	}

}
