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
import com.cinemaonline.model.client.OperaResult;

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
		String hql = "from com.cinemaonline.model.FilmPlan where beginTime>?";
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
	@Override
	public List<FilmPlan> getPlansForCheck() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.FilmPlan where status=1";
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
	public OperaResult checkFilmPlan(long beginTime, long endTime, Hall hall) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.FilmPlan as a where a.hall=? and ((a.beginTime>=? and a.beginTime<=?) or (a.endTime>=? and a.endTime<=?) or (a.beginTime<=? and a.endTime>=?))";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, hall);
			query.setParameter(1, beginTime);
			query.setParameter(2, endTime);
			query.setParameter(3, beginTime);
			query.setParameter(4, endTime);
			query.setParameter(5, beginTime);
			query.setParameter(6, endTime);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		OperaResult result = new OperaResult();
		if(list!=null){
			if(list.size()>0){
				result.setResult(false);
				result.setComment("time conflict");
			}else{
				result.setResult(true);
			}
		}else{
			result.setResult(true);
		}
		return result;
	}
	@Override
	public List<FilmPlan> getAllNotEndedPlansByFilm(Film info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Date timestamp = new Date();
		long timenow = timestamp.getTime();
		String hql = "from com.cinemaonline.model.FilmPlan as a where a.endTime>? and a.film=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, timenow);
			query.setParameter(1, info);
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
	public List<Film> getReleasingFilmsByActivityId(long activityId) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct f.* from Film f inner join FilmPlan p on f.filmId = p.filmId inner join ActivityMatchPlan a on a.planId = p.planId where a.activityId=? and f.status=1";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Film.class);
			query.setParameter(0, activityId);
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
	public int getPersonSumByTime(long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select sum(v.seats) from (select h.seats-a.seatSum as seats from FilmPlan a inner join Hall h on a.hallNo = h.hallNo where a.beginTime>? and a.endTime<?) as v";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, begin);
			query.setParameter(1, end);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (int) list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	public int getHallSeatsAddupByTime(int hallNo, long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select sum(v.seats) from (select h.seats as seats from FilmPlan a inner join Hall h on a.hallNo = h.hallNo where a.beginTime>? and a.endTime<? and h.hallNo=?) as v";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, begin);
			query.setParameter(1, end);
			query.setParameter(2, hallNo);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (int) list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	public int getHallSeatsAttendencedByTime(int hallNo, long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select sum(v.seats) from (select h.seats-a.seatSum as seats from FilmPlan a inner join Hall h on a.hallNo = h.hallNo where a.beginTime>? and a.endTime<? and h.hallNo=?) as v";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, begin);
			query.setParameter(1, end);
			query.setParameter(2, hallNo);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (int) list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	@Override
	public double getHallAttendenceByTime(int hallNo, long begin, long end) {
		// TODO Auto-generated method stub
		return (getHallSeatsAttendencedByTime(hallNo, begin, end)+0.0)/(getHallSeatsAddupByTime(hallNo, begin, end)+0.0);
	}
	
	public int getFilmSeatsAddupByTime(long filmId, long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select sum(v.seats) from (select h.seats as seats from FilmPlan a inner join Hall h on a.hallNo = h.hallNo where a.beginTime>? and a.endTime<? and a.filmId=?) as v";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, begin);
			query.setParameter(1, end);
			query.setParameter(2, filmId);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (int) list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	public int getFilmSeatsAttendencedByTime(long filmId, long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select sum(v.seats) from (select h.seats-a.seatSum as seats from FilmPlan a inner join Hall h on a.hallNo = h.hallNo where a.beginTime>? and a.endTime<? and a.filmId=?) as v";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, begin);
			query.setParameter(1, end);
			query.setParameter(2, filmId);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (int) list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	@Override
	public double getFilmAttendenceByTime(long filmId, long begin, long end) {
		// TODO Auto-generated method stub
		return (getFilmSeatsAttendencedByTime(filmId, begin, end)+0.0)/(getFilmSeatsAddupByTime(filmId, begin, end)+0.0);
	}
	@Override
	public List<Film> getFilmByPlanTime(long begin, long end) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select f.* from Film f inner join FilmPlan p on f.filmId = p.filmId where p.beginTime>? and p.endTime<?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Film.class);
			query.setParameter(0, begin);
			query.setParameter(1, end);
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
