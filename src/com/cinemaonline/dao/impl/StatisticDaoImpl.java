package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.StatisticDao;
import com.cinemaonline.model.StatisticAge;
import com.cinemaonline.model.StatisticCardStatus;
import com.cinemaonline.model.StatisticLocation;
import com.cinemaonline.model.StatisticSex;
import com.cinemaonline.model.StatisticVipOpera;

@Repository
public class StatisticDaoImpl implements StatisticDao {
	@Autowired
	private BaseDao baseDao;

	@Override
	public void insertAgeStatistic(StatisticAge info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<StatisticAge> getAgeStatisticByTime(int year, int month) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.StatisticAge where year=? and month=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, year);
			query.setParameter(1, month);
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
	public void insertSexStatistic(StatisticSex info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<StatisticSex> getSexStatisticByTime(int year, int month) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.StatisticSex where year=? and month=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, year);
			query.setParameter(1, month);
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
	public void insertLocationStatistic(StatisticLocation info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<StatisticLocation> getLocationStatisticByTime(int year,
			int month) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.StatisticLocation where year=? and month=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, year);
			query.setParameter(1, month);
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
	public void insertCardStatusStatistic(StatisticCardStatus info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public List<StatisticCardStatus> getCardStatusStatisticByTime(int year,
			int month) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.StatisticCardStatus where year=? and month=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, year);
			query.setParameter(1, month);
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
	public void insertVipOperaStatistic(StatisticVipOpera info) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public StatisticVipOpera getVipOperaStatisticByTime(int year, int month) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.StatisticVipOpera where year=? and month=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, year);
			query.setParameter(1, month);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (StatisticVipOpera) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	
}
