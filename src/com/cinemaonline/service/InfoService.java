package com.cinemaonline.service;

import com.cinemaonline.model.Bank;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.OperaResult;

public interface InfoService {

	public OperaResult addHall(Hall info);
	
	public OperaResult addBank(Bank info);
	
	public OperaResult addIdentity(Identity info);
	
	public OperaResult addVipLevel(VipLevel info);
}
