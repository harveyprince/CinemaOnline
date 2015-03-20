package com.cinemaonline.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.Bank;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.service.InfoService;

@Repository
public class TestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private InfoService infoService;
	
	public String DataInit(){
//		user
		//server
		Account ac0 = new Account();
		ac0.setAccountName("1234567");
		ac0.setPassword("202cb962ac59075b964b07152d234b70");//123
		ac0.setIdentityId(2);
		infoService.addAccount(ac0);
		
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
		iden0.setDescribe("youke");
		infoService.addIdentity(iden0);
		
		Identity iden1 = new Identity();
		iden1.setIdentityId(1);
		iden1.setDescribe("vip");
		infoService.addIdentity(iden1);
		
		Identity iden2 = new Identity();
		iden2.setIdentityId(2);
		iden2.setDescribe("server");
		infoService.addIdentity(iden2);
		
		Identity iden3 = new Identity();
		iden3.setIdentityId(3);
		iden3.setDescribe("manager");
		infoService.addIdentity(iden3);
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
