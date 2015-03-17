package com.cinemaonline.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VipRecord")
public class VipRecord {
	private long recordId;//记录流水号
	private String vipId;//编号
	private long recordTime;//操作时间
	private double recordNumber;//操作数[+50/-50]
	private int result;//操作结果 0失败 1成功
	private String comment;//备注[失败原因]
	private String purpose;//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public String getVipId() {
		return vipId;
	}
	public void setVipId(String vipId) {
		this.vipId = vipId;
	}
	public long getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}
	public double getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(double recordNumber) {
		this.recordNumber = recordNumber;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}
