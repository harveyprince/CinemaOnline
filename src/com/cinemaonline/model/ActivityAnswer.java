package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ActivityAnswer")
public class ActivityAnswer {
	private long activityId;//活动流水号
	private int answerId;//选项ID
	private String answerContent;//选项内容
	
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
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

}
