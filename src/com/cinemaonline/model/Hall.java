package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hall")
public class Hall {
	private int hallNo;
	private int seats;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
