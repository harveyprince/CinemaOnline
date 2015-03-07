package com.cinemaonline.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VipRecord")
public class VipRecord {
	private long recordId;//记录流水号
	private long vipId;//编号
	private Date recordTime;//操作时间
	private double recordNumber;//操作数[+50/-50]
	private String result;//操作结果
	private String comment;//备注[失败原因]
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public long getVipId() {
		return vipId;
	}
	public void setVipId(long vipId) {
		this.vipId = vipId;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public double getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(double recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
