package com.cinemaonline.dao;

import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.VipLevel;

public interface VipDao {
	
	public VipInfo getVipInfoByEmail(String email);
	
	public VipInfo insert(VipInfo info);
	
	public void update(VipInfo info);
	
	public VipInfo getVipInfoById(String userid);
	
	public VipCard insertCard(VipCard info);
	
	public VipLevel getLevelById(int levelid);
}
