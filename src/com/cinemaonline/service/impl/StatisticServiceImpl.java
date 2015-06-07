package com.cinemaonline.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.dao.StatisticDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.StatisticLocation;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.StatisticAgeClient;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.model.client.StatisticFilmAttendence;
import com.cinemaonline.model.client.StatisticHallAttendence;
import com.cinemaonline.model.client.StatisticPayway;
import com.cinemaonline.model.client.StatisticPersonSumDay;
import com.cinemaonline.model.client.StatisticSexClient;
import com.cinemaonline.model.client.StatisticVipOperaClient;
import com.cinemaonline.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {
	@Autowired
	private StatisticDao statisticDao;
	@Autowired
	private VipDao vipDao;
	@Autowired
	private InfoDao infoDao;
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private TicketDao ticketDao;

	@Override
	public StatisticAgeClient getAgeStatic(int year, int month) {
		// TODO Auto-generated method stub
		return StatisticAgeClient.parseSAC(statisticDao.getAgeStatisticByTime(year, month));
	}

	@Override
	public StatisticSexClient getSexStatic(int year, int month) {
		// TODO Auto-generated method stub
		return StatisticSexClient.parseSSC(statisticDao.getSexStatisticByTime(year, month));
	}

	@Override
	public List<StatisticLocation> getLocationStatic(int year, int month) {
		// TODO Auto-generated method stub
		return statisticDao.getLocationStatisticByTime(year, month);
	}

	@Override
	public StatisticVipOperaClient getVipOperaStatic(int year, int month) {
		// TODO Auto-generated method stub
		return StatisticVipOperaClient.parseSVO(statisticDao.getCardStatusStatisticByTime(year, month), statisticDao.getVipOperaStatisticByTime(year, month));
	}

	@Override
	public StatisticCinemaClient getCinemaStatic(int year, int month) {
		// TODO Auto-generated method stub
//		////////////////////////////////////time opera////////////////////////////////////////////
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
		Date day = new Date();
		try {
			day = df.parse(year+(month<10?"-0":"-")+month);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
//		该月最后一天
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		long lastDay = cal.getTimeInMillis()+24*60*60*1000;
//		该月第一天
		cal.set(Calendar.DATE, 1);
		long firstDay = cal.getTimeInMillis();
//		////////////////////////////////////time opera////////////////////////////////////////////
		StatisticCinemaClient info = new StatisticCinemaClient();
		info.setCinemapersonsum_month(getCinemaPersonSumByMonth(firstDay,lastDay));
		if(info.getCinemapersonsum_month()!=0){
		List<StatisticPersonSumDay> spsd = new ArrayList<StatisticPersonSumDay>();
		for(int i = 1;i<=cal.getActualMaximum(Calendar.DATE);i++){
			cal.set(Calendar.DATE, i);
			StatisticPersonSumDay temp = new StatisticPersonSumDay();
			temp.setCal(cal.getTimeInMillis());
			temp.setPersonsum(getCinemaPersonSumByDay(cal));
			spsd.add(temp);
		}
		info.setCinemapersonsum_daylist(spsd);
		}
		List<Film> filmlist = filmDao.getFilmByPlanTime(firstDay,lastDay);
		if(filmlist!=null){
		List<StatisticFilmAttendence> sfad = new ArrayList<StatisticFilmAttendence>();
		for(Film temp:filmlist){
			StatisticFilmAttendence t = new StatisticFilmAttendence();
			t.setFilm(temp);
			t.setAttendence(getFilmAttendenceByTime(temp.getFilmId(), firstDay, lastDay));
			sfad.add(t);
		}
		info.setFilmAttendencelist(sfad);
		}
		List<Hall> halllist = filmDao.getAllHalls();
		List<StatisticHallAttendence> shad = new ArrayList<StatisticHallAttendence>();
		for(Hall temp:halllist){
			StatisticHallAttendence t = new StatisticHallAttendence();
			t.setHall(temp);
			t.setAttendence(getHallAttendenceByTime(temp.getHallNo(), firstDay, lastDay));
			shad.add(t);
		}
		info.setHallAttendencelist(shad);
		info.setPaywaylist(getpaywayStatistic(firstDay, lastDay));
		return info;
	}

//	////////////////////////////////////无参数——每月1号0时执行统计/////////////////////////////////////////////////////////
	@Override
	public OperaResult doStatic() {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
//		////////////////////////////////////time opera////////////////////////////////////////////
		SimpleDateFormat dfy=new SimpleDateFormat("yyyy");
		SimpleDateFormat dfm=new SimpleDateFormat("MM");
		Calendar cal = Calendar.getInstance();
//		设置为上个月
		cal.set(Calendar.DATE, 0);
		int year = Integer.parseInt(dfy.format(cal.getTime()));
		int month = Integer.parseInt(dfm.format(cal.getTime()));
//		上月最后一天
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		long lastDay = cal.getTimeInMillis();
//		上月第一天
		cal.set(Calendar.DATE, 1);
		long firstDay = cal.getTimeInMillis();
//		////////////////////////////////////time opera////////////////////////////////////////////
		doAgeStatic(year, month);
		doLocationStatic(year, month);
		doSexStatic(year, month);
		doVipOperaStatic(firstDay, lastDay, year, month);
		result.setResult(true);
		return result;
	}
	
//	/////////////////////////////////无法从源记录按月查找的数据//////////////////////////////////////
	public OperaResult doAgeStatic(int year,int month){
//		///////////////////////////////////////仅统计正常用户////////////////////////////////////////
		OperaResult result = new OperaResult();
		StatisticAgeClient info = new StatisticAgeClient();
		info.setAge_0_10(vipDao.getAge_0_10());
		info.setAge_10_20(vipDao.getAge_10_20());
		info.setAge_20_30(vipDao.getAge_20_30());
		info.setAge_30_40(vipDao.getAge_30_40());
		info.setAge_40_50(vipDao.getAge_40_50());
		info.setAge_50_60(vipDao.getAge_50_60());
		info.setYear(year);
		info.setMonth(month);
		statisticDao.insertAgeStatistic(info.get_0_10_model());
		statisticDao.insertAgeStatistic(info.get_10_20_model());
		statisticDao.insertAgeStatistic(info.get_20_30_model());
		statisticDao.insertAgeStatistic(info.get_30_40_model());
		statisticDao.insertAgeStatistic(info.get_40_50_model());
		statisticDao.insertAgeStatistic(info.get_50_60_model());
		result.setResult(true);
		return result;
	}
	
	public OperaResult doSexStatic(int year,int month){
//		///////////////////////////////////////仅统计正常用户////////////////////////////////////////
		OperaResult result = new OperaResult();
		StatisticSexClient info = new StatisticSexClient();
		info.setBoy_num(vipDao.getBoy_num());
		info.setGirl_num(vipDao.getGirl_num());
		info.setYear(year);
		info.setMonth(month);
		statisticDao.insertSexStatistic(info.getBoy_model());
		statisticDao.insertSexStatistic(info.getGirl_model());
		result.setResult(true);
		return result;
	}
	
	public OperaResult doLocationStatic(int year,int month){
//		///////////////////////////////////////仅统计正常用户////////////////////////////////////////
		OperaResult result = new OperaResult();
		List<Location> locationlist = infoDao.getLocationWithVips();
		for(Location location:locationlist){
			StatisticLocation st = new StatisticLocation();
			st.setLocation(location);
			st.setMonth(month);
			st.setYear(year);
			st.setPersonsum(vipDao.getVipSumByLocation(location));
			statisticDao.insertLocationStatistic(st);
		}
		result.setResult(true);
		return result;
	}
	
	public OperaResult doVipOperaStatic(long firstday,long lastday,int year,int month){
		OperaResult result = new OperaResult();
		StatisticVipOperaClient vos = new StatisticVipOperaClient();
		vos.setYear(year);
		vos.setMonth(month);
		vos.setConsume_sum(vipDao.getConsumeSumByTime(firstday,lastday));
		vos.setStatus_1_sum(vipDao.getVipSumByStatus(1));
		vos.setStatus_2_sum(vipDao.getVipSumByStatus(2));
		vos.setStatus_4_sum(vipDao.getVipSumByStatus(4));
		vos.setStatus_5_sum(vipDao.getVipSumByStatus(5));
		statisticDao.insertCardStatusStatistic(vos.getStatus_1_model());
		statisticDao.insertCardStatusStatistic(vos.getStatus_2_model());
		statisticDao.insertCardStatusStatistic(vos.getStatus_4_model());
		statisticDao.insertCardStatusStatistic(vos.getStatus_5_model());
		statisticDao.insertVipOperaStatistic(vos.getVipOpera_model());
		result.setResult(true);
		return result;
	}
	
//	////////////////////////////////////可以从源记录按月查找的数据////////////////////////////////////////////////
	public int getCinemaPersonSumByDay(Calendar cal){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = df.format(cal.getTime());
		try {
			long day_begin = dft.parse(time+" 00:00").getTime();
			long day_end = dft.parse(time+" 23:59").getTime();
			return filmDao.getPersonSumByTime(day_begin,day_end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	
	public int getCinemaPersonSumByMonth(long month_begin,long month_end){
		return filmDao.getPersonSumByTime(month_begin,month_end);
	}
	
	public double getHallAttendenceByTime(int hallNo,long month_begin,long month_end){
		return filmDao.getHallAttendenceByTime(hallNo,month_begin,month_end);
	}
	
	public double getFilmAttendenceByTime(long filmId,long month_begin,long month_end){
		return filmDao.getFilmAttendenceByTime(filmId,month_begin,month_end);
	}
	
	public int getPersonSumByPayWay(int payway,long month_begin,long month_end){
		return ticketDao.getRecordSumByPayWay(payway,month_begin,month_end);
	}
	
	public List<StatisticPayway> getpaywayStatistic(long month_begin,long month_end){
		List<StatisticPayway> list = new ArrayList<StatisticPayway>();
		for(int i = 0; i<3;i++){
			StatisticPayway t = new StatisticPayway();
			t.setPayway(i);
			t.setSum(getPersonSumByPayWay(i, month_begin, month_end));
			list.add(t);
		}
		return list;
	}
}
