package com.cinemaonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.VipDao;
import com.cinemaonline.service.CronService;

@Service
public class CronServiceImpl implements CronService {

	@Autowired
	private VipDao vipDao;
	@Override
	public void vipLevelCostJudge() {
		// TODO Auto-generated method stub
//		以年为周期，采用365天计数
//		获取超过365天未缴费的会员，并分析状态
	}



}
