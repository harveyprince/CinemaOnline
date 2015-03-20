package com.cinemaonline.dao;

import com.cinemaonline.model.Ticket;
import com.cinemaonline.model.TicketRecord;

public interface TicketDao {
	
	public TicketRecord insertRecord(TicketRecord record);

	public Ticket insertTicket(Ticket tick);

	public TicketRecord getRecordById(long recordId);

}
