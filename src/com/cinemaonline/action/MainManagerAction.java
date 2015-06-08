package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.ProfitYear;
import com.cinemaonline.service.FilmService;


@Repository
public class MainManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FilmService filmService;
	
	private String ajaxinfo;
	
	private List<FilmInfo> filmlist;
	private List<FilmInfo> oldfilmlist;
	private List<FilmInfo> releasefilmlist;
	private int page;
	
	private List<ProfitYear> yearprofitlist;
	/*
	 * profit
	 * */
	public String viewProfit(){
		return SUCCESS;
	}
	public String ajax_profit_year(){
		return SUCCESS;
	}
	public String ajax_profit_month(){
		return SUCCESS;
	}
	/*
	 * film
	 * */
	public String ajax_film(){
		filmlist = filmService.getAllFilmsByPage(page);
		if(filmlist==null||page<0){
			setAjaxinfo("empty");
			return AJAXINFO;
		}
		return SUCCESS;
	}
	
	public String ajax_old_film(){
		oldfilmlist = filmService.getAllOldFilmsByPage(page);
		if(oldfilmlist==null||page<0){
			setAjaxinfo("empty");
			return AJAXINFO;
		}
		return SUCCESS;
	}
	
	public String ajax_release_film(){
		releasefilmlist = filmService.getAllReleaseFilmsByPage(page);
		if(releasefilmlist==null||page<0){
			setAjaxinfo("empty");
			return AJAXINFO;
		}
		return SUCCESS;
	}
	
	public String viewFilm(){
		return SUCCESS;
	}
	
	public String insertFilm(){
		FilmInfo info = new FilmInfo();
		info.setDuration(request.getParameter("duration"));
		info.setTypeId(Integer.parseInt(request.getParameter("kindId")));
		info.setName(request.getParameter("name"));
		info.setCost(Integer.parseInt(request.getParameter("cost")));
		OperaResult result = filmService.addFilm(info);
		if(result.getResult()){
			setAjaxinfo("success");
		}else{
			setAjaxinfo(result.getComment());
		}
		return AJAXINFO;
	}
	
	public String updateFilm(){
		FilmInfo info = new FilmInfo();
		info.setFilmId(request.getParameter("filmid"));
		info.setDuration(request.getParameter("duration"));
		info.setTypeId(Integer.parseInt(request.getParameter("kindId")));
		info.setName(request.getParameter("name"));
		info.setCost(Integer.parseInt(request.getParameter("cost")));
		OperaResult result  = filmService.updateFilm(info);
		if(result.getResult()){
			setAjaxinfo("success");
		}else{
			setAjaxinfo(result.getComment());
		}
		return AJAXINFO;
	}
	
	public String releaseFilm(){
		OperaResult result = filmService.releaseFilm(request.getParameter("filmid"));
		if(result.getResult()){
			setAjaxinfo("success");
		}else{
			setAjaxinfo(result.getComment());
		}
		return AJAXINFO;
	}
	
	public String unreleaseFilm(){
		OperaResult result = filmService.unreleaseFilm(request.getParameter("filmid"));
		if(result.getResult()){
			setAjaxinfo("success");
		}else{
			setAjaxinfo(result.getComment());
		}
		return AJAXINFO;
	}

	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<FilmInfo> getOldfilmlist() {
		return oldfilmlist;
	}

	public void setOldfilmlist(List<FilmInfo> oldfilmlist) {
		this.oldfilmlist = oldfilmlist;
	}
	public List<FilmInfo> getFilmlist() {
		return filmlist;
	}
	public void setFilmlist(List<FilmInfo> filmlist) {
		this.filmlist = filmlist;
	}

	public List<FilmInfo> getReleasefilmlist() {
		return releasefilmlist;
	}

	public void setReleasefilmlist(List<FilmInfo> releasefilmlist) {
		this.releasefilmlist = releasefilmlist;
	}
	public List<ProfitYear> getYearprofitlist() {
		return yearprofitlist;
	}
	public void setYearprofitlist(List<ProfitYear> yearprofitlist) {
		this.yearprofitlist = yearprofitlist;
	}
}

