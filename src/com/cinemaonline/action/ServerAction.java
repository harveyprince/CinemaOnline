package com.cinemaonline.action;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Ticket;
import com.cinemaonline.model.client.ActivityInfo;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.TicketOrder;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.service.ActivityService;
import com.cinemaonline.service.FilmService;
import com.cinemaonline.service.TicketService;
import com.cinemaonline.service.VipService;

@Repository
public class ServerAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private VipService vipService;
	
	private String ajaxinfo;
	private List<FilmPlanInfo> filmplanlist;
	private List<FilmInfo> filmlist;
	private List<Hall> halllist;
	private List<Activity> activitylist;
	private List<VipRecordInfo> viprecordlist;
	private VipClientInfo vipclientinfo;
	private VipCardInfo vipcardinfo;

//	///////////////////////////////////////////////////////////
	/*get from client*/
	private ActivityInfo hv_activity;
	private TicketOrder ticketOrder;
	//	///////////////////////////////////////////////////////////
	
	/*
	 * vip reader
	 * */
	public String viewVip(){
		String searchkey = request.getParameter("searchkey");
		if(searchkey==null){
			viprecordlist=null;
			vipclientinfo=null;
			vipcardinfo=null;
		}else{
			viprecordlist = vipService.getRecords(searchkey);
			vipclientinfo = vipService.getVipInfoForClient(searchkey);
			if(vipclientinfo.getStatus()!=0){
				vipcardinfo = vipService.getVipCardInfoForClient(searchkey);
			}else{
				vipcardinfo = null;
			}
		}
		return SUCCESS;
	}
	
	/*
	 * ticket
	 * */
	public String viewTicketSale(){
		filmplanlist = filmService.getAllPassedPlans();
		filmlist = filmService.getAllReleasingFilms();
		halllist = filmService.getAllHalls();
		return SUCCESS;
	}
	
	public String ticketJudge(){
		OperaResult result = ticketService.judgeTicket(ticketOrder);
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
	 * activity
	 * */
	public String viewActivity(){
		filmplanlist = filmService.getAllPassedPlans();
		activitylist = activityService.getAllUnpassedActivities();
		return SUCCESS;
	}
	
	public String insertActivity(){
		OperaResult result = activityService.insertActivity(hv_activity);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String updateActivity(){
		OperaResult result = activityService.updateActivity(hv_activity);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String publishActivity(){
		OperaResult result = activityService.pulishActivity(Long.parseLong(request.getParameter("activityid")));
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	/*
	 * film
	 * */
	public String viewFilm(){
		filmlist = filmService.getAllFilms();
		return SUCCESS;
	}
	
	public String insertFilm(){
		FilmInfo info = new FilmInfo();
		info.setDuration(request.getParameter("duration"));
		info.setKind(request.getParameter("kind"));
		info.setName(request.getParameter("name"));
		OperaResult result = filmService.addFilm(info);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String updateFilm(){
		FilmInfo info = new FilmInfo();
		info.setFilmId(request.getParameter("filmid"));
		info.setDuration(request.getParameter("duration"));
		info.setKind(request.getParameter("kind"));
		info.setName(request.getParameter("name"));
		OperaResult result  = filmService.updateFilm(info);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String releaseFilm(){
		OperaResult result = filmService.releaseFilm(request.getParameter("filmid"));
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String unreleaseFilm(){
		OperaResult result = filmService.unreleaseFilm(request.getParameter("filmid"));
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	/*
	 * plan
	 * */
	public String viewPlan(){
		filmplanlist = filmService.getAllUnoldPlans();
		filmlist = filmService.getAllReleasingFilms();
		halllist = filmService.getAllHalls();
		return SUCCESS;
	}
	
	public String updatePlan(){
		FilmPlanInfo info = new FilmPlanInfo();
		try {
			info.setBeginTime(request.getParameter("beginTime"));
			info.setEndTime(request.getParameter("endTime"));
			info.setFilmid(request.getParameter("filmid"));
			info.setHallNo(request.getParameter("hallNo"));
			info.setPrice(request.getParameter("price"));
			info.setSeatSum(request.getParameter("seatSum"));
			info.setPlanid(request.getParameter("planid"));
			OperaResult result = filmService.updatePlan(info);
			if(result.getResult()){
				ajaxinfo = "success";
			}else{
				ajaxinfo = "failed";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			ajaxinfo = e.getLocalizedMessage();
		}
		return AJAXINFO;
	}
	
	public String insertPlan(){
		FilmPlanInfo info = new FilmPlanInfo();
		try {
			info.setBeginTime(request.getParameter("beginTime"));
			info.setEndTime(request.getParameter("endTime"));
			info.setFilmid(request.getParameter("filmid"));
			info.setHallNo(request.getParameter("hallNo"));
			info.setPrice(request.getParameter("price"));
			info.setSeatSum(request.getParameter("seatSum"));
			OperaResult result = filmService.addPlan(info);
			if(result.getResult()){
				ajaxinfo = "success";
			}else{
				ajaxinfo = "failed";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			ajaxinfo = e.getLocalizedMessage();
		}
		return AJAXINFO;
	}
	
	public String submitPlan(){
		OperaResult result = filmService.submitPlanForCheck(request.getParameter("planid"));
		if(result.getResult()){
			ajaxinfo =  "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
//	//////////////////////////////////////////////////////////////////////////////////////////////
	public List<FilmPlanInfo> getFilmplanlist() {
		return filmplanlist;
	}

	public void setFilmplanlist(List<FilmPlanInfo> filmplanlist) {
		this.filmplanlist = filmplanlist;
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

	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}

	public List<Activity> getActivitylist() {
		return activitylist;
	}

	public void setActivitylist(List<Activity> activitylist) {
		this.activitylist = activitylist;
	}

	public ActivityInfo getHv_activity() {
		return hv_activity;
	}

	public void setHv_activity(ActivityInfo hv_activity) {
		this.hv_activity = hv_activity;
	}

	public TicketOrder getTicketOrder() {
		return ticketOrder;
	}

	public void setTicketOrder(TicketOrder ticketOrder) {
		this.ticketOrder = ticketOrder;
	}

	public List<VipRecordInfo> getViprecordlist() {
		return viprecordlist;
	}

	public void setViprecordlist(List<VipRecordInfo> viprecordlist) {
		this.viprecordlist = viprecordlist;
	}

	public VipClientInfo getVipclientinfo() {
		return vipclientinfo;
	}

	public void setVipclientinfo(VipClientInfo vipclientinfo) {
		this.vipclientinfo = vipclientinfo;
	}

	public VipCardInfo getVipcardinfo() {
		return vipcardinfo;
	}

	public void setVipcardinfo(VipCardInfo vipcardinfo) {
		this.vipcardinfo = vipcardinfo;
	}

}
