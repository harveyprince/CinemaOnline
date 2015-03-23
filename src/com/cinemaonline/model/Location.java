package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location {
	private int locationId;//地区号
	private String strdescribe;//地区描述
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getStrdescribe() {
		return strdescribe;
	}
	public void setStrdescribe(String strdescribe) {
		this.strdescribe = strdescribe;
	}

	
	

}
