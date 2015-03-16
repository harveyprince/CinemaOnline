package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BankDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.Bank;

@Repository
public class BankDaoImpl implements BankDao {
	@Autowired
	private BaseDao baseDao;
	public BankDaoImpl(){}

	@Override
	public Bank findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Bank bank) {
		// TODO Auto-generated method stub
		
	}

}
