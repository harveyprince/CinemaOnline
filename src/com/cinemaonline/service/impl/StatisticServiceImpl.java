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
import com.cinemaonline.model.Film;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.model.client.StatisticFilmAttendence;
import com.cinemaonline.model.client.StatisticHallAttendence;
import com.cinemaonline.model.client.StatisticTypeAttendence;
import com.cinemaonline.service.StatisticService;
@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private FilmDao filmDao;
	
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
		return info;
	}
	
	public double getHallAttendenceByTime(int hallNo,long month_begin,long month_end){
		return filmDao.getHallAttendenceByTime(hallNo,month_begin,month_end);
	}
	
	public double getFilmAttendenceByTime(long filmId,long month_begin,long month_end){
		return filmDao.getFilmAttendenceByTime(filmId,month_begin,month_end);
	}
	
	
	
}
