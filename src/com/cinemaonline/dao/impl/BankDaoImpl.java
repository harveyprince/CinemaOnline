package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BankDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;

@Repository
public class BankDaoImpl implements BankDao {
	@Autowired
	private BaseDao baseDao;
	public BankDaoImpl(){}

	@Override
	public OperaResult saveIn(BankOperaInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult consume(BankOperaInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
