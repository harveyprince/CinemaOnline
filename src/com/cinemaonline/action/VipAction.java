package com.cinemaonline.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
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
		 OperaResult result = vipService.cardActivatedCheck(userid);//检测卡是否存在，不存在则未激活
		 if(result.getResult()){
			 
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
		 info.setOperateNum(request.getParameter("num"));
		 if(info.getOperateNum()<200){
			 ajaxinfo = "less";
			 return SUCCESS;
		 }
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
//			 
		 }
		return SUCCESS;
	}
//	money in
	public String rechargeCard(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
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
}
