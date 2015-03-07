package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cinemaonline.dao.TestDao;
import com.cinemaonline.model.Activity;
import com.cinemaonline.model.Test;

public class TestDaoImpl implements TestDao {

	public TestDaoImpl(){}
	@Override
	public Test find(String key) {
		// TODO Auto-generated method stub
		try{
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			String hql = "from com.cinemaonline.model.Test as t where t.keey='"+key+"'";
			Query query = session.createQuery(hql);
			List list = query.list();
			
			if((list.size())==0){
				return null;
			}else{
				return (Test)list.get(0);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void setAct(Activity act) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(act);
			tx.commit();
			session.close();
			sessionFactory.close();
			//this.getHibernateTemplate().save(user);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
