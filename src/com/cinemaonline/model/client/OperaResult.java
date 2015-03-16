package com.cinemaonline.model.client;

import com.cinemaonline.model.Account;

public class OperaResult {
	
	private boolean result;
	private String comment;
	private int status;
	private Account account;
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
