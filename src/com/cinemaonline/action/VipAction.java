package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.BankService;
import com.cinemaonline.service.VipService;

@Repository
public class VipAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private VipService vipService;
	@Autowired
	private BankService bankService;
	
	private String ajaxinfo;
	private VipClientInfo vipinfo;
	private VipCardInfo cardinfo;
	private List<VipLevel> lvslist;
	private List<VipRecordInfo> recordlist;
	
	/*
	 * info
	 * */
	public String viewInfo(){
		String userid = (String) session.get("userid");
		 vipinfo = vipService.getVipInfoForClient(userid);
		return SUCCESS;
	}
	
	public String updateInfo(){
		String userid = (String) session.get("userid");
		VipUpdate info = new VipUpdate();
		info.setBirthday(request.getParameter("birthday"));
		info.setLocation(request.getParameter("location"));
		info.setName(request.getParameter("name"));
		info.setSex(request.getParameter("sex"));
		OperaResult result = vipService.vipinfoUpate(info,userid);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = "error";
		}
		return AJAXINFO;
	}
	
	/*
	 * card
	 * */
	public String viewCard(){
		String userid = (String) session.get("userid");
		 lvslist = vipService.getLvList();
		 vipinfo = vipService.getVipInfoForClient(userid);
		 OperaResult result = vipService.cardActivatedCheck(userid);//检测卡是否存在，不存在则未激活
		 if(result.getResult()){
			 cardinfo = vipService.getVipCardInfoForClient(userid);
			 return SUCCESS;
		 }else{
			 return ERROR;
		 }
	}
	
	public String activateCard(){
		String userid = (String) session.get("userid");
		 BankOperaInfo info = new BankOperaInfo();
		 info.setUserId(request.getParameter("bankid"));
		 info.setPassword(request.getParameter("bankps"));
		 info.setConsume(request.getParameter("num"));
		 VipCardInfo infocard = new VipCardInfo();
		 infocard.setBalance(Math.abs(info.getOperateNum()));
		 infocard.setVipid(userid);
		 infocard.setScore(0);
		 infocard.setViplevel(request.getParameter("viplevel"));
		 if(info.getOperateNum()>-200){
			 ajaxinfo = "less1";
			 return AJAXINFO;
		 }
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
			 OperaResult activate_result = vipService.cardActivate(infocard);
			 if(activate_result.getResult()){
				 OperaResult levelcost_result = vipService.cardLevelCost(userid);
				 if(levelcost_result.getResult()){
					 ajaxinfo = "success";
					 return AJAXINFO;
				 }else{
					 ajaxinfo = "lvcostfailed";
					 return AJAXINFO;
				 }
			 }else{
				 ajaxinfo = "activatefailed";
			 }
		 }else{
			 ajaxinfo="bankcostfailed";
		 }
		return AJAXINFO;
	}
//	money in
	public String rechargeCard(){
		String userid = (String) session.get("userid");
		 BankOperaInfo info = new BankOperaInfo();
		 info.setUserId(request.getParameter("bankid"));
		 info.setPassword(request.getParameter("bankps"));
		 info.setConsume(request.getParameter("num"));
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
			 VipOperaInfo opinfo = new VipOperaInfo();
			 opinfo.setUserid(userid);
			 opinfo.dateInit();
			 opinfo.setRecharge(info.getOperateNum());
			 opinfo.setPurpose("card recharge");
			 OperaResult recharge_result = vipService.cardBalanceOpera(opinfo);
			 if(recharge_result.getResult()){
				 ajaxinfo = "success";
			 }else{
				 ajaxinfo = recharge_result.getComment();
			 }
			 
		 }else{
			 ajaxinfo = bank_result.getComment();
		 }
		return AJAXINFO;
	}
	
	
	/*
	 * record
	 * */
	public String viewRecord(){
		String userid = (String) session.get("userid");
		 setRecordlist(vipService.getRecords(userid));
		return SUCCESS;
	}
// ////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}

	public VipClientInfo getVipinfo() {
		return vipinfo;
	}

	public void setVipinfo(VipClientInfo vipinfo) {
		this.vipinfo = vipinfo;
	}

	public VipCardInfo getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(VipCardInfo cardinfo) {
		this.cardinfo = cardinfo;
	}

	public List<VipLevel> getLvslist() {
		return lvslist;
	}

	public void setLvslist(List<VipLevel> lvslist) {
		this.lvslist = lvslist;
	}

	public List<VipRecordInfo> getRecordlist() {
		return recordlist;
	}

	public void setRecordlist(List<VipRecordInfo> recordlist) {
		this.recordlist = recordlist;
	}


}
