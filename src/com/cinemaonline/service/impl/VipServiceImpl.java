package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.VipService;

@Service
public class VipServiceImpl implements VipService {

	@Autowired
	private VipDao vipDao;
	
	private VipServiceImpl(){}

	@Override
	public OperaResult vipinfoUpate(VipUpdate info_update,String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		info = info_update.setBase(info);
		vipDao.update(info);
		result.setResult(true);
		return result;
	}

	@Override
	public VipClientInfo getVipInfoForClient(String userid) {
		// TODO Auto-generated method stub
		VipClientInfo cinfo = new VipClientInfo();
		VipInfo info = vipDao.getVipInfoById(userid);
		cinfo.setByTable(info);
		return cinfo;
	}

	@Override
	public OperaResult cardActivatedCheck(String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		if(info.getVipCard()==null){
			result.setResult(false);
		}else{
			result.setResult(true);
		}
		return result;
	}

	@Override
	public OperaResult cardActivate(VipCardInfo info) {
		// TODO Auto-generated method stub
		VipCardInfo info_local = info;
		OperaResult result = new OperaResult();
		VipInfo info_temp = vipDao.getVipInfoById(info_local.getVipid());
		if(info_temp.getVipCard()!=null){
			result.setResult(false);
			result.setComment("alreadyexists");
		}else{
			info_local.setVipLevel(vipDao.getLevelById(info_local.getViplevel()));
			vipDao.insertCard(info_local.getCardInfo());
			result.setResult(true);
		}
		return result;
	}
}
