package com.cinemaonline.model;

import java.sql.Date;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Film")
public class Film {
	private long filmId;//电影流水号
	private String name;//电影名称
	private int duration;//时长
	private Date releaseTime;//上映时间
	private Date shelvesTime;//下架时间
	private int status;//电影状态[0不可见,1可见,2结束]
	private List<FilmPlan> filmPlans;//计划
	private int cost;//film cost成本
	private FilmType filmType;//电影种类
	private FilmProfitPlan filmProfitPlan;
	private List<FilmReleasePlan> filmReleasePlanlist;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Date getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(Date shelvesTime) {
		this.shelvesTime = shelvesTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="film",fetch = FetchType.EAGER)
	public List<FilmPlan> getFilmPlans() {
		return filmPlans;
	}
	public void setFilmPlans(List<FilmPlan> filmPlans) {
		this.filmPlans = filmPlans;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@JoinColumn(name="typeId")
	@ManyToOne(targetEntity=FilmType.class,fetch = FetchType.EAGER)
	public FilmType getFilmType() {
		return filmType;
	}
	public void setFilmType(FilmType filmType) {
		this.filmType = filmType;
	}
	@OneToOne(mappedBy = "film")
	public FilmProfitPlan getFilmProfitPlan() {
		return filmProfitPlan;
	}
	public void setFilmProfitPlan(FilmProfitPlan filmProfitPlan) {
		this.filmProfitPlan = filmProfitPlan;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="film")
	public List<FilmReleasePlan> getFilmReleasePlanlist() {
		return filmReleasePlanlist;
	}
	public void setFilmReleasePlanlist(List<FilmReleasePlan> filmReleasePlanlist) {
		this.filmReleasePlanlist = filmReleasePlanlist;
	}
	


}
