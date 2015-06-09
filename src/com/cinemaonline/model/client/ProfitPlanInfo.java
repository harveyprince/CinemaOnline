package com.cinemaonline.model.client;

public class ProfitPlanInfo {

	private long profitsum;
	private String[] films;
	public long getProfitsum() {
		return profitsum;
	}
	public void setProfitsum(long profitsum) {
		this.profitsum = profitsum;
	}
	public String[] getFilms() {
		return films;
	}
	public void setFilms(String[] films) {
		this.films = films;
	}
}
