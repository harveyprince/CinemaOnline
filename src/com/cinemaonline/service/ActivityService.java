package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityRecord;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.OperaResult;

public interface ActivityService {

	public List<Activity> getAllUnpassedActivities();
	
	public List<Activity> getAllendedActivities();

	public OperaResult insertActivity(ActivityInfo info);

	public OperaResult updateActivity(ActivityInfo info);

	public OperaResult pulishActivity(long actid);

	public List<Activity> getActivitiesForVip(String userid);

	public List<Activity> getParticipatedActivitiesForVip(String userid);

	public List<Activity> getUnparticipatedActivitiesForVip(String userid);

	public OperaResult joinActivity(String activityid, String answerid,
			String userid);

	public OperaResult endActivityByFilm(Film info);

	public List<ActivityRecord> getRecordsByActivities(
			List<Activity> info,long userid);
}
