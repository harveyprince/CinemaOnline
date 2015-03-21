package com.cinemaonline.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmInfo;
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
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllUnoldPlans());
		return plans;
	}

	@Override
	public List<FilmPlanInfo> getAllPassedPlans() {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllPassedPlans());
		return plans;
	}

	@Override
	public List<FilmInfo> getAllReleasingFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllReleasingFilms());
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
		//上映时间不得比现在早
		Date time = new Date();
		long timenow = time.getTime();
		if(info.getBeginTime()<timenow){
			result.setResult(false);
			result.setComment("cannot insert a plan into the old time");
			return result;
		}
		//begintime不得大于endtime
		if(info.getBeginTime()>=info.getEndTime()){
			result.setResult(false);
			result.setComment("begin time cannot bigger than end time");
			return result;
		}
//		检测时空冲突
		OperaResult check_result = filmDao.checkFilmPlan(info_local.getBeginTime(),info_local.getEndTime(),filmDao.getHallById(info_local.getHallNo()));
		if(check_result.getResult()){
//		先获取film\hall
			info_local.setFilm(filmDao.getFilmById(info_local.getFilmid()));
			info_local.setHall(filmDao.getHallById(info_local.getHallNo()));
			filmDao.insertFilmPlan(info_local.getFilmPlan());
			result.setResult(true);
		}else{
			result = check_result;
		}
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

	@Override
	public List<FilmInfo> getAllFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllFilms());
	}

	@Override
	public OperaResult addFilm(FilmInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		filmDao.insertFilm(info.getFilm());
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult updateFilm(FilmInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Film f = filmDao.getFilmById(info.getFilmId());
		f.setDuration(info.getDuration());
		f.setKind(info.getKind());
		f.setName(info.getName());
		f.setStatus(info.getStatus());
		f.setReleaseTime(info.getReleaseTime());
		f.setShelvesTime(info.getReleaseTime());
		filmDao.updateFilm(f);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult releaseFilm(String filmid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Film f = filmDao.getFilmById(Long.parseLong(filmid));
		f.setStatus(1);
		f.setReleaseTime(new java.sql.Date((new java.util.Date()).getTime()));
		filmDao.updateFilm(f);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult unreleaseFilm(String filmid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Film f = filmDao.getFilmById(Long.parseLong(filmid));
		f.setStatus(0);
		f.setShelvesTime(new java.sql.Date((new java.util.Date()).getTime()));
		filmDao.updateFilm(f);
//		活动评测------------------------------------------------------------------------------------------待续
//		计划未结束-----------------------------------------------------------------------------------禁止下架
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult submitPlanForCheck(String planid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlan info = filmDao.getFilmPlanById(Long.parseLong(planid));
		info.setStatus(1);
		filmDao.updateFilmPlan(info);
		result.setResult(true);
		return result;
	}

	@Override
	public List<FilmPlanInfo> getPlansForCheck() {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getPlansForCheck());
		return plans;
	}

	@Override
	public OperaResult passPlan(String planid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlan plan = filmDao.getFilmPlanById(Long.parseLong(planid));
		plan.setStatus(2);
		filmDao.updateFilmPlan(plan);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult unpassPlan(String planid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlan plan = filmDao.getFilmPlanById(Long.parseLong(planid));
		plan.setStatus(3);
		filmDao.updateFilmPlan(plan);
		result.setResult(true);
		return result;
	}


}
