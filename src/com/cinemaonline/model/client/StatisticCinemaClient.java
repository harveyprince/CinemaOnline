package com.cinemaonline.model.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cinemaonline.model.FilmType;


public class StatisticCinemaClient {

	private List<StatisticHallAttendence> hallAttendencelist;
	private List<StatisticFilmAttendence> filmAttendencelist;
	private List<StatisticTypeAttendence> typeAttendencelist;

	public List<StatisticHallAttendence> getHallAttendencelist() {
		return hallAttendencelist;
	}
	public void setHallAttendencelist(
			List<StatisticHallAttendence> hallAttendencelist) {
		this.hallAttendencelist = hallAttendencelist;
	}
	public List<StatisticFilmAttendence> getFilmAttendencelist() {
		return filmAttendencelist;
	}
	public void setFilmAttendencelist(
			List<StatisticFilmAttendence> filmAttendencelist) {
		this.filmAttendencelist = filmAttendencelist;
	}
	public List<StatisticTypeAttendence> getTypeAttendencelist() {
		return typeAttendencelist;
	}
	public void setTypeAttendencelist(List<StatisticTypeAttendence> typeAttendencelist) {
		this.typeAttendencelist = typeAttendencelist;
	}
	
	public void combineTypeAttendence(){
		Map<Integer,Double> map = new HashMap<Integer,Double>();
		List<FilmType> list = new ArrayList<FilmType>();
		List<StatisticTypeAttendence> alist = new ArrayList<StatisticTypeAttendence>();
		for(StatisticTypeAttendence temp:typeAttendencelist){
			if(map.containsKey(temp.getFilmType().getTypeId())){
				double oldvalue = map.get(temp.getFilmType().getTypeId());
				map.put(temp.getFilmType().getTypeId(), (double)(oldvalue+temp.getAttendence())/2);
			}else{
				list.add(temp.getFilmType());
				map.put(temp.getFilmType().getTypeId(), temp.getAttendence());
			}
		}
		for(FilmType temp:list){
			StatisticTypeAttendence sta = new StatisticTypeAttendence();
			sta.setFilmType(temp);
			sta.setAttendence(map.get(temp.getTypeId()));
			alist.add(sta);
		}
		typeAttendencelist = alist;
	}
}
