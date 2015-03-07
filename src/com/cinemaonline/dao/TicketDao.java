package com.cinemaonline.dao;

import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;

public interface TicketDao {
	
	public OperaResult sellTicket(TicketOrder order);

}
