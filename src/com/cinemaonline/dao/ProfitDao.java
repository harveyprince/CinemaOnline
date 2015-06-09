package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.ProfitPlan;

public interface ProfitDao {

	ProfitPlan insertProfitPlan(ProfitPlan profitPlan);

	FilmProfitPlan insertFilmProfitPlan(FilmProfitPlan filmProfitPlan);

	boolean isFilmExist(long filmId);

	List<Film> getAllUnplanedFilms();

}
