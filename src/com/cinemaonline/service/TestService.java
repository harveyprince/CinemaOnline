package com.cinemaonline.service;

import com.cinemaonline.dao.TestDao;

public interface TestService {
	public TestDao getTestDao();
	
	public void setTestDao(TestDao testDao);
	
	public String getName(String key);

}
