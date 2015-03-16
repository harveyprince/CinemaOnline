package com.cinemaonline.service;

import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipUpdate;

public interface VipService {
	public OperaResult vipinfoUpate(VipUpdate info);
	
	public VipClientInfo getVipInfoForClient(String userid);
}
