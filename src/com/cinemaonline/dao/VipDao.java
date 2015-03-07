package com.cinemaonline.dao;

import com.cinemaonline.model.client.ActivityJoin;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;

public interface VipDao {
	
	public OperaResult addVip(VipClientInfo info);
	
	public OperaResult consume(VipOperaInfo info);

	public OperaResult saveIn(VipOperaInfo info);
	
	public OperaResult joinActivity(ActivityJoin join);
	
	public OperaResult modifyInfo(VipClientInfo info);
}
