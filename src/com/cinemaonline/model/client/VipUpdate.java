package com.cinemaonline.model.client;

import java.sql.Date;

import com.cinemaonline.model.VipInfo;

public class VipUpdate {
	private String name;
	private int sex;
	private Date birthday;
	private String location;
	
	public VipInfo setBase(VipInfo info){
		VipInfo info_local = info;
		if(birthday!=null)info_local.setBirthday(birthday);
		if(location!=null&&location.length()>0)info_local.setLocation(location);
		if(name!=null&&name.length()>0)info_local.setName(name);
		info_local.setSex(sex);
		return info_local;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = Date.valueOf(birthday);
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
