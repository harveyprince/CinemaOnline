package com.cinemaonline.model.client;

import java.util.List;

import com.cinemaonline.model.StatisticSex;

public class StatisticSexClient {

	private int boy_num;
	private int girl_num;
	private int year;
	private int month;
	public static StatisticSexClient parseSSC(List<StatisticSex> info){
		StatisticSexClient info_return = new StatisticSexClient();
		for(StatisticSex temp:info){
			switch(temp.getSex()){
			case 0:
				info_return.setGirl_num(temp.getPersonsum());
				break;
			case 1:
				info_return.setBoy_num(temp.getPersonsum());
				break;
			}
		}
		return info_return;
	}
	public StatisticSex getBoy_model(){
		StatisticSex info = new StatisticSex();
		info.setSex(1);
		info.setPersonsum(boy_num);
		info.setMonth(month);
		info.setYear(year);
		return info;
	}
	public StatisticSex getGirl_model(){
		StatisticSex info = new StatisticSex();
		info.setSex(0);
		info.setPersonsum(girl_num);
		info.setMonth(month);
		info.setYear(year);
		return info;
	}
	public int getBoy_num() {
		return boy_num;
	}
	public void setBoy_num(int boy_num) {
		this.boy_num = boy_num;
	}
	public int getGirl_num() {
		return girl_num;
	}
	public void setGirl_num(int girl_num) {
		this.girl_num = girl_num;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
