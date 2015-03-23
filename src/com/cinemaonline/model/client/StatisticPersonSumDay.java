package com.cinemaonline.model.client;

import java.util.Calendar;

public class StatisticPersonSumDay {

	private Calendar cal;
	private int personsum;
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal.setTime(cal.getTime());;
	}
	public int getPersonsum() {
		return personsum;
	}
	public void setPersonsum(int personsum) {
		this.personsum = personsum;
	}
	
}
