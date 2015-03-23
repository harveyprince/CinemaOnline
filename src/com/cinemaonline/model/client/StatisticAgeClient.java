package com.cinemaonline.model.client;

import java.util.List;

import com.cinemaonline.model.StatisticAge;

public class StatisticAgeClient {

	private int age_0_10;
	private int age_10_20;
	private int age_20_30;
	private int age_30_40;
	private int age_40_50;
	private int age_50_60;
	private int age_sum;
	private int year;
	private int month;
	public static StatisticAgeClient parseSAC(List<StatisticAge> info){
		StatisticAgeClient info_return = new StatisticAgeClient();
		for(StatisticAge temp:info){
			switch(temp.getAge_block()){
			case "0_10":
				info_return.setAge_0_10(temp.getPersonsum());
				break;
			case "10_20":
				info_return.setAge_10_20(temp.getPersonsum());
				break;
			case "20_30":
				info_return.setAge_20_30(temp.getPersonsum());
				break;
			case "30_40":
				info_return.setAge_30_40(temp.getPersonsum());
				break;
			case "40_50":
				info_return.setAge_40_50(temp.getPersonsum());
				break;
			case "50_60":
				info_return.setAge_50_60(temp.getPersonsum());
				break;
			}
		}
		info_return.suminit();
		return info_return;
	}
	public StatisticAge get_0_10_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("0_10");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_0_10);
		return info;
	}
	public StatisticAge get_10_20_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("10_20");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_10_20);
		return info;
	}
	public StatisticAge get_20_30_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("20_30");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_20_30);
		return info;
	}
	public StatisticAge get_30_40_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("30_40");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_30_40);
		return info;
	}
	public StatisticAge get_40_50_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("40_50");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_40_50);
		return info;
	}
	public StatisticAge get_50_60_model(){
		StatisticAge info = new StatisticAge();
		info.setAge_block("50_60");
		info.setYear(year);
		info.setMonth(month);
		info.setPersonsum(age_50_60);
		return info;
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
	public void suminit(){
		setAge_sum(age_0_10+age_10_20+age_20_30+age_30_40+age_40_50+age_50_60);
	}
	public int getAge_0_10() {
		return age_0_10;
	}
	public void setAge_0_10(int age_0_10) {
		this.age_0_10 = age_0_10;
	}
	public int getAge_10_20() {
		return age_10_20;
	}
	public void setAge_10_20(int age_10_20) {
		this.age_10_20 = age_10_20;
	}
	public int getAge_20_30() {
		return age_20_30;
	}
	public void setAge_20_30(int age_20_30) {
		this.age_20_30 = age_20_30;
	}
	public int getAge_30_40() {
		return age_30_40;
	}
	public void setAge_30_40(int age_30_40) {
		this.age_30_40 = age_30_40;
	}
	public int getAge_40_50() {
		return age_40_50;
	}
	public void setAge_40_50(int age_40_50) {
		this.age_40_50 = age_40_50;
	}
	public int getAge_50_60() {
		return age_50_60;
	}
	public void setAge_50_60(int age_50_60) {
		this.age_50_60 = age_50_60;
	}
	public int getAge_sum() {
		return age_sum;
	}
	public void setAge_sum(int age_sum) {
		this.age_sum = age_sum;
	}
	
}
