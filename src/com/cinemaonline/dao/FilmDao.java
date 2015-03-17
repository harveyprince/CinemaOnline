package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;

public interface FilmDao {
//	film
	public Film insertFilm(Film info);
	
//	film plan
	public FilmPlan insertFilmPlan(FilmPlan info);

	public List<FilmPlan> getAllUnpassedPlans();
}
