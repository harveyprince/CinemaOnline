package com.cinemaonline.model.client;

public class BankOperaInfo {
	
	private long userId;//银行帐号
	private int operateNum;//正负充值消费
	public int getOperateNum() {
		return operateNum;
	}
	public void setOperateNum(int operateNum) {
		this.operateNum = operateNum;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
