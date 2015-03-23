package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Identity")
public class Identity {
	private int identityId;//身份级别
	private String strdescribe;//身份描述
	
	@Id
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	public String getStrdescribe() {
		return strdescribe;
	}
	public void setStrdescribe(String strdescribe) {
		this.strdescribe = strdescribe;
	}


}
