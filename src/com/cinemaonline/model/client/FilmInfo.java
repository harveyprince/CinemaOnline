package com.cinemaonline.model.client;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cinemaonline.dao.FilmDao;
import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.FilmReleasePlan;
import com.cinemaonline.model.FilmType;
import com.cinemaonline.model.ProfitPlan;

public class FilmInfo {
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	private long filmId;
	private String name;
	private int duration;
	private int typeId;
	private FilmType kind = null;
	private Date releaseTime = null;
	private Date shelvesTime = null;
	private String rtTime;
	private String stTime;
	private int status = 0;
	private int cost = 0;
	private FilmProfitPlan filmProfitPlan;
	private List<FilmReleasePlan> filmReleasePlanlist;
	public Film getFilm(){
		Film film = new Film();
		film.setDuration(duration);
		film.setFilmType(kind);
		film.setName(name);
		film.setStatus(status);
		film.setReleaseTime(releaseTime);
		film.setShelvesTime(shelvesTime);
		film.setCost(cost);
		return film;
	}
	public void setFilm(Film info,List<FilmReleasePlan> list){
		if(info==null){
			return;
		}
		setDuration(info.getDuration());
		setFilmId(info.getFilmId());
		setKind(info.getFilmType());
		setName(info.getName());
		setReleaseTime(info.getReleaseTime());
		setShelvesTime(info.getShelvesTime());
		setStatus(info.getStatus());
		setCost(info.getCost());
		setFilmProfitPlan(info.getFilmProfitPlan());
		setFilmReleasePlanlist(list);
	}
	public static List<FilmInfo> parseFI(List<Film> list,FilmDao filmDao){
		if(list==null){
			return null;
		}
		List<FilmInfo> info = new ArrayList<FilmInfo>();
		for(Film film:list){
			FilmInfo temp = new FilmInfo();
			temp.setFilm(film,filmDao.getFilmReleasePlanListByFilmId(film.getFilmId()));
			info.add(temp);
		}
		return info;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public void setFilmId(String filmId) {
		setFilmId(Long.parseLong(filmId));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setDuration(String duration) {
		setDuration(Integer.parseInt(duration));
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		if(releaseTime==null){return;}
		this.releaseTime = releaseTime;
		setRtTime(df.format(releaseTime));
	}
	public Date getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(Date shelvesTime) {
		if(shelvesTime==null){return;}
		this.shelvesTime = shelvesTime;
		setStTime(df.format(shelvesTime));
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStTime() {
		return stTime;
	}
	public void setStTime(String stTime) {
		this.stTime = stTime;
	}
	public String getRtTime() {
		return rtTime;
	}
	public void setRtTime(String rtTime) {
		this.rtTime = rtTime;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public FilmType getKind() {
		return kind;
	}
	public void setKind(FilmType kind) {
		this.kind = kind;
	}
	public FilmProfitPlan getFilmProfitPlan() {
		return filmProfitPlan;
	}
	public void setFilmProfitPlan(FilmProfitPlan filmProfitPlan) {
		this.filmProfitPlan = filmProfitPlan;
	}
	public List<FilmReleasePlan> getFilmReleasePlanlist() {
		return filmReleasePlanlist;
	}
	public void setFilmReleasePlanlist(List<FilmReleasePlan> filmReleasePlanlist) {
		this.filmReleasePlanlist = filmReleasePlanlist;
	}
}
