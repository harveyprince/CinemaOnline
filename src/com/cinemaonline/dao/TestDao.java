package com.cinemaonline.dao;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.Test;

public interface TestDao {
	public Test find(String key);
	
	public void setAct(Activity act);

}
