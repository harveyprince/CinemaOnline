package com.cinemaonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaonline.dao.AccountDao;
import com.cinemaonline.dao.InfoDao;
import com.cinemaonline.dao.VipDao;
import com.cinemaonline.model.Account;
import com.cinemaonline.model.VipCard;
import com.cinemaonline.model.VipInfo;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.VipRecord;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.RecordService;
import com.cinemaonline.service.VipService;

@Service
public class VipServiceImpl implements VipService {

	@Autowired
	private VipDao vipDao;
	@Autowired
	private RecordService recordService;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private InfoDao infoDao;
	
	private VipServiceImpl(){}

	@Override
	public OperaResult vipinfoUpate(VipUpdate info_update,String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		info = info_update.setBase(info);
		info.setLocation(infoDao.getLocationById(info_update.getLocation()));
		vipDao.update(info);
		result.setResult(true);
		return result;
	}

	@Override
	public VipClientInfo getVipInfoForClient(String userid) {
		// TODO Auto-generated method stub
		VipClientInfo cinfo = new VipClientInfo();
		VipInfo info = vipDao.getVipInfoById(userid);
		if(info==null){return null;}
		cinfo.setByTable(info);
		return cinfo;
	}

	@Override
	public OperaResult cardActivatedCheck(String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		if(info.getVipCard()==null){
			result.setResult(false);
		}else{
			result.setResult(true);
		}
		return result;
	}

	@Override
	public OperaResult cardActivate(VipCardInfo info) {
		// TODO Auto-generated method stub
		VipCardInfo info_local = info;
		OperaResult result = new OperaResult();
		VipInfo info_temp = vipDao.getVipInfoById(info_local.getVipid());
		if(info_temp.getVipCard()!=null){
			result.setResult(false);
			result.setComment("alreadyexists");
		}else{
			info_local.setVipLevel(vipDao.getLevelById(info_local.getViplevel()));
			vipDao.insertCard(info_local.getCardInfo());
			info_temp = vipDao.getVipInfoById(info_local.getVipid());
			info_temp.setVipStatus(1);
			vipDao.update(info_temp);
			result.setResult(true);
			VipOperaInfo opinfo = new VipOperaInfo();
			opinfo.dateInit();
			opinfo.setUserid(info_local.getVipid());
			opinfo.setPurpose("activate card");
			opinfo.setRecharge(info_local.getBalance());
			opinfo.setResult(true);
			recordService.insertVipRecord(opinfo);
		}
		return result;
	}

	@Override
	public OperaResult cardLevelCost(String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo userinfo = vipDao.getVipInfoById(userid);
		VipOperaInfo info = new VipOperaInfo();
		info.setUserid(userid);
		info.setCostNum(userinfo.getVipCard().getVipLevel().getCost());
		info.setPurpose("lvcost");
		result = cardBalanceOpera(info);
		if(result.getResult()){
			if(userinfo.getVipStatus()==2){
				userinfo.setVipStatus(1);
				vipDao.update(userinfo);
			}
			return result;
		}else{
			//lvcost失败，会员状态暂停[如果状态已经为暂停，则停止会员记录]
			if(userinfo.getVipStatus()==1){
				userinfo.setVipStatus(2);
			}
			if(userinfo.getVipStatus()==2){
				userinfo.setVipStatus(4);
			}
			vipDao.update(userinfo);
		}
		return result;
	}

	@Override
	public OperaResult cardBalanceOpera(VipOperaInfo info_const) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(info_const.getUserid());
		if(info.getVipStatus()>=4){
			result.setResult(false);
			result.setComment("vip has been canceled");
			return result;
		}
		if(info.getVipStatus()==2&&info_const.isCost()){
			result.setResult(false);
			result.setComment("vip has been frozed");
		}
		VipCard card = info.getVipCard();
		double moneyleft = card.getBalance();
		double numopera = info_const.getNum();
		VipOperaInfo opinfo = info_const;
		opinfo.dateInit();
		if(moneyleft+numopera>=0){
			card.setBalance(moneyleft+numopera);
			if(info_const.isCost()){
				card.setScore(card.getScore()+(int) Math.abs(numopera)/10);
			}
			vipDao.updateCard(card);
			result.setResult(true);
			opinfo.setResult(true);
		}else{
			result.setResult(false);
			result.setComment("less");
			opinfo.setResult(false);
			opinfo.setComment("not enough");
		}
		recordService.insertVipRecord(opinfo);
		if(info.getVipStatus()==2){
			if(card.getBalance()>=card.getVipLevel().getCost()){
				cardLevelCost(info.getVipId());
			}
		}
		return result;
	}

	@Override
	public List<VipLevel> getLvList() {
		// TODO Auto-generated method stub
		return vipDao.getAllLevel();
	}

	@Override
	public VipCardInfo getVipCardInfoForClient(String userid) {
		// TODO Auto-generated method stub
		VipInfo info = vipDao.getVipInfoById(userid);
		VipCard card = info.getVipCard();
		VipCardInfo vcinfo = new VipCardInfo();
		vcinfo.setCardInfo(card);
		return vcinfo;
	}

	@Override
	public List<VipRecordInfo> getRecords(String userid) {
		// TODO Auto-generated method stub
		List<VipRecord> res = vipDao.getRecordsById(userid);
		List<VipRecordInfo> records = VipRecordInfo.parseVRI(res);
		return records;
	}

	@Override
	public OperaResult checkVipAccount(AccountLogin info) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		String ac = info.getAccountName();
		Account ac_sql = accountDao.findByAccountName(ac);
		if(ac_sql==null){
			result.setResult(false);
			result.setComment("usernotfound");
		}else{
			if(ac_sql.getPassword().equals(info.getPassword())){
				if(ac_sql.getIdentityId()==1){
					result.setResult(true);
					result.setStatus(ac_sql.getIdentityId());
					result.setAccount(ac_sql);
				}else{
					result.setResult(false);
					result.setComment("notvip");
				}
			}else{
				result.setResult(false);
				result.setComment("pserror");
			}
		}
		return result;
	}

	@Override
	public OperaResult addVipScore(String userid, int score) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		VipCard card = info.getVipCard();
		card.setScore(card.getScore()+score);
		vipDao.updateCard(card);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult scoreToBalance(String userid, int score) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		VipCard card = info.getVipCard();
		score = (score/100)*100;
		if(score==0){
			result.setResult(false);
			result.setComment("less than 100 cannot translate");
		}
		if(card.getScore()<score){
			result.setResult(false);
			result.setComment("not enough score");
			return result;
		}
		card.setScore(card.getScore()-score);
//		兑换率
		vipDao.updateCard(card);
		VipOperaInfo voi = new VipOperaInfo();
		voi.setRecharge(score/100);
		voi.setPurpose("score translate");
		voi.setUserid(userid);
		cardBalanceOpera(voi);
		result.setResult(true);
		return result;
	}

	@Override
	public OperaResult disactivateCardById(String userid) {
		// TODO Auto-generated method stub
		OperaResult result = new OperaResult();
		VipInfo info = vipDao.getVipInfoById(userid);
		info.setVipStatus(5);
		vipDao.update(info);
		result.setResult(true);
		return result;
	}


}
