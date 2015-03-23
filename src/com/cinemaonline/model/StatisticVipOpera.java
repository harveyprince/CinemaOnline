package com.cinemaonline.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatisticVipOpera")
public class StatisticVipOpera {
	private long statisticId;
	private double consumesum;
	private int activityparticipatesum;
	private int year;
	private int month;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getStatisticId() {
		return statisticId;
	}
	public void setStatisticId(long statisticId) {
		this.statisticId = statisticId;
	}
	public double getConsumesum() {
		return consumesum;
	}
	public void setConsumesum(double consumesum) {
		this.consumesum = consumesum;
	}
	public int getActivityparticipatesum() {
		return activityparticipatesum;
	}
	public void setActivityparticipatesum(int activityparticipatesum) {
		this.activityparticipatesum = activityparticipatesum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	
	

}
