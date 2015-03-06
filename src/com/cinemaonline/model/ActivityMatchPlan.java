package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ActivityMatchPlan")
public class ActivityMatchPlan {
	private long activityId;//活动流水号
	private long planId;//放映计划流水号
	
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}

}
