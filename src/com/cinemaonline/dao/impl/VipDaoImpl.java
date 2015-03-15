package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.client.ActivityJoin;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;

@Repository
public class VipDaoImpl implements VipDao {
	@Autowired
	private BaseDao baseDao;
	public VipDaoImpl(){}

	@Override
	public OperaResult addVip(VipClientInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult consume(VipOperaInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult saveIn(VipOperaInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult joinActivity(ActivityJoin join) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult modifyInfo(VipClientInfo info) {
		// TODO Auto-generated method stub
		return null;
	}


}
