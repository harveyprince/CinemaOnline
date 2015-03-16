package com.cinemaonline.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.service.VipService;

@Repository
public class VipAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private VipService vipService;
	
	private String ajaxinfo;
	private VipClientInfo vipinfo;
	
	public String viewInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(false);
		 String userid = (String)session.getAttribute("userid");
		 vipinfo = vipService.getVipInfoForClient(userid);
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
}
