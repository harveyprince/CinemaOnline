package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;

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
	
//	hall
	public List<Hall> getAllHalls();
	
	public Hall getHallById(int id);

	
}
