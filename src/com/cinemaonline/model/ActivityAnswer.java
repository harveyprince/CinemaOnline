package com.cinemaonline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ActivityAnswer")
public class ActivityAnswer {
	private long activityAnswerId;//流水号
//	private long activityId;//活动流水号
	private int answerId;//选项ID
	private String answerContent;//选项内容
	private Set<ActivityRecord> activityRecords;//会员答案
	private Activity activity;//活动
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getActivityAnswerId() {
		return activityAnswerId;
	}
	public void setActivityAnswerId(long activityAnswerId) {
		this.activityAnswerId = activityAnswerId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="activityAnswer")
	public Set<ActivityRecord> getActivityRecords() {
		return activityRecords;
	}
	public void setActivityRecords(Set<ActivityRecord> activityRecords) {
		this.activityRecords = activityRecords;
	}
	@JoinColumn(name="activityId")
	@ManyToOne(targetEntity=Activity.class,fetch = FetchType.EAGER)
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
