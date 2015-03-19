package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;


public interface ActivityDao {
	

	public Activity insertActivity(Activity info);
	
	public void updateActivity(Activity info);
	
	public void insertAnswer(ActivityAnswer info);
	
	public List<Activity> getAllUnpassedActivities();
}
