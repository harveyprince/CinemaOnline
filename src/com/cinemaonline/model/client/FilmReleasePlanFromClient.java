package com.cinemaonline.model.client;

import java.util.List;

public class FilmReleasePlanFromClient {
	private List<Integer> hallNolist;
	private List<Integer> playTimeslist;
	private Long filmId;
	private Long beginTime = -1L;
	private int dayslength;
	private int price;
	public List<Integer> getHallNolist() {
		return hallNolist;
	}
	public void setHallNolist(List<Integer> hallNolist) {
		this.hallNolist = hallNolist;
	}
	public List<Integer> getPlayTimeslist() {
		return playTimeslist;
	}
	public void setPlayTimeslist(List<Integer> playTimeslist) {
		this.playTimeslist = playTimeslist;
	}
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public Long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public int getDayslength() {
		return dayslength;
	}
	public void setDayslength(int dayslength) {
		this.dayslength = dayslength;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
