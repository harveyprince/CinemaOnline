package com.cinemaonline.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="StatisticLocation")
public class StatisticLocation {
	private long statisticId;
	private Location location;
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
	@JoinColumn(name="locationId")
	@ManyToOne(targetEntity=Location.class,fetch = FetchType.EAGER)
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
	
	

}
