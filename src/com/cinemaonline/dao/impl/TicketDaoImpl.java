package com.cinemaonline.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Ticket;
import com.cinemaonline.model.TicketRecord;

@Repository
public class TicketDaoImpl implements TicketDao {
	@Autowired
	private BaseDao baseDao;
	public TicketDaoImpl(){}
	
	@Override
	public TicketRecord insertRecord(TicketRecord record) {
		// TODO Auto-generated method stub
		TicketRecord info_local = record;
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
	public Ticket insertTicket(Ticket tick) {
		// TODO Auto-generated method stub
		Ticket info_local = tick;
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
	public TicketRecord getRecordById(long recordId) {
		// TODO Auto-generated method stub
		Session session = baseDao.getNewSession();
		
		String hql = "from com.cinemaonline.model.TicketRecord as a where a.recordId='"+recordId+"'";
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
			return (TicketRecord)(list.get(0));
		}else{
			return null;
		}
		}
	}

	

}
