package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.ProfitDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.ProfitPlan;
@Repository
public class ProfitDaoImpl implements ProfitDao {
	@Autowired
	BaseDao baseDao;

	@Override
	public ProfitPlan insertProfitPlan(ProfitPlan profitPlan) {
		// TODO Auto-generated method stub
		ProfitPlan info_local = profitPlan;
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
	public FilmProfitPlan insertFilmProfitPlan(FilmProfitPlan filmProfitPlan) {
		// TODO Auto-generated method stub
		FilmProfitPlan info_local = filmProfitPlan;
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
	public boolean isFilmExist(long filmId) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select * from FilmProfitPlan where filmId = ?";
		try{
			Query query = session.createSQLQuery(sql).addEntity(FilmProfitPlan.class);
			query.setParameter(0, filmId);
			if(query.list()==null||query.list().size()==0){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}

	@Override
	public List<Film> getAllUnplanedFilms() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select * from Film f where f.filmId not in (select filmId from FilmProfitPlan)";
		try{
			Query query = session.createSQLQuery(sql).addEntity(Film.class);
			return query.list();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public List<ProfitPlan> getAllWorkingPlans() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.ProfitPlan where status != 0";
		try{
			Query query = session.createQuery(hql);
			return query.list();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	@Override
	public List<ProfitPlan> getAllWorkingUndispatchPlans() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.ProfitPlan where status = 1";
		try{
			Query query = session.createQuery(hql);
			return query.list();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	@Override
	public List<ProfitPlan> getAllWorkingDispatchPlans() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.ProfitPlan where status = 2";
		try{
			Query query = session.createQuery(hql);
			return query.list();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public List<FilmProfitPlan> getProfitDispatchByPlanId(String id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select * from FilmProfitPlan where profitPlanId = "+id;
		try{
			Query query = session.createSQLQuery(sql).addEntity(FilmProfitPlan.class);
			return query.list();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}

	@Override
	public FilmProfitPlan getFilmProfitPlanByFilmId(Long filmId) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select * from FilmProfitPlan where filmId = "+filmId;
		try{
			Query query = session.createSQLQuery(sql).addEntity(FilmProfitPlan.class);
			return (FilmProfitPlan) query.list().get(0);
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
