package com.cinemaonline.model.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cinemaonline.model.VipRecord;

public class VipRecordInfo {
	private long recordId;
	private String vipId;
	private long recordTime;
	private Date recordTimeDate;
	private double recordNumber;
	private int result;
	private String strresult;
	private String comment;
	private String purpose;
	public void setVipRecord(VipRecord info){
		if(info==null){
			return;
		}
		setComment(info.getComment());
		setPurpose(info.getPurpose());
		setRecordId(info.getRecordId());
		setRecordNumber(info.getRecordNumber());
		setRecordTime(info.getRecordTime());
		setResult(info.getResult());
		setVipId(info.getVipId());
	}
	
	public static List<VipRecordInfo> parseVRI(List<VipRecord> infolist){
		if(infolist==null){
			return null;
		}
		List<VipRecordInfo> info = new ArrayList<VipRecordInfo>();
		for(VipRecord rc:infolist){
			VipRecordInfo rci =  new VipRecordInfo();
			rci.setVipRecord(rc);
			info.add(rci);
		}
		return info;
	}
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
		this.recordTimeDate = new Date(recordTime);
	}
	public Date getRecordTimeDate() {
		return recordTimeDate;
	}
	public void setRecordTimeDate(Date recordTimeDate) {
		this.recordTimeDate = recordTimeDate;
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
		this.strresult = result==1?"success":"failed";
	}
	public String getStrresult() {
		return strresult;
	}
	public void setStrresult(String strresult) {
		this.strresult = strresult;
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
