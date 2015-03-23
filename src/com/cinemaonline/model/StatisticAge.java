package com.cinemaonline.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StatisticAge")
public class StatisticAge {
	private long statisticId;
	private String age_block;
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
	public String getAge_block() {
		return age_block;
	}
	public void setAge_block(String age_block) {
		this.age_block = age_block;
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
	
	
	

}
