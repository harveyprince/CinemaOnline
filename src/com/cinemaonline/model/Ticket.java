package com.cinemaonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {
	private long ticketId;//票面流水ID
//	private long recordId;//售票流水号
	private int seatNumber;//座位号
	private TicketRecord ticketRecord;//售票记录
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	@JoinColumn(name="recordId")
	@ManyToOne(targetEntity=TicketRecord.class)
	public TicketRecord getTicketRecord() {
		return ticketRecord;
	}
	public void setTicketRecord(TicketRecord ticketRecord) {
		this.ticketRecord = ticketRecord;
	}

}
