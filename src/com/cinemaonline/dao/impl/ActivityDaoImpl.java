package com.cinemaonline.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.ActivityDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;

@Repository
public class ActivityDaoImpl implements ActivityDao {
	@Autowired
	private BaseDao baseDao;
	public ActivityDaoImpl(){}
	@Override
	public Activity insertActivity(Activity info) {
		// TODO Auto-generated method stub
		Activity info_local = info;
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
	public void insertAnswer(ActivityAnswer info) {
		// TODO Auto-generated method stub
		ActivityAnswer info_local = info;
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
	}

	@Override
	public List<Activity> getAllUnpassedActivities() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Activity where status!=2";
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
	public void updateActivity(Activity info) {
		// TODO Auto-generated method stub
		Activity info_local = info;
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
	}




}
