package com.cinemaonline.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.AccountService;
@Repository
public class AccountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AccountService accountService;
	
	private String ajaxinfo;
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String welcome(){
		return SUCCESS;
	}
	
	public String loginJudge(){
		ajaxinfo="";
		HttpServletRequest request = ServletActionContext.getRequest();
		String accountname = request.getParameter("accountid");
		String password = request.getParameter("password");
		AccountLogin info = new AccountLogin();
		info.setAccountName(accountname);
		info.setPassword(password);
		OperaResult result = accountService.loginJudge(info);
		if(result.getResult()){
//			identity differs
			 HttpSession session = request.getSession(true);
			 session.setAttribute("userid", result.getAccount().getAccountName());
			ajaxinfo = request.getContextPath();
			switch(result.getStatus()){
			case 0:
				ajaxinfo+="";
				break;
			case 1:
				ajaxinfo+="/vipinfo";
				break;
			case 2:
				ajaxinfo+="/server";
				break;
			default:
				ajaxinfo+="/manager";
				break;
			}
		}else{
			ajaxinfo = result.getComment();
		}
		return SUCCESS;
	}
	
	public String signupJudge(){
		ajaxinfo = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		AccountSignUp info = new AccountSignUp();
		info.setBirthday(request.getParameter("birthday"));
		info.setEmail(request.getParameter("email"));
		info.setLocation(request.getParameter("location"));
		info.setName(request.getParameter("name"));
		info.setPassword(request.getParameter("password"));
		info.setPasswordRepeat(request.getParameter("password-repeat"));
		info.setSex(Integer.parseInt(request.getParameter("sex")));
		OperaResult result = accountService.signupJudge(info);
		if(result.getResult()){
			ajaxinfo = "success";
			ajaxinfo+="#";
			ajaxinfo+=result.getComment();
		}else{
			ajaxinfo = result.getComment();
		}
		return SUCCESS;
	}
//	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}
}
