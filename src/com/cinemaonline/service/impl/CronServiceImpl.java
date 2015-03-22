package com.cinemaonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.service.CronService;
import com.cinemaonline.service.VipService;

@Service
public class CronServiceImpl implements CronService {

	@Autowired
	private VipDao vipDao;
	@Autowired
	private VipService vipService;
	@Override
	public void vipLevelCostJudge() {
		// TODO Auto-generated method stub
//		以年为周期，采用365天计数
//		获取超过365天未缴费的会员，并分析状态[不获取4停止\5取消]
		List<VipInfo> viplist = vipDao.getVipForLevelPay();
		for(VipInfo vip:viplist){
			vipService.cardLevelCost(vip.getVipId());
		}
	}



}
