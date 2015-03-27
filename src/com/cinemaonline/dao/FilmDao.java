package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;

public interface FilmDao {
//	film
	public Film insertFilm(Film info);
	
	public Film updateFilm(Film info);
	
	public List<Film> getAllReleasingFilms();
	
	public List<Film> getAllFilms();

	public List<Film> getAllFilmsByPage(int page);
	
	public Film getFilmById(long id);

	public List<Film> getReleasingFilmsByActivityId(long activityId);
//	film plan
	public FilmPlan insertFilmPlan(FilmPlan info);
	
	public void updateFilmPlan(FilmPlan info);

	public List<FilmPlan> getAllUnoldPlans();

	public List<FilmPlan> getAllUnoldPlansByPage(int page);

	public List<FilmPlan> getAllNotEndedPlansByFilm(Film info);
	
	public List<FilmPlan> getAllPassedPlansNotOld();
	
	public FilmPlan getFilmPlanById(long id);
	
	public List<FilmPlan> getPlansForCheck();
	
	public List<FilmPlan> getPlansForCheckByPage(int page);

	public OperaResult checkFilmPlan(long beginTime, long endTime, Hall hall);

	public List<FilmPlan> getAllCheckedUnoldPlans();
	
	public List<FilmPlan> getAllCheckedUnoldPlansByPage(int page);
//	hall
	public List<Hall> getAllHalls();
	
	public Hall getHallById(int id);

//statistic
	public int getPersonSumByTime(long begin, long end);

	public double getHallAttendenceByTime(int hallNo, long begin, long end);

	public double getFilmAttendenceByTime(long filmId, long begin, long end);

	public List<Film> getFilmByPlanTime(
			long firstDay, long lastDay);

	public List<FilmPlan> getAllPassedPlansNotOldByPage(int page);

	public List<FilmPlan> getAllPassedPlansOldByPage(int page);

	public List<Film> getAllOldFilmsByPage(int page);

	public OperaResult checkFilmPlanForUpdate(long planid, long beginTime,
			long endTime, Hall hallById);





	


	
}
