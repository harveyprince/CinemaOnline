package com.cinemaonline.model.client;

public class StatisticPayway {

	private int payway;
	private String strpayway;
	private int sum;
	public int getPayway() {
		return payway;
	}
	public void setPayway(int payway) {
		this.payway = payway;
		switch(payway){
		case 0:
			setStrpayway("cash");
			break;
		case 1:
			setStrpayway("bank card");
			break;
		case 2:
			setStrpayway("vip card");
			break;
		}
	}
	public String getStrpayway() {
		return strpayway;
	}
	public void setStrpayway(String strpayway) {
		this.strpayway = strpayway;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
