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
@Table(name="FilmReleasePlan")
public class FilmReleasePlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;//流水
	@JoinColumn(name="filmId")
	@ManyToOne(targetEntity=Film.class,fetch = FetchType.EAGER)
	private Film film;//影片
	@JoinColumn(name="hallNo")
	@ManyToOne(targetEntity=Hall.class,fetch = FetchType.EAGER)
	private Hall hall;
	private Long beginTime;
	private Long endTime;
	private int playTimes;//该影片单日在该厅的播放次数
	private int price;//票价
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public int getPlayTimes() {
		return playTimes;
	}
	public void setPlayTimes(int playTimes) {
		this.playTimes = playTimes;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
