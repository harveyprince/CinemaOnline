package com.cinemaonline.model.client;

import java.util.Date;

import com.cinemaonline.model.VipInfo;

public class VipClientInfo {
	private String vipid;
	private Date birthday;
	private String strbirthday;
	private String location;
	private String name;
	private int sex;
	
	public void setByTable(VipInfo info){
		setVipid(info.getVipId());
		setBirthday(info.getBirthday());
		setLocation(info.getLocation());
		setName(info.getName());
		setSex(info.getSex());
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
		this.strbirthday = (this.birthday.toLocaleString()).split(" ")[0];
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
	public void setSex(String sex) {
		this.sex = Integer.parseInt(sex);
	}
	public String getStrbirthday() {
		return strbirthday;
	}
	public void setStrbirthday(String strbirthday) {
		this.strbirthday = strbirthday;
	}
}
