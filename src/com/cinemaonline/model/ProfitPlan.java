package com.cinemaonline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private Set<Film> films;//盈利计划对应影片
	private long publishTime;//计划发布时间
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
	@OneToMany(cascade=CascadeType.ALL,mappedBy="profitPlan")
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
}
