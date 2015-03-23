package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.StatisticAge;
import com.cinemaonline.model.StatisticCardStatus;
import com.cinemaonline.model.StatisticLocation;
import com.cinemaonline.model.StatisticSex;
import com.cinemaonline.model.StatisticVipOpera;

public interface StatisticDao {

	public void insertAgeStatistic(StatisticAge info);
	
	public List<StatisticAge> getAgeStatisticByTime(int year,int month);

	public void insertSexStatistic(StatisticSex info);
	
	public List<StatisticSex> getSexStatisticByTime(int year,int month);

	public void insertLocationStatistic(StatisticLocation info);
	
	public List<StatisticLocation> getLocationStatisticByTime(int year,int month);

	public void insertCardStatusStatistic(StatisticCardStatus info);
	
	public List<StatisticCardStatus> getCardStatusStatisticByTime(int year,int month);

	public void insertVipOperaStatistic(StatisticVipOpera info);

	public StatisticVipOpera getVipOperaStatisticByTime(int year,int month);

}
