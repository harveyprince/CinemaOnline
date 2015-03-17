package com.cinemaonline.service;

import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;
import com.cinemaonline.model.client.VipOperaInfo;

public interface RecordService {
	public OperaResult insertVipRecord(VipOperaInfo info);
	
	public OperaResult insertTicketRecord(TicketOrder info);
}
