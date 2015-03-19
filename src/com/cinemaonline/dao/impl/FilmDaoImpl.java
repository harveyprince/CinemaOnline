package com.cinemaonline.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;

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
	public List<FilmPlan> getAllUnoldPlans() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Date timestamp = new Date();
		long timenow = timestamp.getTime();
		String hql = "from com.cinemaonline.model.FilmPlan where endTime>?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, timenow);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public List<Film> getAllReleasingFilms() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Film where status=1";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public List<Hall> getAllHalls() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Hall";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public Film getFilmById(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Film where filmId=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (Film)list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public Hall getHallById(int id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Hall where hallNo=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (Hall)list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public FilmPlan getFilmPlanById(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.FilmPlan where planId=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (FilmPlan)list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public void updateFilmPlan(FilmPlan info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.update(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}
	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Film";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public Film updateFilm(Film info) {
		// TODO Auto-generated method stub
		Film info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.update(info_local);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}
	@Override
	public List<FilmPlan> getAllPassedPlans() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.FilmPlan where status=2";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	

}
