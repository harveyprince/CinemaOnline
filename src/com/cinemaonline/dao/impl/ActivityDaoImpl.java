package com.cinemaonline.dao.impl;

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
import com.cinemaonline.model.ActivityRecord;

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
	public List<Activity> getAllUnpassedActivitiesByPage(int page) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Activity where status!=2";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(page*baseDao.getPageCount());
			query.setMaxResults(baseDao.getPageCount());
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
	@Override
	public Activity getActivityById(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Activity where activityId=?";
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
				return (Activity) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public void deleteAnswerByActId(long activityid) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "delete com.cinemaonline.model.ActivityAnswer where activityId=?";
		Transaction ts = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, activityid);
			query.executeUpdate();
			ts.commit();
		}catch(Exception e){
			ts.rollback();
		}finally{
			session.close();
		}
	}
	@Override
	public List<Activity> getActivitiesForVip(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityMatchPlan p on a.activityId = p.activityId inner join TicketRecord t on p.planId = t.filmplanId where t.identifyNumber=?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, id);
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
	public List<Activity> getParticipatedActivitiesForVip(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityAnswer p on a.activityId = p.activityId inner join ActivityRecord t on p.activityAnswerId = t.activityAnswerId where t.vipId=?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, id);
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
	public List<Activity> getParticipatedActivitiesForVipByPage(long id,int page) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityAnswer p on a.activityId = p.activityId inner join ActivityRecord t on p.activityAnswerId = t.activityAnswerId where t.vipId=?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, id);
			query.setFirstResult(page*baseDao.getPageCount());
			query.setMaxResults(baseDao.getPageCount());
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
	public List<Activity> getUnarticipatedActivitiesForVip(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityMatchPlan p on a.activityId = p.activityId inner join TicketRecord t on p.planId = t.filmplanId where t.identifyNumber=? and a.activityId not in (select distinct a.activityId from Activity a inner join ActivityAnswer p on a.activityId = p.activityId inner join ActivityRecord t on p.activityAnswerId = t.activityAnswerId where t.vipId=?)";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, id);
			query.setParameter(1, id);
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
	public List<Activity> getUnarticipatedActivitiesForVipByPage(long id,int page) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityMatchPlan p on a.activityId = p.activityId inner join TicketRecord t on p.planId = t.filmplanId where t.identifyNumber=? and a.activityId not in (select distinct a.activityId from Activity a inner join ActivityAnswer p on a.activityId = p.activityId inner join ActivityRecord t on p.activityAnswerId = t.activityAnswerId where t.vipId=?)";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, id);
			query.setParameter(1, id);
			query.setFirstResult(page*baseDao.getPageCount());
			query.setMaxResults(baseDao.getPageCount());
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
	public ActivityRecord insertRecord(ActivityRecord info) {
		// TODO Auto-generated method stub
		ActivityRecord info_local = info;
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
	public List<Activity> getActivitiesByFilmId(long filmId) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select distinct a.* from Activity a inner join ActivityMatchPlan p on a.activityId = p.activityId inner join FilmPlan t on p.planId = t.planId where t.filmId=?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Activity.class);
			query.setParameter(0, filmId);
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
	public int getParticipateSumByTime(long firstday, long lastday) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select count(*) from ActivityRecord where recordTime>? and recordTime<?";
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, firstday);
			query.setParameter(1, lastday);
			if(query.list()==null){
				return 0;
			}
			return ((Number)query.uniqueResult()).intValue();
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			session.close();
		}
		return 0;
	}
	@Override
	public ActivityRecord getRecordByActivityId(long activityId,long userid) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select a.* from ActivityRecord a inner join ActivityAnswer s on a.activityAnswerId = s.activityAnswerId inner join Activity t on t.activityId = s.activityId where t.activityId=? and a.vipId=?";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(ActivityRecord.class);
			query.setParameter(0, activityId);
			query.setParameter(1, userid);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return (ActivityRecord) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	@Override
	public List<Activity> getAllendedActivities() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.Activity as a where a.status=2";
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
