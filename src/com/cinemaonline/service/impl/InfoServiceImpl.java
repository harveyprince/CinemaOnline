package com.cinemaonline.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.dao.BankDao;
import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.Bank;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.InfoService;
@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	private BankDao bankDao;
	@Autowired
	private InfoDao infoDao;
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public OperaResult addHall(Hall info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Hall info_local = info;
		info_local = infoDao.insertHall(info_local);
		result.setResult(true);
		return result;
	}
	@Override
	public OperaResult addBank(Bank info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Bank info_local = info;
		info_local = bankDao.insert(info_local);
		result.setResult(true);
		return result;
	}
	@Override
	public OperaResult addIdentity(Identity info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Identity info_local = info;
		info_local = infoDao.insertIdentity(info_local);
		result.setResult(true);
		return result;
	}
	@Override
	public OperaResult addVipLevel(VipLevel info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipLevel info_local = info;
		info_local = infoDao.insertVipLevel(info_local);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult addAccount(Account info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
			accountDao.insert(info);
			result.setResult(true);
		return result;
	}

	

}
