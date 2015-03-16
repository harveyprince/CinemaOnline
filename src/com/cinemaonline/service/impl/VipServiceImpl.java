package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.VipService;

@Service
public class VipServiceImpl implements VipService {

	@Autowired
	private VipDao vipDao;
	
	private VipServiceImpl(){}

	@Override
	public OperaResult vipinfoUpate(VipUpdate info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VipClientInfo getVipInfoForClient(String userid) {
		// TODO Auto-generated method stub
		VipClientInfo cinfo = new VipClientInfo();
		VipInfo info = vipDao.getVipInfoById(userid);
		cinfo.setByTable(info);
		return cinfo;
	}
}
