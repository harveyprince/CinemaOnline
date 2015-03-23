package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ActivityRecord")
public class ActivityRecord {
	private long recordId;//记录流水号
	private long vipId;//会员编号
//	private long activityAnswerId;//活动答案流水号
	private ActivityAnswer activityAnswer;//活动答案
	private long recordTime;//记录时间
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	
	public long getVipId() {
		return vipId;
	}
	public void setVipId(long vipId) {
		this.vipId = vipId;
	}
	@JoinColumn(name="activityAnswerId")
	@ManyToOne(targetEntity=ActivityAnswer.class)
	public ActivityAnswer getActivityAnswer() {
		return activityAnswer;
	}
	public void setActivityAnswer(ActivityAnswer activityAnswer) {
		this.activityAnswer = activityAnswer;
	}
	public long getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}

}
