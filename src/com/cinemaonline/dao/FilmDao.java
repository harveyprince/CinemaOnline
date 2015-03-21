package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.OperaResult;

public interface FilmDao {
//	film
	public Film insertFilm(Film info);
	
	public Film updateFilm(Film info);
	
	public List<Film> getAllReleasingFilms();
	
	public List<Film> getAllFilms();
	
	public Film getFilmById(long id);
//	film plan
	public FilmPlan insertFilmPlan(FilmPlan info);
	
	public void updateFilmPlan(FilmPlan info);

	public List<FilmPlan> getAllUnoldPlans();
	
	public List<FilmPlan> getAllPassedPlans();
	
	public FilmPlan getFilmPlanById(long id);
	
	public List<FilmPlan> getPlansForCheck();

	public OperaResult checkFilmPlan(long beginTime, long endTime, Hall hall);
//	hall
	public List<Hall> getAllHalls();
	
	public Hall getHallById(int id);

	


	
}
