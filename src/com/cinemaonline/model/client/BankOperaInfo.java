package com.cinemaonline.model.client;

public class BankOperaInfo {
	
	private long userId;//银行帐号
	private String password;//password
	private int operateNum;//正负充值消费
	public void setConsume(int num){
		operateNum = num<0?num:-num;
	}
	public void setConsume(String num){
		int num_temp = Integer.parseInt(num);
		operateNum = num_temp<0?num_temp:-num_temp;
	}
	public int getOperateNum() {
		return operateNum;
	}
	public void setOperateNum(int operateNum) {
		this.operateNum = operateNum;
	}
	public void setOperateNum(String operateNum) {
		this.operateNum = Integer.parseInt(operateNum);
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setUserId(String userId) {
		this.userId = Long.parseLong(userId);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
