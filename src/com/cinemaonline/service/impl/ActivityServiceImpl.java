package com.cinemaonline.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.ActivityDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;
import com.cinemaonline.model.ActivityRecord;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private TicketDao ticketDao;
	
	@Override
	public List<Activity> getAllUnpassedActivities() {
		// TODO Auto-generated method stub
		return activityDao.getAllUnpassedActivities();
	}

	@Override
	public OperaResult insertActivity(ActivityInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		ActivityInfo info_local = info;
		List<Long> planidlist = info_local.getPlanidlist();
		Set<FilmPlan> planlist = new HashSet<FilmPlan>();
		for(long temp:planidlist){
			planlist.add(filmDao.getFilmPlanById(temp));
		}
		info_local.setPlans(planlist);
		Activity ac = activityDao.insertActivity(info_local.getActivity());
		List<ActivityAnswer> answerlist = info_local.getAnswerlistList();
		for(ActivityAnswer temp:answerlist){
			temp.setActivity(ac);
			activityDao.insertAnswer(temp);
		}
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult updateActivity(ActivityInfo info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Activity info_old = activityDao.getActivityById(info.getActivityid());
		List<Long> planidlist = info.getPlanidlist();
		Set<FilmPlan> planlist = new HashSet<FilmPlan>();
		for(long temp:planidlist){
			planlist.add(filmDao.getFilmPlanById(temp));
		}
		info_old.setPlans(planlist);
		info_old.setTitle(info.getTitle());
		info_old.setStatus(info.getStatus());
		activityDao.updateActivity(info_old);
		activityDao.deleteAnswerByActId(info.getActivityid());
		List<ActivityAnswer> answerlist = info.getAnswerlistList();
		for(ActivityAnswer temp:answerlist){
			temp.setActivity(info_old);
			activityDao.insertAnswer(temp);
		}
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult pulishActivity(long actid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Activity info = activityDao.getActivityById(actid);
		info.setStatus(1);
		activityDao.updateActivity(info);
		result.setResult(true);
		return result;
	}

	@Override
	public List<Activity> getActivitiesForVip(String userid) {
		// TODO Auto-generated method stub
		return activityDao.getActivitiesForVip(Long.parseLong(userid));
	}

	@Override
	public List<Activity> getParticipatedActivitiesForVip(String userid) {
		// TODO Auto-generated method stub
		return activityDao.getParticipatedActivitiesForVip(Long.parseLong(userid));
	}

	@Override
	public List<Activity> getUnparticipatedActivitiesForVip(String userid) {
		// TODO Auto-generated method stub
		return activityDao.getUnarticipatedActivitiesForVip(Long.parseLong(userid));
	}

	@Override
	public OperaResult joinActivity(String activityid, String answerid,
			String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		Activity activity = activityDao.getActivityById(Long.parseLong(activityid));
		ActivityAnswer the_answer = null;
		for(ActivityAnswer answer: activity.getAnswerlist()){
			if(answer.getAnswerId()==Integer.parseInt(answerid)){
				the_answer = answer;
				break;
			}
		}
		if(the_answer==null){
			result.setResult(false);
			result.setComment("answer dont't exist");
			return result;
		}
		ActivityRecord record = new ActivityRecord();
		record.setActivityAnswer(the_answer);
		record.setVipId(Long.parseLong(userid));
		activityDao.insertRecord(record);
		result.setResult(true);
		return result;
	}

}
