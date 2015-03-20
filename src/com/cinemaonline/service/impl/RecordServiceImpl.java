package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.TicketRecord;
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
	@Autowired
	private InfoDao infoDao;
	
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
	public TicketRecord insertTicketRecord(TicketOrder info) {
		// TODO Auto-generated method stub
		TicketRecord record = info.constructTicketRecord();
		Identity identity = infoDao.getIdentityById(info.getIdentity());
		record.setIdentity(identity);
		return ticketDao.insertRecord(record);
	}

}
