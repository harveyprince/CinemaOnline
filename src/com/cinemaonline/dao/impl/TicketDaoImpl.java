package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;

@Repository
public class TicketDaoImpl implements TicketDao {
	@Autowired
	private BaseDao baseDao;
	public TicketDaoImpl(){}

	@Override
	public OperaResult sellTicket(TicketOrder order) {
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
