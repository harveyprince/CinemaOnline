package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;

public interface FilmService {

	public List<FilmPlanInfo> getAllUnoldPlans();
	
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
}
