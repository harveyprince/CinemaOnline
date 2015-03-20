package com.cinemaonline.model.client;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.TicketRecord;

public class OperaResult {
	
	private boolean result;
	private String comment;
	private int status;
	private Account account;
	private TicketOrder ticketOrder;
	private TicketRecord ticketRecord;
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public TicketOrder getTicketOrder() {
		return ticketOrder;
	}
	public void setTicketOrder(TicketOrder ticketOrder) {
		this.ticketOrder = ticketOrder;
	}
	public TicketRecord getTicketRecord() {
		return ticketRecord;
	}
	public void setTicketRecord(TicketRecord ticketRecord) {
		this.ticketRecord = ticketRecord;
	}


}
