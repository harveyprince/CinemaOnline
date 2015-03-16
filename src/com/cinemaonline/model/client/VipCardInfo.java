package com.cinemaonline.model.client;

import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipLevel;

public class VipCardInfo {
	private String vipid;
	private int score = 0;
	private double balance = 0.0;
	private int viplevel;
	private VipLevel vipLevel;
	
	public VipCard getCardInfo(){
		VipCard info = new VipCard();
		info.setBalance(balance);
		info.setScore(score);
		info.setVipId(vipid);
		info.setVipLevel(vipLevel);
		return info;
	}
	public String getVipid() {
		return vipid;
	}
	public void setVipid(String vipid) {
		this.vipid = vipid;
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
	public int getViplevel() {
		return viplevel;
	}
	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}
	public VipLevel getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(VipLevel vipLevel) {
		this.vipLevel = vipLevel;
	}
}
