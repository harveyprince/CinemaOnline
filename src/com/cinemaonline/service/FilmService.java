package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.FilmType;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.CalenderEvent;
import com.cinemaonline.model.client.CalenderEventFromClient;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.FilmReleasePlanFromClient;
import com.cinemaonline.model.client.HallLimit;
import com.cinemaonline.model.client.OperaResult;

public interface FilmService {

	public List<FilmPlanInfo> getAllUnoldPlans();

	public List<FilmPlanInfo> getAllPassedPlansNotOld();
	
	public List<FilmInfo> getAllReleasingFilms();
	
	public List<FilmInfo> getAllFilms();
	
	public List<Hall> getAllHalls();
	
	public OperaResult addFilm(FilmInfo info);
	
	public OperaResult updateFilm(FilmInfo info);
	
	public OperaResult addPlan(FilmPlanInfo info);
	
	public OperaResult updatePlan(FilmPlanInfo info);

	public OperaResult releaseFilm(String filmid);

	public OperaResult unreleaseFilm(String filmid);

	public OperaResult submitPlanForCheck(String planid);

	public List<FilmPlanInfo> getPlansForCheck();

	public OperaResult passPlan(String planid);

	public OperaResult unpassPlan(String planid);

	public List<FilmPlanInfo> getAllCheckedUnoldPlans();

	public List<FilmInfo> getAllFilmsByPage(int page);

	public List<FilmPlanInfo> getAllUnoldPlansByPage(int page);

	public List<FilmPlanInfo> getAllPassedPlansNotOldByPage(int page);

	public List<FilmPlanInfo> getAllPassedPlansOldByPage(int page);

	public List<FilmInfo> getAllOldFilmsByPage(int page);

	public List<FilmPlanInfo> getPlansForCheckByPage(int page);

	public List<FilmPlanInfo> getAllCheckedUnoldPlansByPage(int page);

	public List<FilmInfo> getAllReleaseFilmsByPage(int page);

	public List<FilmType> getAllFilmTypes();

	public List<FilmInfo> getAllUnplanedFilms();

	public OperaResult addFilmReleasePlan(
			FilmReleasePlanFromClient filmReleasePlan);

	public List<FilmInfo> getAllPlanedFilms();

	public List<CalenderEvent> getCalenderListByDate(Long date);
	
	public List<CalenderEvent> getCalenderListByDateAndHall(Long date,int hallNo);

	public OperaResult addFilmPlanByCalender(
			List<CalenderEventFromClient> calenderClientlist);

	public void updateHallLimit(List<HallLimit> halllimitlist);

}
