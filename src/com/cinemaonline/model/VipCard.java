package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VipCard")
public class VipCard {
	private String vipId;//编号
//	private int levelId;//会员卡级别
	private int score;//积分
	private double balance;//卡内余额
	private VipLevel vipLevel;//会员级别
	
	@Id
	public String getVipId() {
		return vipId;
	}
	public void setVipId(String vipId) {
		this.vipId = vipId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@JoinColumn(name="levelId")
	@ManyToOne(targetEntity=VipLevel.class)
	public VipLevel getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(VipLevel vipLevel) {
		this.vipLevel = vipLevel;
	}

}
