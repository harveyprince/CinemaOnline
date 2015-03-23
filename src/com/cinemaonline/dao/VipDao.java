package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Location;
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

	public List<VipInfo> getVipForLevelPay();

	public int getVipSumByLocation(Location location);

	public int getVipSumByStatus(int status);
//	card
	public VipCard insertCard(VipCard info);
	
	public void updateCard(VipCard info);
//	level
	public VipLevel getLevelById(int levelid);
	
	public List<VipLevel> getAllLevel();
//	record
	public VipRecord insertRecord(VipRecord info);
	
	public List<VipRecord> getRecordsById(String userid);

	public double getConsumeSumByTime(long firstday, long lastday);
//	statistic
	public int getAge_0_10();

	public int getAge_10_20();

	public int getAge_20_30();

	public int getAge_30_40();

	public int getAge_40_50();

	public int getAge_50_60();

	public int getBoy_num();

	public int getGirl_num();




}
