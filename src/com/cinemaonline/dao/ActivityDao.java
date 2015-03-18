package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;
import com.cinemaonline.model.ActivityMatchPlan;


public interface ActivityDao {
	

	public Activity insertActivity(Activity info);
	
	public void insertAnswer(ActivityAnswer info);
	
	public void insertMatchPlan(ActivityMatchPlan info);

	public List<Activity> getAllUnpassedActivities();
}
