package com.cinemaonline.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatisticCardStatus")
public class StatisticCardStatus {
	private long statisticId;
	private int status;
	private int personsum;
	private int year;
	private int month;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getStatisticId() {
		return statisticId;
	}
	public void setStatisticId(long statisticId) {
		this.statisticId = statisticId;
	}
	public int getPersonsum() {
		return personsum;
	}
	public void setPersonsum(int personsum) {
		this.personsum = personsum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	

}
