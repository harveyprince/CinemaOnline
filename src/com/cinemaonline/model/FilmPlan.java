package com.cinemaonline.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FilmPlan")
public class FilmPlan {
	private long planId;//计划流水号
	private int hallNo;//厅号
	private int seatSum;//座位
	private long filmId;//电影流水号
	private Date beginTime;//开始时间
	private Date endTime;//结束时间
	private double price;//价格
	private int status;//状态[待批准、通过]
	
	@Id
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public int getSeatSum() {
		return seatSum;
	}
	public void setSeatSum(int seatSum) {
		this.seatSum = seatSum;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
