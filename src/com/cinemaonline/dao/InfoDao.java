package com.cinemaonline.dao;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.VipLevel;

public interface InfoDao {
//	identity
	public Identity insertIdentity(Identity info);
	
//hall
	public Hall insertHall(Hall info);
	
//	viplevel
	public VipLevel insertVipLevel(VipLevel info);
}
