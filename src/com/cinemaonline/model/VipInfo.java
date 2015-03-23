package com.cinemaonline.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VipInfo")
public class VipInfo {
//	private long accountId;//账户编号
	private Account account;//账户
	private String vipId;//会员编号
	private Date birthday;//出生日期
	private int sex;//性别[1代表男,0代表女]
	private Location location;//居住地
	private String name;//姓名
	private String email;//邮箱
	private int vipStatus;//会员状态[1正常/2暂停/0未激活/4停止/5取消]
	private VipCard vipCard;//会员卡
	private Set<VipRecord> vipRecords;//会员记录
	
	@Id
	public String getVipId() {
		return vipId;
	}
	public void setVipId(String vipId) {
		this.vipId = vipId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@JoinColumn(name="locationId")
	@ManyToOne(targetEntity=Location.class)
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVipStatus() {
		return vipStatus;
	}
	public void setVipStatus(int vipStatus) {
		this.vipStatus = vipStatus;
	}
	@OneToOne
	@JoinColumn(name="accountId")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@OneToOne
	@JoinColumn(name="vipId")
	public VipCard getVipCard() {
		return vipCard;
	}
	public void setVipCard(VipCard vipCard) {
		this.vipCard = vipCard;
	}
	@OneToMany
	@JoinColumn(name="vipId")
	public Set<VipRecord> getVipRecords() {
		return vipRecords;
	}
	public void setVipRecords(Set<VipRecord> vipRecords) {
		this.vipRecords = vipRecords;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
