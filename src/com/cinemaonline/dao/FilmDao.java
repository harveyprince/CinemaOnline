package com.cinemaonline.dao;

import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.OperaResult;

public interface FilmDao {
	
	public OperaResult addFilm(FilmInfo info);
	
	public OperaResult publishFilmPlan(FilmPlan plan);

}
