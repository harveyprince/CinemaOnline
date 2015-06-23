package com.cinemaonline.model.client;


public class StatisticTimeAttendence {

	private String time;
	private double attendence = 0;
	
	public double getAttendence() {
		return attendence;
	}
	public void setAttendence(double attendence) {
		this.attendence = attendence;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
