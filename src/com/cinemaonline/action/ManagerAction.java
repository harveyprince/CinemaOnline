package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.FilmService;

@Repository
public class ManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	

	private String ajaxinfo;
	private List<FilmPlanInfo> filmplanlist;
	private List<FilmPlanInfo> checkedfilmplanlist;
	private List<FilmInfo> filmlist;
	private List<Hall> halllist;
	
	/*
	 * statics
	 * */
	public String showStatics(){
		return SUCCESS;
	}
	
	public String queryStatics(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		return STATICSINFO;
	}
	/*
	 * plan check
	 * */
	public String checkPlan(){
		filmplanlist = filmService.getPlansForCheck();
		checkedfilmplanlist = filmService.getAllCheckedUnoldPlans();
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
}

