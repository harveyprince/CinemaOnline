package com.cinemaonline.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.VipRecord;

@Repository
public class VipDaoImpl implements VipDao {
	@Autowired
	private BaseDao baseDao;
	public VipDaoImpl(){}
	
	@Override
	public VipInfo getVipInfoByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.VipInfo as a where a.email='"+email+"'";
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
				return (VipInfo) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public VipInfo insert(VipInfo info) {
		// TODO Auto-generated method stub
		VipInfo info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info_local);
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}

	@Override
	public void update(VipInfo info) {
		// TODO Auto-generated method stub
		VipInfo info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.update(info_local);
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public VipInfo getVipInfoById(String userid) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.VipInfo as a where a.vipId='"+userid+"'";
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
				return (VipInfo) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public VipCard insertCard(VipCard info) {
		// TODO Auto-generated method stub
		VipCard info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info_local);
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}
	
	@Override
	public void updateCard(VipCard info) {
		// TODO Auto-generated method stub
		VipCard info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.update(info_local);
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public VipLevel getLevelById(int levelid) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipLevel as a where a.levelId='"+levelid+"'";
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
				return (VipLevel) list.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public VipRecord insertRecord(VipRecord info) {
		// TODO Auto-generated method stub
		VipRecord info_local = info;
		Session session = baseDao.getNewSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(info_local);
			ts.commit();
		}catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		}finally{
			session.close();
		}
		return info_local;
	}

	@Override
	public List<VipLevel> getAllLevel() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipLevel";
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
	public List<VipRecord> getRecordsById(String userid) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipRecord as a where a.vipId='"+userid+"'";
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
	public List<VipRecord> getRecordsByIdByPage(String userid,int page) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipRecord as a where a.vipId='"+userid+"' order by a.recordTime desc";
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
	public List<VipInfo> getVipForLevelPay(long oneyearago) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql = "select a.* from VipInfo as a inner join (select max(r.recordTime) e,r.vipId from VipRecord as r where r.purpose='lvcost' group by r.vipId having e<?) as v on a.vipId = v.vipId where a.vipStatus<4";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(VipInfo.class);
			query.setParameter(0, oneyearago);
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
	public int getVipSumByLocation(Location location) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipInfo as a where a.location=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, location);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list.size();
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	@Override
	public int getVipSumByStatus(int status) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipInfo as a where a.vipStatus=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, status);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list.size();
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	@Override
	public double getConsumeSumByTime(long firstday, long lastday) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String sql  = "select sum(v.recordNumber) from VipRecord as v where v.recordTime>? and v.recordTime<? and v.result=1 and v.recordNumber<0";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, firstday);
			query.setParameter(1, lastday);
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return Math.abs((double) list.get(0));
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	public int getPersonNumByBirthdayTime(long begin,long end){
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipInfo as a where a.birthday>? and a.birthday<?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, new java.sql.Date(begin));
			query.setParameter(1, new java.sql.Date(end));
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		if(list!=null){
			if(list.size()>0){
				return list.size();
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	@Override
	public int getAge_0_10() {
		// TODO Auto-generated method stub
		System.out.println("0_10");
		Calendar cal = Calendar.getInstance();
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getAge_10_20() {
		// TODO Auto-generated method stub
		System.out.println("10_20");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, -10-12*9);
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getAge_20_30() {
		// TODO Auto-generated method stub
		System.out.println("20_30");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, -10-12*19);
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getAge_30_40() {
		// TODO Auto-generated method stub
		System.out.println("30_40");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, -10-12*29);
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getAge_40_50() {
		// TODO Auto-generated method stub
		System.out.println("40_50");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, -10-12*39);
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getAge_50_60() {
		// TODO Auto-generated method stub
		System.out.println("50_60");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, -10-12*49);
		long time2 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		cal.set(Calendar.MONTH, -10-12*9);
		long time1 = cal.getTimeInMillis();
		System.out.println(cal.getTime().toLocaleString());
		return getPersonNumByBirthdayTime(time1,time2);
	}

	@Override
	public int getBoy_num() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipInfo as a where a.sex=1";
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
				return list.size();
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

	@Override
	public int getGirl_num() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		String hql = "from com.cinemaonline.model.VipInfo as a where a.sex=0";
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
				return list.size();
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

}
