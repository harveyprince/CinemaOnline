package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountUpdate;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private BaseDao baseDao;
	public AccountDaoImpl(){}

	@Override
	public Account insert(Account info) {
		// TODO Auto-generated method stub
		Account info_local = info;
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
	public void update(Account info) {
		// TODO Auto-generated method stub
		Account info_local = info;
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
	public void deleteByAccountName(String ac) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account find(AccountLogin info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByAccountName(String ac) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.Account as a where a.accountName='"+ac+"'";
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
			return (Account)(list.get(0));
		}else{
			return null;
		}
		}
	}




}
