package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.StatisticLocation;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.StatisticAgeClient;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.model.client.StatisticSexClient;
import com.cinemaonline.model.client.StatisticVipOperaClient;

public interface StaticsService {

	public StatisticAgeClient getAgeStatic(int year,int month);
	
	public StatisticSexClient getSexStatic(int year,int month);
	
	public List<StatisticLocation> getLocationStatic(int year,int month);
	
	public StatisticVipOperaClient getVipOperaStatic(int year,int month);
	
	public StatisticCinemaClient getCinemaStatic(int year,int month);
	
	public OperaResult doStatic();
}
