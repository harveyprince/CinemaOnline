package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;

public interface FilmDao {
//	film
	public Film insertFilm(Film info);
	
	public List<Film> getAllReleasingFilms();
	
//	film plan
	public FilmPlan insertFilmPlan(FilmPlan info);

	public List<FilmPlan> getAllUnpassedPlans();
	
//	hall
	public List<Hall> getAllHalls();
}
