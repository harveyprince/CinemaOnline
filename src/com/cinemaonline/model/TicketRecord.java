package com.cinemaonline.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TicketRecord")
public class TicketRecord {
	private long recordId;//售票记录流水号
	private Date recordTime;//时间
	private int identityId;//身份级
	private long identifyNumber;//识别码[游客流水/会员ID]游客流水采用时间戳
	private long filmplanId;//放映计划流水号
	private int payWay;//交易方式[有卡/无卡/现金]
	
	@Id
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	public long getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(long identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public long getFilmplanId() {
		return filmplanId;
	}
	public void setFilmplanId(long filmplanId) {
		this.filmplanId = filmplanId;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}

}
