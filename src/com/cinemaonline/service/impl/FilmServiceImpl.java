package com.cinemaonline.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.FilmReleasePlan;
import com.cinemaonline.model.FilmType;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.CalenderEvent;
import com.cinemaonline.model.client.CalenderEventFromClient;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.FilmReleasePlanFromClient;
import com.cinemaonline.model.client.HallLimit;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<FilmPlanInfo> getAllUnoldPlans() {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllUnoldPlans());
		return plans;
	}
	
	@Override
	public List<FilmPlanInfo> getAllUnoldPlansByPage(int page) {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllUnoldPlansByPage(page));
		return plans;
	}

	@Override
	public List<FilmPlanInfo> getAllPassedPlansNotOld() {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllPassedPlansNotOld());
		return plans;
	}
	
	@Override
	public List<FilmPlanInfo> getAllPassedPlansNotOldByPage(int page) {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllPassedPlansNotOldByPage(page));
		return plans;
	}
	
	@Override
	public List<FilmPlanInfo> getAllPassedPlansOldByPage(int page) {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getAllPassedPlansOldByPage(page));
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
	public List<FilmType> getAllFilmTypes() {
		// TODO Auto-generated method stub
		return filmDao.getAllFilmTypes();
	}

	@Override
	public OperaResult addPlan(FilmPlanInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		FilmPlanInfo info_local = info;
		Hall hall = filmDao.getHallById(info.getHallNo());
		if(info.getSeatSum()>hall.getSeats()){
			result.setResult(false);
			result.setComment("this hall do not have such much seats");
			return result;
		}
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
		Hall hall = filmDao.getHallById(info.getHallNo());
		if(info.getSeatSum()>hall.getSeats()){
			result.setResult(false);
			result.setComment("this hall do not have such much seats");
			return result;
		}
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
		OperaResult check_result = filmDao.checkFilmPlanForUpdate(info.getPlanid(),info.getBeginTime(),info.getEndTime(),filmDao.getHallById(info.getHallNo()));
		if(check_result.getResult()){
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
		}else{
			result = check_result;
		}
		return result;
	}

	@Override
	public List<FilmInfo> getAllFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllFilms());
	}
	
	@Override
	public List<FilmInfo> getAllFilmsByPage(int page) {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllUnreleasedFilmsByPage(page));
	}
	
	@Override
	public List<FilmInfo> getAllOldFilmsByPage(int page) {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllOldFilmsByPage(page));
	}
	
	@Override
	public List<FilmInfo> getAllReleaseFilmsByPage(int page) {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllReleaseFilmsByPage(page));
	}

	@Override
	public OperaResult addFilm(FilmInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		info.setKind(filmDao.getFilmTypeById(info.getTypeId()));
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
		f.setFilmType(filmDao.getFilmTypeById(info.getTypeId()));
		f.setName(info.getName());
		f.setStatus(info.getStatus());
		f.setReleaseTime(info.getReleaseTime());
		f.setShelvesTime(info.getReleaseTime());
		f.setCost(info.getCost());
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
		filmDao.updateFilm(f);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult unreleaseFilm(String filmid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Film f = filmDao.getFilmById(Long.parseLong(filmid));
//		计划未结束-----------------------------------------------------------------------------------禁止下架
		List<FilmPlan> futureplan = filmDao.getAllNotEndedPlansByFilm(f);
		if(futureplan!=null){
			result.setResult(false);
			result.setComment("the plan is still working");
			return result;
		}
		f.setStatus(0);
		f.setShelvesTime(new java.sql.Date((new java.util.Date()).getTime()));
		filmDao.updateFilm(f);
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
	public List<FilmPlanInfo> getPlansForCheckByPage(int page) {
		// TODO Auto-generated method stub
		List<FilmPlanInfo> plans = FilmPlanInfo.parseFPI(filmDao.getPlansForCheckByPage(page));
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

	@Override
	public List<FilmPlanInfo> getAllCheckedUnoldPlans() {
		// TODO Auto-generated method stub
		return FilmPlanInfo.parseFPI(filmDao.getAllCheckedUnoldPlans());
	}
	
	@Override
	public List<FilmPlanInfo> getAllCheckedUnoldPlansByPage(int page) {
		// TODO Auto-generated method stub
		return FilmPlanInfo.parseFPI(filmDao.getAllCheckedUnoldPlansByPage(page));
	}

	@Override
	public List<FilmInfo> getAllUnplanedFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllUnplanedFilms());
	}
	
	@Override
	public List<FilmInfo> getAllPlanedFilms() {
		// TODO Auto-generated method stub
		return FilmInfo.parseFI(filmDao.getAllPlanedFilms());
	}

	@Override
	public OperaResult addFilmReleasePlan(
			FilmReleasePlanFromClient info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Film film = filmDao.getFilmById(info.getFilmId());
		Long beginTime = info.getBeginTime();
		Long endTime = info.getBeginTime()+info.getDayslength()*24*60*60*1000;
		int idx = 0;
		for(int hallNo:info.getHallNolist()){
			if(!JudgeFilmReleasePlanInsertable(beginTime,endTime,info.getPlayTimeslist().get(idx),hallNo)){
				result.setResult(false);
				result.setComment("超过了当日最大限制");
				return result;
			}
			idx++;
		}
		idx = 0;
		for(int hallNo:info.getHallNolist()){
			Hall hall = filmDao.getHallById(hallNo);
			FilmReleasePlan frp = new FilmReleasePlan();
			frp.setFilm(film);
			frp.setHall(hall);
			frp.setPlayTimes(info.getPlayTimeslist().get(idx));
			frp.setBeginTime(info.getBeginTime());
			frp.setEndTime(info.getBeginTime()+info.getDayslength()*24*60*60*1000);
			frp.setPrice(info.getPrice());
			baseDao.save(frp);
			idx++;
		}
		result.setResult(true);
		return result;
	}
	
	private boolean JudgeFilmReleasePlanInsertable(Long beginTime,Long endTime,int playtimes,int hallNo){
		for(Long now = beginTime;now<endTime;now+=24*60*60*1000){
			int dayPlayTimes = filmDao.getDayPlayTimes(hallNo,now);
			Hall hall = filmDao.getHallById(hallNo);
			if(dayPlayTimes+playtimes>hall.getTimes()){
				return false;
			}
		}
		return true;
	}

	@Override
	public List<CalenderEvent> getCalenderListByDate(Long date) {
		// TODO Auto-generated method stub
		/*
		 * 本方法处于废弃状态
		 * 未进行实现
		 * */
		List<FilmReleasePlan> frplist = filmDao.getFilmReleasePlanListByDate(date);
		return null;
	}

	@Override
	public List<CalenderEvent> getCalenderListByDateAndHall(Long date,
			int hallNo) {
		// TODO Auto-generated method stub
		List<CalenderEvent> eventlist = new ArrayList<CalenderEvent>();
		List<FilmReleasePlan> frplist = filmDao.getFilmReleasePlanListByDateAndHall(date,hallNo);
		for(FilmReleasePlan temp:frplist){
			int times = temp.getPlayTimes();
			Film film = temp.getFilm();
			for(int i = 0;i<times;i++){
				CalenderEvent event = new CalenderEvent();
				event.setFilm(film);
				eventlist.add(event);
			}
		}
		return eventlist;
	}

	@Override
	public OperaResult addFilmPlanByCalender(
			List<CalenderEventFromClient> info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		for(CalenderEventFromClient temp:info){
			FilmPlanInfo fpinfo = new FilmPlanInfo();
			fpinfo.setBeginTime(temp.getStart());
			fpinfo.setEndTime(temp.getStart()+2*60*60*1000);
			Film film = filmDao.getFilmById(temp.getFilmId());
			fpinfo.setFilm(film);
			Hall hall = filmDao.getHallById(temp.getHallNo());
			fpinfo.setHall(hall);
			fpinfo.setSeatSum(hall.getSeats());
			fpinfo.setPrice(film.getFilmReleasePlanlist().get(0).getPrice());
			fpinfo.setStatus(0);
			OperaResult re = addPlan(fpinfo);
			result = re;
		}
		return result;
	}

	@Override
	public void updateHallLimit(List<HallLimit> halllimitlist) {
		// TODO Auto-generated method stub
		for(HallLimit temp:halllimitlist){
			Hall hall = filmDao.getHallById(temp.getHallNo());
			hall.setTimes(temp.getTimes());
			baseDao.update(hall);
		}
	}

}
