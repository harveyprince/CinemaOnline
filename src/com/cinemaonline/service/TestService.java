package com.cinemaonline.service;

import com.cinemaonline.dao.TestDao;
import com.cinemaonline.model.Activity;

public interface TestService {
	public TestDao getTestDao();
	
	public void setTestDao(TestDao testDao);
	
	public String getName(String key);
	public void setAct(Activity act);

}
