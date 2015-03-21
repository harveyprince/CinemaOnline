package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.OperaResult;

public interface ActivityService {

	public List<Activity> getAllUnpassedActivities();

	public OperaResult insertActivity(ActivityInfo info);

	public OperaResult updateActivity(ActivityInfo info);

	public OperaResult pulishActivity(long actid);

	public List<Activity> getActivitiesForVip(String userid);

	public List<Activity> getParticipatedActivitiesForVip(String userid);

	public List<Activity> getUnparticipatedActivitiesForVip(String userid);

	public OperaResult joinActivity(String activityid, String answerid,
			String userid);
}
