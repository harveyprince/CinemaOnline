package com.cinemaonline.model.client;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cinemaonline.model.Film;

public class FilmInfo {
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	private long filmId;
	private String name;
	private int duration;
	private String kind;
	private Date releaseTime = null;
	private Date shelvesTime = null;
	private String rtTime;
	private String stTime;
	private int status = 0;
	public Film getFilm(){
		Film film = new Film();
		film.setDuration(duration);
		film.setKind(kind);
		film.setName(name);
		film.setStatus(status);
		film.setReleaseTime(releaseTime);
		film.setShelvesTime(shelvesTime);
		return film;
	}
	public void setFilm(Film info){
		if(info==null){
			return;
		}
		setDuration(info.getDuration());
		setFilmId(info.getFilmId());
		setKind(info.getKind());
		setName(info.getName());
		setReleaseTime(info.getReleaseTime());
		setShelvesTime(info.getShelvesTime());
		setStatus(info.getStatus());
	}
	public static List<FilmInfo> parseFI(List<Film> list){
		if(list==null){
			return null;
		}
		List<FilmInfo> info = new ArrayList<FilmInfo>();
		for(Film film:list){
			FilmInfo temp = new FilmInfo();
			temp.setFilm(film);
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
}
