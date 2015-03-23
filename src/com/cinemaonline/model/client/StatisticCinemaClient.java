package com.cinemaonline.model.client;

import java.util.List;


public class StatisticCinemaClient {

	private List<StatisticPersonSumDay> cinemapersonsum_daylist;
	private int cinemapersonsum_month;
	private List<StatisticHallAttendence> hallAttendencelist;
	private List<StatisticFilmAttendence> filmAttendencelist;
	private List<StatisticPayway> paywaylist;
	public List<StatisticPersonSumDay> getCinemapersonsum_daylist() {
		return cinemapersonsum_daylist;
	}
	public void setCinemapersonsum_daylist(
			List<StatisticPersonSumDay> cinemapersonsum_daylist) {
		this.cinemapersonsum_daylist = cinemapersonsum_daylist;
	}
	public int getCinemapersonsum_month() {
		return cinemapersonsum_month;
	}
	public void setCinemapersonsum_month(int cinemapersonsum_month) {
		this.cinemapersonsum_month = cinemapersonsum_month;
	}
	public List<StatisticHallAttendence> getHallAttendencelist() {
		return hallAttendencelist;
	}
	public void setHallAttendencelist(
			List<StatisticHallAttendence> hallAttendencelist) {
		this.hallAttendencelist = hallAttendencelist;
	}
	public List<StatisticFilmAttendence> getFilmAttendencelist() {
		return filmAttendencelist;
	}
	public void setFilmAttendencelist(
			List<StatisticFilmAttendence> filmAttendencelist) {
		this.filmAttendencelist = filmAttendencelist;
	}
	public List<StatisticPayway> getPaywaylist() {
		return paywaylist;
	}
	public void setPaywaylist(List<StatisticPayway> paywaylist) {
		this.paywaylist = paywaylist;
	}
	
}
