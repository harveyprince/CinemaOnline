package com.cinemaonline.model.client;

import java.util.Date;

import com.cinemaonline.model.TicketRecord;

public class TicketOrder {

	private long planid;
	private int seatNum;
	private int identity;
	private AccountLogin vip_account;
	private double cost;
	private double discount=1.0;
	private int payway;
	private BankOperaInfo bank_account;
	
	public TicketRecord constructTicketRecord(){
		TicketRecord record = new TicketRecord();
		record.setFilmplanId(planid);
		record.setRecordTime((new Date()).getTime());
		record.setPayWay(payway);
		long identifynum = identity==1?Long.parseLong(vip_account.getAccountName()):(new Date()).getTime();
		record.setIdentifyNumber(identifynum);
		return record;
	}
	public long getPlanid() {
		return planid;
	}
	public void setPlanid(long planid) {
		this.planid = planid;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public AccountLogin getVip_account() {
		return vip_account;
	}
	public void setVip_account(AccountLogin vip_account) {
		this.vip_account = vip_account;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getPayway() {
		return payway;
	}
	public void setPayway(int payway) {
		this.payway = payway;
	}
	public BankOperaInfo getBank_account() {
		return bank_account;
	}
	public void setBank_account(BankOperaInfo bank_account) {
		this.bank_account = bank_account;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
