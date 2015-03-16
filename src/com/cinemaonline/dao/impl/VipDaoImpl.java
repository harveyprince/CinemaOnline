package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.VipLevel;

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

	


}
