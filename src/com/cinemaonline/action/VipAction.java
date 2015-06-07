package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.Ticket;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.BankService;
import com.cinemaonline.service.FilmService;
import com.cinemaonline.service.InfoService;
import com.cinemaonline.service.TicketService;
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
	@Autowired
	private InfoService infoService;
	@Autowired
	private FilmService filmService;
	@Autowired
	private TicketService ticketService;
	
	private String ajaxinfo;
	private VipClientInfo vipinfo;
	private VipCardInfo cardinfo;
	private List<VipLevel> lvslist;
	private List<VipRecordInfo> recordlist;
	private List<Location> locationlist;
	private int page;
	private List<FilmPlanInfo> filmplanlist;
	

	private List<FilmInfo> filmlist;
	private List<Hall> halllist;
	
	private TicketOrder ticketOrder;
	
	

	/*
	 * ticket
	 * */
	public String ajax_ticket(){
		filmplanlist = filmService.getAllPassedPlansNotOldByPage(page);
		if(filmplanlist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	
	public String viewTicketSale(){
		setFilmlist(filmService.getAllReleasingFilms());
		setHalllist(filmService.getAllHalls());
		return SUCCESS;
	}
	
	public String ticketJudge(){
		String userid = (String)session.get("userid");
		AccountLogin vip_account = new AccountLogin();
		vip_account.setAccountName(userid);
		ticketOrder.setVip_account(vip_account);
		ticketOrder.setIdentity(1);
		OperaResult result = ticketService.judgeTicketForVip(ticketOrder);
		if(result.getResult()){
			session.put("ticketorder", result.getTicketOrder());
			ajaxinfo = "success"+"#"+result.getTicketOrder().getCost();
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String ticketPay(){
		try{
			TicketOrder order = (TicketOrder) session.get("ticketorder");
			if(order==null){
				ajaxinfo="failed";
				return AJAXINFO;
			}
			order.setPayway(ticketOrder.getPayway());
			order.setBank_account(ticketOrder.getBank_account());
			OperaResult result = ticketService.payTheBill(order);
			if(result.getResult()){
				session.remove("ticketorder");
				ajaxinfo = "success"+"#";
				for(Ticket tick:result.getTicketRecord().getTickets()){
					ajaxinfo += tick.getSeatNumber();
					ajaxinfo += "&";
				}
			}else{
				ajaxinfo = result.getComment();
			}
		}catch(Exception e){
			ajaxinfo="failed";
			e.printStackTrace();
		}
		return AJAXINFO;
	}
	/*
	 * info
	 * */
	public String viewInfo(){
		String userid = (String) session.get("userid");
		 vipinfo = vipService.getVipInfoForClient(userid);
		 locationlist = infoService.getAllLocation();
		return SUCCESS;
	}
	
	public String updateInfo(){
		String userid = (String) session.get("userid");
		VipUpdate info = new VipUpdate();
		info.setBirthday(request.getParameter("birthday"));
		info.setLocation(Integer.parseInt(request.getParameter("location")));
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
	
	public String disactivateCard(){
		String confirm = request.getParameter("confirm");
		String userid = (String) session.get("userid");
		if(confirm.equals("1")){
			OperaResult result = vipService.disactivateCardById(userid);
			if(result.getResult()){
				ajaxinfo = "success";
			}else{
				ajaxinfo = result.getComment();
			}
		}else{
			ajaxinfo = "request error";
		}
		return AJAXINFO;
	}
	
	public String translateScore(){
		String score = request.getParameter("score");
		String userid = (String) session.get("userid");
		OperaResult result = vipService.scoreToBalance(userid, Integer.parseInt(score));
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
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
	public String ajax_record(){
		String userid = (String) session.get("userid");
		setRecordlist(vipService.getRecordsByPage(userid,page));
		if(recordlist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String viewRecord(){
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

	public List<Location> getLocationlist() {
		return locationlist;
	}

	public void setLocationlist(List<Location> locationlist) {
		this.locationlist = locationlist;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public List<FilmInfo> getFilmlist() {
		return filmlist;
	}

	public void setFilmlist(List<FilmInfo> filmlist) {
		this.filmlist = filmlist;
	}

	public List<Hall> getHalllist() {
		return halllist;
	}

	public void setHalllist(List<Hall> halllist) {
		this.halllist = halllist;
	}
	
	public TicketOrder getTicketOrder() {
		return ticketOrder;
	}

	public void setTicketOrder(TicketOrder ticketOrder) {
		this.ticketOrder = ticketOrder;
	}
	
	public List<FilmPlanInfo> getFilmplanlist() {
		return filmplanlist;
	}

	public void setFilmplanlist(List<FilmPlanInfo> filmplanlist) {
		this.filmplanlist = filmplanlist;
	}


}
