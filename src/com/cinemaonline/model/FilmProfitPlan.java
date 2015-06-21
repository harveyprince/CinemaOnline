package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FilmProfitPlan")
public class FilmProfitPlan {
	private long id;//流水
	private Film film;//影片
	private ProfitPlan profitPlan;//盈利计划
	private double profitPercent;//盈利计划对应百分比[乘以100
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@JoinColumn(name="profitPlanId")
	@ManyToOne(targetEntity=ProfitPlan.class,fetch = FetchType.EAGER)
	public ProfitPlan getProfitPlan() {
		return profitPlan;
	}
	public void setProfitPlan(ProfitPlan profitPlan) {
		this.profitPlan = profitPlan;
	}
	public double getProfitPercent() {
		return profitPercent;
	}
	public void setProfitPercent(double profitPercent) {
		this.profitPercent = profitPercent;
	}
	@OneToOne
	@JoinColumn(name="filmId")
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
}
