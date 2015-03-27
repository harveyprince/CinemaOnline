package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;
import com.cinemaonline.model.ActivityRecord;


public interface ActivityDao {
	
	public List<Activity> getActivitiesForVip(long id);

	public Activity insertActivity(Activity info);
	
	public void updateActivity(Activity info);
	
	public void insertAnswer(ActivityAnswer info);
	
	public List<Activity> getAllUnpassedActivities();
	
	public List<Activity> getAllendedActivities();

	public Activity getActivityById(long id);

	public void deleteAnswerByActId(long activityid);

	public List<Activity> getParticipatedActivitiesForVip(long id);

	public List<Activity> getUnarticipatedActivitiesForVip(long id);
	
	public List<Activity> getUnarticipatedActivitiesForVipByPage(long id,int page);

	public ActivityRecord insertRecord(ActivityRecord info);

	public List<Activity> getActivitiesByFilmId(long filmId);

	public int getParticipateSumByTime(long firstday, long lastday);

	public ActivityRecord getRecordByActivityId(long activityId,long userid);

	public List<Activity> getAllUnpassedActivitiesByPage(int page);

	public List<Activity> getParticipatedActivitiesForVipByPage(long parseLong,
			int page);

	public List<Activity> getAllendedActivitiesByPage(int page);
}
