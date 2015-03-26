package com.cinemaonline.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.service.CronService;
import com.cinemaonline.service.VipService;

@Service
public class CronServiceImpl implements CronService {

	@Autowired
	private VipService vipService;
	
	@Override
	public void vipLevelCostJudge() {
		// TODO Auto-generated method stub
		vipService.vipLevelCostJudge();
	}



}
