package com.cinemaonline.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ProfitPlan")
public class ProfitPlan {

	private long profitPlanId;//计划流水号
	private long profitSum;//计划盈利总额
	private List<FilmProfitPlan> filmProfitPlans;//盈利计划对应影片
	private long publishTime;//计划发布时间
	private int status;//1working 0end 2已分配
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getProfitPlanId() {
		return profitPlanId;
	}
	public void setProfitPlanId(long profitPlanId) {
		this.profitPlanId = profitPlanId;
	}
	
	public long getProfitSum() {
		return profitSum;
	}
	public void setProfitSum(long profitSum) {
		this.profitSum = profitSum;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="profitPlan",fetch = FetchType.EAGER)
	public List<FilmProfitPlan> getFilmProfitPlans() {
		return filmProfitPlans;
	}
	public void setFilmProfitPlans(List<FilmProfitPlan> filmProfitPlans) {
		this.filmProfitPlans = filmProfitPlans;
	}
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
