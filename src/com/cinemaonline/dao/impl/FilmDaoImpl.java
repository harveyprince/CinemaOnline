package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;

@Repository
public class FilmDaoImpl implements FilmDao {
	@Autowired
	private BaseDao baseDao;
	public FilmDaoImpl(){}
	@Override
	public Film insertFilm(Film info) {
		// TODO Auto-generated method stub
		Film info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info_local);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}
	@Override
	public FilmPlan insertFilmPlan(FilmPlan info) {
		// TODO Auto-generated method stub
		FilmPlan info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info_local);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}
	@Override
	public List<FilmPlan> getAllUnpassedPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
