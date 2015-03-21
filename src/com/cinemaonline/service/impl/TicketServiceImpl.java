package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.dao.TicketDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Ticket;
import com.cinemaonline.model.TicketRecord;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.service.BankService;
import com.cinemaonline.service.RecordService;
import com.cinemaonline.service.TicketService;
import com.cinemaonline.service.VipService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private VipDao vipDao;
	@Autowired
	private VipService vipService;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private FilmDao filmDao;
	@Autowired
	private BankService bankService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private InfoDao infoDao;
	
	@Override
	public OperaResult judgeTicket(TicketOrder info) {
		// TODO Auto-generated method stub
		TicketOrder info_local = info;
		OperaResult result = new OperaResult();
//		identity judge
		if(info.getIdentity()==1){
//			vip
			OperaResult vipcheck = vipService.checkVipAccount(info.getVip_account());
			if(vipcheck.getResult()){
				VipInfo vipinfo = vipDao.getVipInfoById(info.getVip_account().getAccountName());
				if(vipinfo.getVipStatus()==1){
					info_local.setDiscount(vipinfo.getVipCard().getVipLevel().getDiscount());
				}else{
					result.setResult(false);
					result.setComment("card is not activated");
					return result;
				}
			}else{
				result = vipcheck;
				return result;
			}
		}else{
//			youke
			info_local.setDiscount(1);// actually no need to do this as default is 1
		}
		FilmPlan filmplan = filmDao.getFilmPlanById(info.getPlanid());
		if(filmplan.getSeatSum()<info.getSeatNum()){
			result.setResult(false);
			result.setComment("the seats left are not enough");
			return result;
		}
		info_local.setCost(info_local.getDiscount()*filmplan.getPrice()*info_local.getSeatNum());
		result.setResult(true);
		result.setTicketOrder(info_local);
		return result;
	}

	@Override
	public OperaResult payTheBill(TicketOrder order) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
//		payway
		if(order.getPayway()==1){
//			bank card
			BankOperaInfo boi = order.getBank_account();
			boi.setConsume(order.getCost());
			OperaResult bankpayresult = bankService.pay(boi);
			if(bankpayresult.getResult()){
				//
			}else{
				result = bankpayresult;
				return result;
			}
		}
		if(order.getPayway()==2){
//			vip card
			VipOperaInfo voi = new VipOperaInfo();
			voi.setUserid(order.getVip_account().getAccountName());
			voi.setCostNum(order.getCost());
			voi.setPurpose("ticket pay");
			OperaResult vippayresult = vipService.cardBalanceOpera(voi);
			if(vippayresult.getResult()){
				//
			}else{
				result = vippayresult;
				return result;
			}
		}
		TicketRecord ticketRecord = recordService.insertTicketRecord(order);
		FilmPlan fp = filmDao.getFilmPlanById(order.getPlanid());
		if(fp.getSeatSum()<order.getSeatNum()){
			result.setResult(false);
			result.setComment("seats not enough");
			return result;
		}
		for(int i = fp.getSeatSum();i>fp.getSeatSum()-order.getSeatNum();i--){
			Ticket tick = new Ticket();
			tick.setSeatNumber(i);
			tick.setTicketRecord(ticketRecord);
			ticketDao.insertTicket(tick);
		}
		fp.setSeatSum(fp.getSeatSum()-order.getSeatNum());
		filmDao.updateFilmPlan(fp);
		ticketRecord = ticketDao.getRecordById(ticketRecord.getRecordId());
		result.setResult(true);
		result.setTicketRecord(ticketRecord);
		return result;
	}

}
