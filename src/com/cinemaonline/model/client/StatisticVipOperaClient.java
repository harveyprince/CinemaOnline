package com.cinemaonline.model.client;

import java.util.List;

import com.cinemaonline.model.StatisticCardStatus;
import com.cinemaonline.model.StatisticVipOpera;

public class StatisticVipOperaClient {
	
	private double consume_sum;
	private int status_1_sum;
	private int status_2_sum;
	private int status_4_sum;
	private int status_5_sum;
	private int year;
	private int month;
	public static StatisticVipOperaClient parseSVO(List<StatisticCardStatus> cardlist,StatisticVipOpera vo){
		if(cardlist==null||vo==null){
			return null;
		}
		StatisticVipOperaClient info_return = new StatisticVipOperaClient();
		for(StatisticCardStatus temp:cardlist){
			switch(temp.getStatus()){
			case 1:
				info_return.setStatus_1_sum(temp.getPersonsum());
				break;
			case 2:
				info_return.setStatus_2_sum(temp.getPersonsum());
				break;
			case 4:
				info_return.setStatus_4_sum(temp.getPersonsum());
				break;
			case 5:
				info_return.setStatus_5_sum(temp.getPersonsum());
				break;
			}
		}
		info_return.setConsume_sum(vo.getConsumesum());
		return info_return;
	}
	public StatisticVipOpera getVipOpera_model(){
		StatisticVipOpera info = new StatisticVipOpera();
		info.setMonth(month);
		info.setYear(year);
		info.setConsumesum(consume_sum);
		return info;
	}
	public StatisticCardStatus getStatus_1_model(){
		StatisticCardStatus info = new StatisticCardStatus();
		info.setMonth(month);
		info.setYear(year);
		info.setPersonsum(status_1_sum);
		info.setStatus(1);
		return info;
	}
	public StatisticCardStatus getStatus_2_model(){
		StatisticCardStatus info = new StatisticCardStatus();
		info.setMonth(month);
		info.setYear(year);
		info.setPersonsum(status_2_sum);
		info.setStatus(2);
		return info;
	}
	public StatisticCardStatus getStatus_4_model(){
		StatisticCardStatus info = new StatisticCardStatus();
		info.setMonth(month);
		info.setYear(year);
		info.setPersonsum(status_4_sum);
		info.setStatus(4);
		return info;
	}
	public StatisticCardStatus getStatus_5_model(){
		StatisticCardStatus info = new StatisticCardStatus();
		info.setMonth(month);
		info.setYear(year);
		info.setPersonsum(status_5_sum);
		info.setStatus(5);
		return info;
	}
	public double getConsume_sum() {
		return consume_sum;
	}
	public void setConsume_sum(double consume_sum) {
		this.consume_sum = consume_sum;
	}
	public int getStatus_1_sum() {
		return status_1_sum;
	}
	public void setStatus_1_sum(int status_1_sum) {
		this.status_1_sum = status_1_sum;
	}
	public int getStatus_2_sum() {
		return status_2_sum;
	}
	public void setStatus_2_sum(int status_2_sum) {
		this.status_2_sum = status_2_sum;
	}
	public int getStatus_4_sum() {
		return status_4_sum;
	}
	public void setStatus_4_sum(int status_4_sum) {
		this.status_4_sum = status_4_sum;
	}
	public int getStatus_5_sum() {
		return status_5_sum;
	}
	public void setStatus_5_sum(int status_5_sum) {
		this.status_5_sum = status_5_sum;
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
