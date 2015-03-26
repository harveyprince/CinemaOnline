package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.StatisticLocation;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmPlanInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.StatisticAgeClient;
import com.cinemaonline.model.client.StatisticCinemaClient;
import com.cinemaonline.model.client.StatisticSexClient;
import com.cinemaonline.model.client.StatisticVipOperaClient;
import com.cinemaonline.service.FilmService;
import com.cinemaonline.service.StatisticService;

@Repository
public class ManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	@Autowired
	private StatisticService statisticService;

	private String ajaxinfo;
	private List<FilmPlanInfo> filmplanlist;
	private List<FilmPlanInfo> checkedfilmplanlist;
	private List<FilmInfo> filmlist;
	private List<Hall> halllist;
	
	private int page;
	

	//	//////////////////////////////statistic param///////////////////////////////////////////////
	private StatisticAgeClient ageClient;
	private StatisticSexClient sexClient;
	private List<StatisticLocation> locationlistClient;
	private StatisticVipOperaClient cardClient;
	private StatisticCinemaClient cinemaClient;
	/*
	 * statics
	 * */
	public String showStatics(){
		return SUCCESS;
	}
	
	public String getAgeStatisticJson(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		setAgeClient(statisticService.getAgeStatic(year, month));
		if(ageClient==null){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		return STATISTICAGE;
	}
	
	public String getSexStatisticJson(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		setSexClient(statisticService.getSexStatic(year, month));
		if(sexClient==null){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		return STATISTICSEX;
	}
	
	public String getLocationStatisticJson(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		locationlistClient = statisticService.getLocationStatic(year, month);
		if(locationlistClient==null){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		return STATISTICLOCATION;
	}
	
	public String getCardStatisticJson(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		setCardClient(statisticService.getVipOperaStatic(year, month));
		if(cardClient==null){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		return STATISTICCARD;
	}
	
	public String getCinemaStatisticJson(){
		String stryear = request.getParameter("year");
		String strmonth = request.getParameter("month");
		int year = Integer.parseInt(stryear);
		int month = Integer.parseInt(strmonth);
		setCinemaClient(statisticService.getCinemaStatic(year, month));
		if(cinemaClient==null){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		if(cinemaClient.getCinemapersonsum_month()==0){
			ajaxinfo = "empty";
			return AJAXINFO;
		}
		return STATISTICCINEMA;
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

	public StatisticAgeClient getAgeClient() {
		return ageClient;
	}

	public void setAgeClient(StatisticAgeClient ageClient) {
		this.ageClient = ageClient;
	}

	public StatisticSexClient getSexClient() {
		return sexClient;
	}

	public void setSexClient(StatisticSexClient sexClient) {
		this.sexClient = sexClient;
	}

	public List<StatisticLocation> getLocationlistClient() {
		return locationlistClient;
	}

	public void setLocationlistClient(List<StatisticLocation> locationlistClient) {
		this.locationlistClient = locationlistClient;
	}

	public StatisticVipOperaClient getCardClient() {
		return cardClient;
	}

	public void setCardClient(StatisticVipOperaClient cardClient) {
		this.cardClient = cardClient;
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
}

