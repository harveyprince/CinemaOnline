package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.ProfitPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.FilmProfitFromClient;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.service.FilmService;
import com.cinemaonline.service.ProfitService;

@Repository
public class ManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	@Autowired
	private ProfitService profitService;

	private String ajaxinfo;
	private List<FilmPlanInfo> filmplanlist;
	private List<FilmPlanInfo> checkedfilmplanlist;
	private List<FilmInfo> filmlist;
	private List<Hall> halllist;
	
	private int page;
	
	private List<ProfitPlan> profitPlanlist;
	private List<ProfitPlan> dispatchedProfitPlanlist;
	private List<FilmProfitPlan> profitDispatchlist;
	private List<FilmProfitFromClient> filmProfitPercentlist;
	
	
	//	//////////////////////////////statistic param///////////////////////////////////////////////
	private StatisticCinemaClient cinemaClient;
	/*
	 * profit
	 * */
	public String showProfitPlan(){
		return SUCCESS;
	}
	public String getWorkingProfitPlan(){
		profitPlanlist = profitService.getAllWorkingUndispatchPlans();
		return SUCCESS;
	}
	public String getWorkingDispatchedProfitPlan(){
		dispatchedProfitPlanlist = profitService.getWorkingDispatchedProfitPlan();
		return SUCCESS;
	}
	public String getPlanDispatch(){
		String id = request.getParameter("planId");
		profitDispatchlist = profitService.getProfitDispatchByPlanId(id);
		return SUCCESS;
	}
	public String submitPlanDispatch(){
		OperaResult result = profitService.submitProfitDispatch(filmProfitPercentlist);
		if(result.getResult()){
			ajaxinfo = "success";
			
		}else{
			ajaxinfo = "failed";
		}
		return AJAXINFO;
	}
	public String viewFilmPlan(){
		filmlist = filmService.getAllUnplanedFilms();
		System.out.println("worked");
		halllist = filmService.getAllHalls();
		return SUCCESS;
	}
	/*
	 * statics
	 * */
	public String showStatics(){
		return SUCCESS;
	}
	
	/*
	 * plan check
	 * */
	public String ajax_filmplan(){
		filmplanlist = filmService.getPlansForCheckByPage(page);
		if(filmplanlist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String ajax_old_filmplan(){
		checkedfilmplanlist = filmService.getAllCheckedUnoldPlansByPage(page);
		if(checkedfilmplanlist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String checkPlan(){
		filmlist = filmService.getAllReleasingFilms();
		halllist = filmService.getAllHalls();
		return SUCCESS;
	}
	
	public String passPlan(){
		String planid = request.getParameter("planid");
		OperaResult result = filmService.passPlan(planid);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String unpassPlan(){
		String planid = request.getParameter("planid");
		OperaResult result = filmService.unpassPlan(planid);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}

//	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getAjaxinfo() {
		return ajaxinfo;
	}
	
	
	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}
	
	
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

	public List<FilmPlanInfo> getCheckedfilmplanlist() {
		return checkedfilmplanlist;
	}

	public void setCheckedfilmplanlist(List<FilmPlanInfo> checkedfilmplanlist) {
		this.checkedfilmplanlist = checkedfilmplanlist;
	}

	public StatisticCinemaClient getCinemaClient() {
		return cinemaClient;
	}

	public void setCinemaClient(StatisticCinemaClient cinemaClient) {
		this.cinemaClient = cinemaClient;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public List<ProfitPlan> getProfitPlanlist() {
		return profitPlanlist;
	}
	public void setProfitPlanlist(List<ProfitPlan> profitPlanlist) {
		this.profitPlanlist = profitPlanlist;
	}
	public List<FilmProfitPlan> getProfitDispatchlist() {
		return profitDispatchlist;
	}
	public void setProfitDispatchlist(List<FilmProfitPlan> profitDispatchlist) {
		this.profitDispatchlist = profitDispatchlist;
	}
	public List<FilmProfitFromClient> getFilmProfitPercentlist() {
		return filmProfitPercentlist;
	}
	public void setFilmProfitPercentlist(List<FilmProfitFromClient> filmProfitPercentlist) {
		this.filmProfitPercentlist = filmProfitPercentlist;
	}
	public List<ProfitPlan> getDispatchedProfitPlanlist() {
		return dispatchedProfitPlanlist;
	}
	public void setDispatchedProfitPlanlist(List<ProfitPlan> dispatchedProfitPlanlist) {
		this.dispatchedProfitPlanlist = dispatchedProfitPlanlist;
	}
}

