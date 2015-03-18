package com.cinemaonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.ActivityDao;
import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;
import com.cinemaonline.model.ActivityMatchPlan;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private FilmDao filmDao;
	
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
		Activity ac = activityDao.insertActivity(info_local.getActivity());
		List<ActivityAnswer> answerlist = info_local.getAnswerlistList();
		for(ActivityAnswer temp:answerlist){
			temp.setActivity(ac);
			activityDao.insertAnswer(temp);
		}
		List<Long> planidlist = info_local.getPlanidlist();
		for(long temp:planidlist){
			ActivityMatchPlan amp = new ActivityMatchPlan();
			amp.setActivity(ac);
			amp.setFilmPlan(filmDao.getFilmPlanById(temp));
			activityDao.insertMatchPlan(amp);
		}
		result.setResult(true);
		return result;
	}

}
