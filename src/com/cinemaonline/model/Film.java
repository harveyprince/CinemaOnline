package com.cinemaonline.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Film")
public class Film {
	private long filmId;//电影流水号
	private String name;//电影名称
	private int duration;//时长
	private String kind;//分类
	private Date releaseTime;//上映时间
	private Date shelvesTime;//下架时间
	private int status;//电影状态[0下架,1上映]
	private Set<FilmPlan> filmPlans;//计划
	
	
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	@OneToMany(cascade=CascadeType.ALL,mappedBy="film")
	public Set<FilmPlan> getFilmPlans() {
		return filmPlans;
	}
	public void setFilmPlans(Set<FilmPlan> filmPlans) {
		this.filmPlans = filmPlans;
	}

}
