package com.cinemaonline.model.client;

import com.cinemaonline.model.Hall;

public class StatisticHallAttendence {

	private Hall hall;
	private double attendence;
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public double getAttendence() {
		return attendence;
	}
	public void setAttendence(double attendence) {
		this.attendence = attendence;
	}
}
