package com.cinemaonline.model.client;

import com.cinemaonline.model.Film;

public class StatisticFilmAttendence {

	private Film film;
	private double attendence = 0;
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public double getAttendence() {
		return attendence;
	}
	public void setAttendence(double attendence) {
		this.attendence = attendence;
	}
}
