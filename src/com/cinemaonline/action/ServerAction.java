package com.cinemaonline.action;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.service.FilmService;

@Repository
public class ServerAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	
	private String ajaxinfo;
	private List<FilmPlanInfo> filmplanlist;
	private List<Film> filmlist;
	private List<Hall> halllist;
	
	public String viewPlan(){
		filmplanlist = filmService.getAllUnoldPlans();
		filmlist = filmService.getAllReleasingFilms();
		halllist = filmService.getAllHalls();
		return SUCCESS;
	}
	
	public String updatePlan(){
		HttpServletRequest request = ServletActionContext.getRequest();
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
		return SUCCESS;
	}
	
	public String insertPlan(){
		HttpServletRequest request = ServletActionContext.getRequest();
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
		return SUCCESS;
	}
//	//////////////////////////////////////////////////////////////////////////////////////////////
	public List<FilmPlanInfo> getFilmplanlist() {
		return filmplanlist;
	}

	public void setFilmplanlist(List<FilmPlanInfo> filmplanlist) {
		this.filmplanlist = filmplanlist;
	}
	public List<Film> getFilmlist() {
		return filmlist;
	}
	public void setFilmlist(List<Film> filmlist) {
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


}
