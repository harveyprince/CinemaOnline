package com.cinemaonline.model.client;

import java.sql.Date;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.VipInfo;

public class AccountSignUp {
	private String email;
	private int identityid = 1;
	private String password;
	private String passwordRepeat;
	private Date birthday;
	private int sex;
	private String location;
	private String name;
	
	public Account getAccount(){
		Account account = new Account();
		if(password.length()>0){
			account.setPassword(password);
			account.setIdentityId(identityid);
			return account;
		}else{
			return null;
		}
	}
	
	public VipInfo constructVipInfo(Account account){
		VipInfo info = new VipInfo();
		if(account!=null){
			info.setAccount(account);
			info.setBirthday(birthday);
			info.setEmail(email);
			info.setLocation(location);
			info.setName(name);
			info.setSex(sex);
			info.setVipId(account.getAccountName());
			return info;
		}else{
			return null;
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday =Date.valueOf(birthday);
		///////////////////////////////////////////////////////////////////////////////////////////////////
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

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public int getIdentityid() {
		return identityid;
	}

	public void setIdentityid(int identityid) {
		this.identityid = identityid;
	}
	
	
}
