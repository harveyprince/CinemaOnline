package com.cinemaonline.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TicketRecord")
public class TicketRecord {
	private long recordId;//售票记录流水号
	private long recordTime;//时间
//	private int identityId;//身份级
	private Identity identity;//身份
	private long identifyNumber;//识别码[游客流水/会员ID]游客流水采用时间戳
	private long filmplanId;//放映计划流水号
	private int payWay;//交易方式[有卡/无卡/现金]
	private Set<Ticket> tickets;//票
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public long getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(long recordTime) {
		this.recordTime = recordTime;
	}
	@ManyToOne
	@JoinColumn(name="identityId")
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
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
	@OneToMany(cascade=CascadeType.ALL,mappedBy="ticketRecord")
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
