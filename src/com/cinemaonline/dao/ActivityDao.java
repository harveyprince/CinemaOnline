package com.cinemaonline.dao;

import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.ActivityInfoSet;

public interface ActivityDao {
	
	public long pulishActivity(ActivityInfo activity);
	
	public ActivityInfo findById(long id);
	
	public ActivityInfoSet getActivitiesByPage(int page);

}
