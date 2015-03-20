package com.cinemaonline.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="FilmPlan")
public class FilmPlan {
	private long planId;//计划流水号
//	private int hallNo;//厅号
	private Hall hall;
	private int seatSum;//座位
//	private long filmId;//电影流水号
	private long beginTime;//开始时间
	private long endTime;//结束时间
	private double price;//价格
	private int status;//状态[0未审核、1待批准、2通过、3驳回]
	private Set<Activity> activities;//活动
	private Film film;//电影
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	@OneToOne
	@JoinColumn(name="hallNo")
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public int getSeatSum() {
		return seatSum;
	}
	public void setSeatSum(int seatSum) {
		this.seatSum = seatSum;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
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
	@ManyToMany(mappedBy="plans",fetch = FetchType.EAGER)
	public Set<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	@JoinColumn(name="filmId")
	@ManyToOne(targetEntity=Film.class,fetch = FetchType.EAGER)
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}


}
