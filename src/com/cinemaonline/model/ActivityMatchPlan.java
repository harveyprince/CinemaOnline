package com.cinemaonline.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ActivityMatchPlan")
public class ActivityMatchPlan {
	private long matchId;//流水号
//	private long activityId;//活动流水号
//	private long planId;//放映计划流水号
	private Activity activity;//活动
	private FilmPlan filmPlan;//计划
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getMatchId() {
		return matchId;
	}
	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Activity.class)
	@JoinColumn(name="activityId")
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=FilmPlan.class)
	@JoinColumn(name="planId")
	public FilmPlan getFilmPlan() {
		return filmPlan;
	}
	public void setFilmPlan(FilmPlan filmPlan) {
		this.filmPlan = filmPlan;
	}

}
