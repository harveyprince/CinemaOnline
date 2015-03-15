package com.cinemaonline.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.dao.ActivityDao;
import com.cinemaonline.dao.BaseDao;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.ActivityInfoSet;

@Repository
public class ActivityDaoImpl implements ActivityDao {
	@Autowired
	private BaseDao baseDao;
	public ActivityDaoImpl(){}

	@Override
	public long pulishActivity(ActivityInfo activity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActivityInfo findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityInfoSet getActivitiesByPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
