package com.cinemaonline.dao;

import com.cinemaonline.model.VipInfo;

public interface VipDao {
	
	public VipInfo getVipInfoByEmail(String email);
	
	public VipInfo insert(VipInfo info);
	
	public void update(VipInfo info);
	
	public VipInfo getVipInfoById(String userid);
}
