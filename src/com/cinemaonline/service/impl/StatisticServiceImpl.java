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
import com.cinemaonline.dao.ProfitDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.FilmReleasePlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.ProfitPlan;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.model.client.StatisticFilmAttendence;
import com.cinemaonline.model.client.StatisticHallAttendence;
import com.cinemaonline.model.client.StatisticProfitStatus;
import com.cinemaonline.model.client.StatisticTimeAttendence;
import com.cinemaonline.model.client.StatisticTypeAttendence;
import com.cinemaonline.service.StatisticService;
@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private FilmDao filmDao;
	@Autowired
	private ProfitDao profitDao;
	
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
		List<Film> filmlist = filmDao.getFilmByPlanTime(firstDay,lastDay);
		if(filmlist!=null){
		List<StatisticFilmAttendence> sfad = new ArrayList<StatisticFilmAttendence>();
		List<StatisticTypeAttendence> stad = new ArrayList<StatisticTypeAttendence>();
		for(Film temp:filmlist){
			StatisticFilmAttendence t = new StatisticFilmAttendence();
			StatisticTypeAttendence s = new StatisticTypeAttendence();
			t.setFilm(temp);
			s.setFilmType(temp.getFilmType());
			t.setAttendence(getFilmAttendenceByTime(temp.getFilmId(), firstDay, lastDay));
			s.setAttendence(t.getAttendence());
			sfad.add(t);
			stad.add(s);
		}
		info.setFilmAttendencelist(sfad);
		info.setTypeAttendencelist(stad);
		info.combineTypeAttendence();
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
		List<StatisticTimeAttendence> timead = new ArrayList<StatisticTimeAttendence>();
		for(int i = 1;i<24;i++){
			long timeb = i*60*60*1000;
			long timee = (i+1)*60*60*1000;
			StatisticTimeAttendence ta = new StatisticTimeAttendence();
			ta.setTime(i+"点~"+(i+1)+"点");
			ta.setAttendence(getTimeAttendenceByTime(timeb, timee, firstDay, lastDay));
			timead.add(ta);
		}
		info.setTimeAttendencelist(timead);
		List<ProfitPlan> pplist =  profitDao.getAllWorkingPlans();
		List<StatisticProfitStatus> spslist = new ArrayList<StatisticProfitStatus>();
		for(ProfitPlan temp:pplist){
			StatisticProfitStatus sps = new StatisticProfitStatus();
			sps.setProfitPlan(temp);
			Long profit = 0L;
			List<FilmProfitPlan> planlist = temp.getFilmProfitPlans();
			for(FilmProfitPlan ptemp:planlist){
				Film film = ptemp.getFilm();
				List<FilmPlan> fplist = film.getFilmPlans();
				List<FilmReleasePlan> frplist = filmDao.getFilmReleasePlanListByFilmId(film.getFilmId());
				if(frplist==null||frplist.size()==0){
					profit = (long) -film.getCost();
				}else{
					for(FilmPlan fptemp:fplist){
						profit += (fptemp.getHall().getSeats()-fptemp.getSeatSum())*(frplist.get(0).getPrice())-film.getCost();
					}
				}
			}
			sps.setProfit(profit);
			spslist.add(sps);
		}
		info.setProfitStatuslist(spslist);
		return info;
	}
	
	public double getHallAttendenceByTime(int hallNo,long month_begin,long month_end){
		return filmDao.getHallAttendenceByTime(hallNo,month_begin,month_end);
	}
	
	public double getFilmAttendenceByTime(long filmId,long month_begin,long month_end){
		return filmDao.getFilmAttendenceByTime(filmId,month_begin,month_end);
	}
	
	public double getTimeAttendenceByTime(long timeb,long timee,long month_begin,long month_end){
		return filmDao.getTimeAttendenceByTime(timeb,timee,month_begin,month_end);
	}
	
}
