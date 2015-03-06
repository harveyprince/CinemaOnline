package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	private long id;//账户ID
	private String accountName;//账号
	private String password;//密码[加密?]
	private int identityId;//身份级
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentity(int identityId) {
		this.identityId = identityId;
	}

}
