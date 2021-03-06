package com.cinemaonline.model.client;

import java.sql.Date;

import com.cinemaonline.model.VipInfo;

public class VipUpdate {
	private String name;
	private int sex;
	private Date birthday;
	private int location;
	
	public VipInfo setBase(VipInfo info){
		VipInfo info_local = info;
		if(birthday!=null)info_local.setBirthday(birthday);
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
	public void setSex(String sex) {
		this.sex = Integer.parseInt(sex);
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
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}

}
