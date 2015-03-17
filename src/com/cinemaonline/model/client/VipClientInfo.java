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
	private int status;
	private String strstatus;
	
	public void setByTable(VipInfo info){
		setVipid(info.getVipId());
		setBirthday(info.getBirthday());
		setLocation(info.getLocation());
		setName(info.getName());
		setSex(info.getSex());
		setStatus(info.getVipStatus());
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
//		[1正常/2暂停/0未激活/4停止/5取消]
		switch(status){
		case 0:
			setStrstatus("disactivate");
			break;
		case 1:
			setStrstatus("normal");
			break;
		case 2:
			setStrstatus("pause");
			break;
		case 3:
			setStrstatus("stop");
			break;
		case 4:
			setStrstatus("canceled");
			break;
		default:
			break;
		}
	}
	public String getStrstatus() {
		return strstatus;
	}
	public void setStrstatus(String strstatus) {
		this.strstatus = strstatus;
	}
}
