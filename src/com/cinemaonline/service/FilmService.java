package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;

public interface FilmService {

	public List<FilmPlanInfo> getAllUnoldPlans();
	
	public List<Film> getAllReleasingFilms();
	
	public List<Hall> getAllHalls();
	
	public OperaResult addPlan(FilmPlanInfo info);
	
	public OperaResult updatePlan(FilmPlanInfo info);
}
