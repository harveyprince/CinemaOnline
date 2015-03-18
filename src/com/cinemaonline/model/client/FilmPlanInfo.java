package com.cinemaonline.model.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cinemaonline.model.Film;
import com.cinemaonline.model.FilmPlan;
import com.cinemaonline.model.Hall;

public class FilmPlanInfo {

	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat dft=new SimpleDateFormat("HH:mm");
	private long planid;
	private Hall hall;
	private int hallNo;
	private int seatSum;
	private long beginTime;
	private long endTime;
	private Date beginTimeDate;
	private Date endTimeDate;
	private String beginTtime;
	private String endTtime;
	private String begindft;
	private String enddft;
	private double price;
	private int status = 0;
	private String strstatus;
	private Film film;
	private String filmName;
	private long filmid;
	public FilmPlan getFilmPlan(){
		FilmPlan info = new FilmPlan();
		info.setBeginTime(beginTime);
		info.setEndTime(endTime);
		info.setFilm(film);
		info.setHall(hall);
		info.setPrice(price);
		info.setSeatSum(seatSum);
		info.setStatus(status);
		return info;
	}
	public void setFilmPlan(FilmPlan info){
		if(info==null){
			return;
		}
		setBeginTime(info.getBeginTime());
		setEndTime(info.getEndTime());
		setFilm(info.getFilm());
		setHall(info.getHall());
		setSeatSum(info.getSeatSum());
		setPlanid(info.getPlanId());
		setPrice(info.getPrice());
		setStatus(info.getStatus());
	}
	public static List<FilmPlanInfo> parseFPI(List<FilmPlan> list){
		if(list==null){
			return null;
		}
		List<FilmPlanInfo> info = new ArrayList<FilmPlanInfo>();
		for(FilmPlan plan:list){
			FilmPlanInfo fpi = new FilmPlanInfo();
			fpi.setFilmPlan(plan);
			info.add(fpi);
		}
		return info;
	}
	public long getPlanid() {
		return planid;
	}
	public void setPlanid(long planid) {
		this.planid = planid;
	}
	public void setPlanid(String planid) {
		setPlanid(Long.parseLong(planid));
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
		setHallNo(hall.getHallNo());
	}
	public int getSeatSum() {
		return seatSum;
	}
	public void setSeatSum(int seatSum) {
		this.seatSum = seatSum;
	}
	public void setSeatSum(String seatSum) {
		setSeatSum(Integer.parseInt(seatSum));
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) throws ParseException{
		Date temp = df.parse(beginTime.replace("T", " "));
		setBeginTime(temp.getTime());
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
		setBeginTimeDate(new Date(beginTime));
		setBeginTtime(df.format(beginTimeDate));
		setBegindft(dft.format(beginTimeDate));
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) throws ParseException{
		Date temp = df.parse(endTime.replace("T", " "));
		setEndTime(temp.getTime());
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
		setEndTimeDate(new Date(endTime));
		setEndTtime(df.format(endTimeDate));
		setEnddft(dft.format(endTimeDate));
	}
	public Date getBeginTimeDate() {
		return beginTimeDate;
	}
	public void setBeginTimeDate(Date beginTimeDate) {
		this.beginTimeDate = beginTimeDate;
	}
	public Date getEndTimeDate() {
		return endTimeDate;
	}
	public void setEndTimeDate(Date endTimeDate) {
		this.endTimeDate = endTimeDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPrice(String price) {
		setPrice(Double.parseDouble(price));
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
		switch(status){
		case 0:
			setStrstatus("unsubmited");
			break;
		case 1:
			setStrstatus("waiting for check");
			break;
		case 2:
			setStrstatus("checked pass");
			break;
		case 3:
			setStrstatus("checked failed");
			break;
		default:
			break;
		}
	}
	public String getStrstatus() {
		return strstatus;
	}
	public void setStrstatus(String strstatus) {
		this.strstatus = strstatus;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
		setFilmName(film.getName());
		setFilmid(film.getFilmId());
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public long getFilmid() {
		return filmid;
	}
	public void setFilmid(long filmid) {
		this.filmid = filmid;
	}
	public void setFilmid(String filmid) {
		setFilmid(Long.parseLong(filmid));
	}
	public String getBeginTtime() {
		return beginTtime;
	}
	public void setBeginTtime(String beginTtime) {
		if(beginTtime.indexOf("T")<0){
			this.beginTtime = beginTtime.replace(" ", "T");
		}else{
			this.beginTtime = beginTtime;
		}
	}
	public String getEndTtime() {
		return endTtime;
	}
	public void setEndTtime(String endTtime) {
		if(endTtime.indexOf("T")<0){
			this.endTtime = endTtime.replace(" ", "T");
		}else{
			this.endTtime = endTtime;
		}
	}
	public String getBegindft() {
		return begindft;
	}
	public void setBegindft(String begindft) {
		this.begindft = begindft;
	}
	public String getEnddft() {
		return enddft;
	}
	public void setEnddft(String enddft) {
		this.enddft = enddft;
	}
	public int getHallNo() {
		return hallNo;
	}
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}
	public void setHallNo(String hallNo) {
		setHallNo(Integer.parseInt(hallNo));
	}
}
