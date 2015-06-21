package com.cinemaonline.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.dao.ProfitDao;
import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.ProfitPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmProfitFromClient;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.ProfitPlanInfo;
import com.cinemaonline.service.ProfitService;

@Service
public class ProfitServiceImpl implements ProfitService {

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private ProfitDao profitDao;
	@Autowired
	private FilmDao filmDao;
	
	@Override
	public OperaResult addProfitPlan(ProfitPlanInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		ProfitPlan profitPlan = new ProfitPlan();
		profitPlan.setProfitSum(info.getProfitsum());
		Date now = new Date();
		profitPlan.setPublishTime(now.getTime());
		profitPlan.setStatus(1);
		profitPlan = profitDao.insertProfitPlan(profitPlan);
		String[] films = info.getFilms();
		for(String temp:films){
			if(!profitDao.isFilmExist(Long.parseLong(temp))){
				FilmProfitPlan filmProfitPlan = new FilmProfitPlan();
				filmProfitPlan.setFilm(filmDao.getFilmById(Long.parseLong(temp)));
				filmProfitPlan.setProfitPercent((double)100/films.length);
				filmProfitPlan.setProfitPlan(profitPlan);
				profitDao.insertFilmProfitPlan(filmProfitPlan);
			}else{
				result.setResult(false);
				result.setComment("电影已存在盈利计划");
				return result;
			}
		}
		result.setResult(true);
		return result;
	}

	@Override
	public List<FilmInfo> getAllUnplanedFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(profitDao.getAllUnplanedFilms());
	}

	@Override
	public List<ProfitPlan> getAllWorkingPlans() {
		// TODO Auto-generated method stub
		return profitDao.getAllWorkingPlans();
	}
	
	@Override
	public List<ProfitPlan> getAllWorkingUndispatchPlans() {
		// TODO Auto-generated method stub
		return profitDao.getAllWorkingUndispatchPlans();
	}

	@Override
	public List<FilmProfitPlan> getProfitDispatchByPlanId(String id) {
		// TODO Auto-generated method stub
		return profitDao.getProfitDispatchByPlanId(id);
	}

	@Override
	public OperaResult submitProfitDispatch(
			List<FilmProfitFromClient> filmProfitPercentlist) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		ProfitPlan pp = null;
		for(FilmProfitFromClient temp:filmProfitPercentlist){
			FilmProfitPlan fpp = profitDao.getFilmProfitPlanByFilmId(temp.getFilmId());
			fpp.setProfitPercent(temp.getProfitPercent());
			if(pp==null){
				pp=fpp.getProfitPlan();
				pp.setStatus(2);
				baseDao.update(pp);
			}
			baseDao.update(fpp);
		}
		result.setResult(true);
		return result;
	}

	@Override
	public List<ProfitPlan> getWorkingDispatchedProfitPlan() {
		// TODO Auto-generated method stub
		return profitDao.getAllWorkingDispatchPlans();
	}

	

}
