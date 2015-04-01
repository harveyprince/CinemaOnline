package com.cinemaonline.service;

import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;

public interface TicketService {

	OperaResult judgeTicket(TicketOrder info);

	OperaResult payTheBill(TicketOrder order);

	OperaResult judgeTicketForVip(TicketOrder ticketOrder);

}
