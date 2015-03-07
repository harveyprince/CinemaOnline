package com.cinemaonline.service.impl;

import com.cinemaonline.dao.TestDao;
import com.cinemaonline.model.Activity;
import com.cinemaonline.model.Test;
import com.cinemaonline.service.TestService;

public class TestServiceImpl implements TestService {

	private TestDao testDao;
	
	private TestServiceImpl(){}
	
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	
	@Override
	public TestDao getTestDao() {
		// TODO Auto-generated method stub
		return testDao;
	}

	@Override
	public String getName(String key) {
		// TODO Auto-generated method stub
		Test test = testDao.find(key);
		return test.getName();
	}

	@Override
	public void setAct(Activity act) {
		// TODO Auto-generated method stub
		testDao.setAct(act);
	}

}
