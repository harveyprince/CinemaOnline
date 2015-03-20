package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VipLevel")
public class VipLevel {
	private int levelId;//会员级别
	private double cost;//价格
	private String lvName;//
	private double discount;//折扣
	
	@Id
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getLvName() {
		return lvName;
	}
	public void setLvName(String lvName) {
		this.lvName = lvName;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
