package com.cinemaonline.model.client;

public class FilmProfitFromClient {
	private Long filmId;
	private double profitPercent;//乘以100后的
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public double getProfitPercent() {
		return profitPercent;
	}
	public void setProfitPercent(double profitPercent) {
		this.profitPercent = profitPercent;
	}
	
}
