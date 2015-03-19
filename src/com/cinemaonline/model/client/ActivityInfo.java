package com.cinemaonline.model.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityAnswer;
import com.cinemaonline.model.FilmPlan;

public class ActivityInfo {

	private long activityid;
	private String title;
	private int status = 0;
	private Set<ActivityAnswer> answerlist;
	private Set<FilmPlan> plans;
	private List<ActivityAnswer> answerlistList;
	private List<FilmPlan> plansList;
	private List<Long> planidlist;
	public Activity getActivity(){
		Activity info = new Activity();
		info.setTitle(title);
		info.setStatus(status);
		info.setPlans(plans);
		return info;
	}
	public void addPlanId(long id){
		if(planidlist==null){
			planidlist = new ArrayList<Long>();
		}
		planidlist.add(id);
	}
	public void addPlanId(String id){
		addPlanId(Long.parseLong(id));
	}
	public long getActivityid() {
		return activityid;
	}
	public void setActivityid(long activityid) {
		this.activityid = activityid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<ActivityAnswer> getAnswerlist() {
		return answerlist;
	}
	public void setAnswerlist(Set<ActivityAnswer> answerlist) {
		this.answerlist = answerlist;
		List<ActivityAnswer> list = new ArrayList<ActivityAnswer>();
		list.addAll(answerlist);
		setAnswerlistList(list);
	}
	public Set<FilmPlan> getPlans() {
		return plans;
	}
	public void setPlans(Set<FilmPlan> plans) {
		this.plans = plans;
		List<FilmPlan> list = new ArrayList<FilmPlan>();
		list.addAll(list);
		setPlansList(list);
	}
	public List<ActivityAnswer> getAnswerlistList() {
		return answerlistList;
	}
	public void setAnswerlistList(List<ActivityAnswer> answerlistList) {
		this.answerlistList = answerlistList;
	}
	public List<FilmPlan> getPlansList() {
		return plansList;
	}
	public void setPlansList(List<FilmPlan> plansList) {
		this.plansList = plansList;
	}
	public List<Long> getPlanidlist() {
		return planidlist;
	}
	public void setPlanidlist(List<Long> planidlist) {
		this.planidlist = planidlist;
	}
}
