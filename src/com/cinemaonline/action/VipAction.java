package com.cinemaonline.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
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
	/*
	 * info
	 * */
	public String viewInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
		 vipinfo = vipService.getVipInfoForClient(userid);
		return SUCCESS;
	}
	
	public String updateInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
		VipUpdate info = new VipUpdate();
		info.setBirthday(request.getParameter("birthday"));
		info.setLocation(request.getParameter("location"));
		info.setName(request.getParameter("name"));
		info.setSex(request.getParameter("sex"));
		OperaResult result = vipService.vipinfoUpate(info,userid);
		if(result.getResult()){
			ajaxinfo = "success";
			return SUCCESS;
		}else{
			ajaxinfo = "error";
			return ERROR;
		}
	}
	
	/*
	 * card
	 * */
	public String viewCard(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
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
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
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
			 return SUCCESS;
		 }
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
			 OperaResult activate_result = vipService.cardActivate(infocard);
			 if(activate_result.getResult()){
				 OperaResult levelcost_result = vipService.cardLevelCost(userid);
				 if(levelcost_result.getResult()){
					 ajaxinfo = "success";
					 return SUCCESS;
				 }else{
					 ajaxinfo = "lvcostfailed";
					 return SUCCESS;
				 }
			 }else{
				 ajaxinfo = "activatefailed";
			 }
		 }else{
			 ajaxinfo="bankcostfailed";
		 }
		return SUCCESS;
	}
//	money in
	public String rechargeCard(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
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
}
