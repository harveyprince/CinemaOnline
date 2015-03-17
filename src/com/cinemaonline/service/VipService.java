package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.model.client.VipUpdate;

public interface VipService {
	public OperaResult vipinfoUpate(VipUpdate info,String userid);
	
	public VipClientInfo getVipInfoForClient(String userid);
	
	public VipCardInfo getVipCardInfoForClient(String userid);
	
	public OperaResult cardActivatedCheck(String userid);
	
	public OperaResult cardActivate(VipCardInfo info);
	
	public OperaResult cardLevelCost(String userid);
	
	public OperaResult cardBalanceOpera(VipOperaInfo info);
	
	public List<VipLevel> getLvList();
	
	public List<VipRecordInfo> getRecords(String userid);
}
