package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BankDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.Bank;

@Repository
public class BankDaoImpl implements BankDao {
	@Autowired
	private BaseDao baseDao;
	public BankDaoImpl(){}

	@Override
	public Bank findById(long id) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.Bank as a where a.cardId='"+id+"'";
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
			return (Bank)(list.get(0));
		}else{
			return null;
		}
	}
	}

	@Override
	public void update(Bank bank) {
		// TODO Auto-generated method stub
		Bank info_local = bank;
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
	public Bank insert(Bank info) {
		// TODO Auto-generated method stub
		Bank info_local = info;
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

}
