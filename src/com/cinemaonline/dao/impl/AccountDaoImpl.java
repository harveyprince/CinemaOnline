package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.AccountUpdate;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private BaseDao baseDao;
	public AccountDaoImpl(){}

	@Override
	public long insert(AccountSignUp info) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(AccountUpdate info) {
		// TODO Auto-generated method stub
		
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
		Query query = session.createQuery(hql);
		List list = query.list();
		
		if(list.size()>0){
			return (Account)(list.get(0));
		}else{
			return null;
		}
	}
//	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}
