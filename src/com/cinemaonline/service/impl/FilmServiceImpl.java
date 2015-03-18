package com.cinemaonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	
	@Override
	public List<FilmPlanInfo> getAllUnoldPlans() {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllUnpassedPlans());
		return plans;
	}

	@Override
	public List<Film> getAllReleasingFilms() {
		// TODO Auto-generated method stub
		return filmDao.getAllReleasingFilms();
	}

	@Override
	public List<Hall> getAllHalls() {
		// TODO Auto-generated method stub
		return filmDao.getAllHalls();
	}

	@Override
	public OperaResult addPlan(FilmPlanInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlanInfo info_local = info;
//		先获取film\hall
		info_local.setFilm(filmDao.getFilmById(info_local.getFilmid()));
		info_local.setHall(filmDao.getHallById(info_local.getHallNo()));
		filmDao.insertFilmPlan(info_local.getFilmPlan());
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult updatePlan(FilmPlanInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlan info_old = filmDao.getFilmPlanById(info.getPlanid());
//		先获取film/hall/plan
		info_old.setFilm(filmDao.getFilmById(info.getFilmid()));
		info_old.setHall(filmDao.getHallById(info.getHallNo()));
		info_old.setBeginTime(info.getBeginTime());
		info_old.setEndTime(info.getEndTime());
		info_old.setPrice(info.getPrice());
		info_old.setSeatSum(info.getSeatSum());
		info_old.setStatus(info.getStatus());
		filmDao.updateFilmPlan(info_old);
		result.setResult(true);
		return result;
	}

}
