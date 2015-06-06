package com.cinemaonline.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.Bank;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.service.InfoService;
import com.cinemaonline.service.StatisticService;
import com.cinemaonline.service.VipService;

@Repository
public class TestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private InfoService infoService;
	@Autowired
	private StatisticService statisticService;
	@Autowired
	private VipService vipService;
	
	public String Viplvcost(){
		vipService.vipLevelCostJudge();
		return AJAXINFO;
	}
	
	public String MonthCron(){
		statisticService.doStatic();
		return AJAXINFO;
	}
	
	public String DataInit(){
//		Location
		String[] locations = {"玄武区","鼓楼区","建邺区","白下区","秦淮区","下关区","雨花台区","浦口区","栖霞区","江宁区","六合区"};
		for(String temp:locations){
			Location lc0 = new Location();
			lc0.setStrdescribe(temp);
			infoService.addLocation(lc0);
		}
//		user
		//server
		Account ac0 = new Account();
		ac0.setAccountName("1234567");
		ac0.setPassword("202cb962ac59075b964b07152d234b70");//123
		ac0.setIdentityId(2);
		infoService.addAccount(ac0);
		//manager
		Account ac1 = new Account();
		ac1.setAccountName("7654321");
		ac1.setPassword("202cb962ac59075b964b07152d234b70");//123
		ac1.setIdentityId(3);
		infoService.addAccount(ac1);
		
//		bank
		Bank bank0 = new Bank();
		bank0.setBalance(1000);
		bank0.setCardId(1234567);
		bank0.setPassword("1234567");
		bank0.setName("jar");
		infoService.addBank(bank0);
		
		Bank bank1 = new Bank();
		bank1.setBalance(100);
		bank1.setCardId(12345678);
		bank1.setPassword("12345678");
		bank1.setName("jj");
		infoService.addBank(bank1);
		
		Bank bank2 = new Bank();
		bank2.setBalance(999999);
		bank2.setCardId(12345);
		bank2.setPassword("12345");
		bank2.setName("ban2");
		infoService.addBank(bank2);
		
//		hall
		Hall hall0 = new Hall();
		hall0.setSeats(56);
		hall0.setName("no.1");
		infoService.addHall(hall0);
		
		Hall hall1 = new Hall();
		hall1.setSeats(50);
		hall1.setName("no.2");
		infoService.addHall(hall1);
		
		Hall hall2 = new Hall();
		hall2.setSeats(40);
		hall2.setName("no.3");
		infoService.addHall(hall2);
//		identity
		Identity iden0 = new Identity();
		iden0.setIdentityId(0);
		iden0.setStrdescribe("visitor");
		infoService.addIdentity(iden0);
		
		Identity iden1 = new Identity();
		iden1.setIdentityId(1);
		iden1.setStrdescribe("vip");
		infoService.addIdentity(iden1);
		
		Identity iden2 = new Identity();
		iden2.setIdentityId(2);
		iden2.setStrdescribe("server");
		infoService.addIdentity(iden2);
		
		Identity iden3 = new Identity();
		iden3.setIdentityId(3);
		iden3.setStrdescribe("manager");
		infoService.addIdentity(iden3);
		
		Identity iden4 = new Identity();
		iden4.setIdentityId(4);
		iden4.setStrdescribe("mainmanager");
		infoService.addIdentity(iden4);
//		viplevel
		VipLevel lv0 = new VipLevel();
		lv0.setLevelId(0);
		lv0.setCost(30);
		lv0.setLvName("lv1");
		lv0.setDiscount(0.9);
		infoService.addVipLevel(lv0);
		
		VipLevel lv1 = new VipLevel();
		lv1.setLevelId(1);
		lv1.setCost(60);
		lv1.setLvName("lv2");
		lv1.setDiscount(0.8);
		infoService.addVipLevel(lv1);
		
		VipLevel lv2 = new VipLevel();
		lv2.setLevelId(2);
		lv2.setCost(90);
		lv2.setLvName("lv3");
		lv2.setDiscount(0.7);
		infoService.addVipLevel(lv2);
		
		return AJAXINFO;
	}
}
