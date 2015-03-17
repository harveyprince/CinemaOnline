package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.VipRecord;

public interface VipDao {
//	info
	public VipInfo getVipInfoByEmail(String email);
	
	public VipInfo insert(VipInfo info);
	
	public void update(VipInfo info);
	
	public VipInfo getVipInfoById(String userid);
//	card
	public VipCard insertCard(VipCard info);
	
	public void updateCard(VipCard info);
//	level
	public VipLevel getLevelById(int levelid);
	
	public List<VipLevel> getAllLevel();
//	record
	public VipRecord insertRecord(VipRecord info);
	
	public List<VipRecord> getRecordsById(String userid);
}
