package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipLevel;
@Repository
public class InfoDaoImpl implements InfoDao {
	@Autowired
	BaseDao baseDao;
	public InfoDaoImpl(){}
	
	@Override
	public Identity insertIdentity(Identity info) {
		// TODO Auto-generated method stub
		Identity info_local = info;
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
	public Hall insertHall(Hall info) {
		// TODO Auto-generated method stub
		Hall info_local = info;
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
	public VipLevel insertVipLevel(VipLevel info) {
		// TODO Auto-generated method stub
		VipLevel info_local = info;
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
	public Identity getIdentityById(int id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.Identity as a where a.identityId='"+id+"'";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		if(list==null){
			return null;
		}
		else{
		if(list.size()>0){
			return (Identity)(list.get(0));
		}else{
			return null;
		}
		}
	}

	@Override
	public Location insertLocation(Location info) {
		// TODO Auto-generated method stub
		Location info_local = info;
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
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.Location";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		if(list==null){
			return null;
		}
		else{
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		}
	}

	@Override
	public List<Location> getLocationWithVips() {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String sql = "select l.* from Location l inner join (select distinct v.locationId from VipInfo v) as d on l.locationId = d.locationId";
		List list = null;
		try{
			Query query = session.createSQLQuery(sql).addEntity(Location.class);
			list = query.list();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		if(list==null){
			return null;
		}
		else{
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		}
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.Location as l where l.locationId=?";
		List list = null;
		try{
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			list = query.list();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		if(list==null){
			return null;
		}
		else{
		if(list.size()>0){
			return (Location) list.get(0);
		}else{
			return null;
		}
		}
	}

}
