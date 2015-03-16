package com.cinemaonline.model.client;

import java.util.Date;

import com.cinemaonline.model.VipInfo;

public class VipClientInfo {
	private String vipid;
	private Date birthday;
	private String location;
	private String name;
	private int sex;
	
	public void setByTable(VipInfo info){
		vipid = info.getVipId();
		birthday = info.getBirthday();
		location = info.getLocation();
		name = info.getName();
		sex = info.getSex();
	}
	public String getVipid() {
		return vipid;
	}
	public void setVipid(String vipid) {
		this.vipid = vipid;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}
