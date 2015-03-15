package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.OperaResult;

@Repository
public class FilmDaoImpl implements FilmDao {
	@Autowired
	private BaseDao baseDao;
	public FilmDaoImpl(){}

	@Override
	public OperaResult addFilm(FilmInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperaResult publishFilmPlan(FilmPlan plan) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
