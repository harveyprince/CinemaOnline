package com.cinemaonline.service;

import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipUpdate;

public interface VipService {
	public OperaResult vipinfoUpate(VipUpdate info,String userid);
	
	public VipClientInfo getVipInfoForClient(String userid);
	
	public OperaResult cardActivatedCheck(String userid);
	
	public OperaResult cardActivate(VipCardInfo info);
}
