package com.cinemaonline.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Location;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;
import com.cinemaonline.service.InfoService;
@Repository
public class AccountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AccountService accountService;
	@Autowired
	private InfoService infoService;
	
	private String ajaxinfo;
	private List<Location> locationlist;
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String welcome(){
		return SUCCESS;
	}
	
	public String welcomeRegist(){
		locationlist = infoService.getAllLocation();
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String loginJudge(){
		ajaxinfo="";
		String accountname = request.getParameter("accountid");
		String password = request.getParameter("password");
		AccountLogin info = new AccountLogin();
		info.setAccountName(accountname);
		info.setPassword(password);
		OperaResult result = accountService.loginJudge(info);
		if(result.getResult()){
//			identity differs
			session.put("userid", result.getAccount().getAccountName());
			session.put("identity", result.getAccount().getIdentityId());
			ajaxinfo = request.getContextPath();
			switch(result.getStatus()){
			case 0:
				ajaxinfo+="";
				break;
			case 1:
				ajaxinfo+="/vipinfo";
				break;
			case 2:
				ajaxinfo+="/serverfilmplan";
				break;
			default:
				ajaxinfo+="/manager";
				break;
			}
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String signupJudge(){
		ajaxinfo = "";
		AccountSignUp info = new AccountSignUp();
		info.setBirthday(request.getParameter("birthday"));
		info.setEmail(request.getParameter("email"));
		info.setLocation(Integer.parseInt(request.getParameter("location")));
		info.setName(request.getParameter("name"));
		info.setPassword(request.getParameter("password"));
		info.setPasswordRepeat(request.getParameter("password-repeat"));
		info.setSex(request.getParameter("sex"));
		OperaResult result = accountService.signupJudge(info);
		if(result.getResult()){
			ajaxinfo = "success";
			ajaxinfo+="#";
			ajaxinfo+=result.getComment();
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String logout(){
		session.remove("userid");
		session.remove("identity");
		return WELCOME;
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}

	public List<Location> getLocationlist() {
		return locationlist;
	}

	public void setLocationlist(List<Location> locationlist) {
		this.locationlist = locationlist;
	}
}
