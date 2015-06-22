package com.cinemaonline.model.client;

import com.cinemaonline.model.FilmType;

public class StatisticTypeAttendence {

	private FilmType filmType;
	private double attendence = 0;

	public double getAttendence() {
		return attendence;
	}
	public void setAttendence(double attendence) {
		this.attendence = attendence;
	}
	public FilmType getFilmType() {
		return filmType;
	}
	public void setFilmType(FilmType filmType) {
		this.filmType = filmType;
	}
}
