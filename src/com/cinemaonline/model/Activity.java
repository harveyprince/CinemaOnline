package com.cinemaonline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Activity")
public class Activity {
	private long activityId;//活动流水号
	private String title;//题目
	private String content;//内容
	private Set<ActivityAnswer> answerlist;//答案
	private Set<FilmPlan> plans;//计划
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="activity")
	public Set<ActivityAnswer> getAnswerlist() {
		return answerlist;
	}
	public void setAnswerlist(Set<ActivityAnswer> answerlist) {
		this.answerlist = answerlist;
	}
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name="ActivityMatchPlan",
			joinColumns=
			@JoinColumn(name="activityId", referencedColumnName="activityId"),
			inverseJoinColumns=
			@JoinColumn(name="planId", referencedColumnName="planId")
			)
	public Set<FilmPlan> getPlans() {
		return plans;
	}
	public void setPlans(Set<FilmPlan> plans) {
		this.plans = plans;
	}
	

}
