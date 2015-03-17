package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.VipRecord;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private VipDao vipDao;
	@Autowired
	private TicketDao ticketDao;
	
	@Override
	public OperaResult insertVipRecord(VipOperaInfo info) {
		// TODO Auto-generated method stub
		VipRecord record = info.constructRecord();
		vipDao.insertRecord(record);
		OperaResult result = new OperaResult();
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult insertTicketRecord(TicketOrder info) {
		// TODO Auto-generated method stub
		return null;
	}

}
