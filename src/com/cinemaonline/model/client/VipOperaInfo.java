package com.cinemaonline.model.client;

import java.util.Date;

import com.cinemaonline.model.VipRecord;

public class VipOperaInfo {
	private String userid;
	private double num;
	private String comment;
	private String purpose;
	private boolean isCost;
	private boolean result;
	private Date operaDate;
	public VipRecord constructRecord(){
		VipRecord record = new VipRecord();
		record.setComment(comment);
		record.setPurpose(purpose);
		record.setRecordNumber(num);
		record.setRecordTime(operaDate.getTime());
		record.setVipId(userid);
		record.setResult(result?1:0);
		return record;
	}
	public void setRecharge(double num){
		setNum(Math.abs(num));
	}
	public void setRecharge(String num){
		double num_temp = Double.parseDouble(num);
		setRecharge(num_temp);
	}
	public void setCostNum(double num){
		setNum(-Math.abs(num));
	}
	public void setCostNum(String num){
		double num_temp = Integer.parseInt(num);
		setCostNum(num_temp);
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
		if(num<0){
			setCost(true);
		}else{
			setCost(false);
		}
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isCost() {
		return isCost;
	}
	public void setCost(boolean isCost) {
		this.isCost = isCost;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Date getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(Date operaDate) {
		this.operaDate = operaDate;
	}
	public void dateInit(){
		this.operaDate = new Date();
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}
