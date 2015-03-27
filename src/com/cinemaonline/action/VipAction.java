package com.cinemaonline.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemaonline.model.Activity;
import com.cinemaonline.model.ActivityRecord;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.VipCardInfo;
import com.cinemaonline.model.client.VipClientInfo;
import com.cinemaonline.model.client.VipOperaInfo;
import com.cinemaonline.model.client.VipRecordInfo;
import com.cinemaonline.model.client.VipUpdate;
import com.cinemaonline.service.ActivityService;
import com.cinemaonline.service.BankService;
import com.cinemaonline.service.InfoService;
import com.cinemaonline.service.VipService;

@Repository
public class VipAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private VipService vipService;
	@Autowired
	private BankService bankService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private InfoService infoService;
	
	private String ajaxinfo;
	private VipClientInfo vipinfo;
	private VipCardInfo cardinfo;
	private List<VipLevel> lvslist;
	private List<VipRecordInfo> recordlist;
	private List<Activity> activitylist;
	private List<Activity> activitylist_unparticipated;
	private List<Location> locationlist;
	private List<ActivityRecord> activityrecordlist;
	private int page;
	
	/*
	 * activity
	 * */
	public String ajax_activity(){
		String userid = (String) session.get("userid");
		activitylist_unparticipated = activityService.getUnparticipatedActivitiesForVipByPage(userid,page);
		if(activitylist_unparticipated==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String ajax_old_activity(){
		String userid = (String) session.get("userid");
		activitylist = activityService.getParticipatedActivitiesForVipByPage(userid,page);
		activityrecordlist = activityService.getRecordsByActivities(activitylist,Long.parseLong(userid));
		if(activitylist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String viewActivity(){
		return SUCCESS;
	}
	
	public String joinActivity(){
		String activityid = request.getParameter("activityid");
		String answerid = request.getParameter("answerid");
		String userid = (String) session.get("userid");
		OperaResult result = activityService.joinActivity(activityid,answerid,userid);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	/*
	 * info
	 * */
	public String viewInfo(){
		String userid = (String) session.get("userid");
		 vipinfo = vipService.getVipInfoForClient(userid);
		 locationlist = infoService.getAllLocation();
		return SUCCESS;
	}
	
	public String updateInfo(){
		String userid = (String) session.get("userid");
		VipUpdate info = new VipUpdate();
		info.setBirthday(request.getParameter("birthday"));
		info.setLocation(Integer.parseInt(request.getParameter("location")));
		info.setName(request.getParameter("name"));
		info.setSex(request.getParameter("sex"));
		OperaResult result = vipService.vipinfoUpate(info,userid);
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = "error";
		}
		return AJAXINFO;
	}
	
	/*
	 * card
	 * */
	public String viewCard(){
		String userid = (String) session.get("userid");
		 lvslist = vipService.getLvList();
		 vipinfo = vipService.getVipInfoForClient(userid);
		 OperaResult result = vipService.cardActivatedCheck(userid);//检测卡是否存在，不存在则未激活
		 if(result.getResult()){
			 cardinfo = vipService.getVipCardInfoForClient(userid);
			 return SUCCESS;
		 }else{
			 return ERROR;
		 }
	}
	
	public String disactivateCard(){
		String confirm = request.getParameter("confirm");
		String userid = (String) session.get("userid");
		if(confirm.equals("1")){
			OperaResult result = vipService.disactivateCardById(userid);
			if(result.getResult()){
				ajaxinfo = "success";
			}else{
				ajaxinfo = result.getComment();
			}
		}else{
			ajaxinfo = "request error";
		}
		return AJAXINFO;
	}
	
	public String translateScore(){
		String score = request.getParameter("score");
		String userid = (String) session.get("userid");
		OperaResult result = vipService.scoreToBalance(userid, Integer.parseInt(score));
		if(result.getResult()){
			ajaxinfo = "success";
		}else{
			ajaxinfo = result.getComment();
		}
		return AJAXINFO;
	}
	
	public String activateCard(){
		String userid = (String) session.get("userid");
		 BankOperaInfo info = new BankOperaInfo();
		 info.setUserId(request.getParameter("bankid"));
		 info.setPassword(request.getParameter("bankps"));
		 info.setConsume(request.getParameter("num"));
		 VipCardInfo infocard = new VipCardInfo();
		 infocard.setBalance(Math.abs(info.getOperateNum()));
		 infocard.setVipid(userid);
		 infocard.setScore(0);
		 infocard.setViplevel(request.getParameter("viplevel"));
		 if(info.getOperateNum()>-200){
			 ajaxinfo = "less1";
			 return AJAXINFO;
		 }
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
			 OperaResult activate_result = vipService.cardActivate(infocard);
			 if(activate_result.getResult()){
				 OperaResult levelcost_result = vipService.cardLevelCost(userid);
				 if(levelcost_result.getResult()){
					 ajaxinfo = "success";
					 return AJAXINFO;
				 }else{
					 ajaxinfo = "lvcostfailed";
					 return AJAXINFO;
				 }
			 }else{
				 ajaxinfo = "activatefailed";
			 }
		 }else{
			 ajaxinfo="bankcostfailed";
		 }
		return AJAXINFO;
	}
//	money in
	public String rechargeCard(){
		String userid = (String) session.get("userid");
		 BankOperaInfo info = new BankOperaInfo();
		 info.setUserId(request.getParameter("bankid"));
		 info.setPassword(request.getParameter("bankps"));
		 info.setConsume(request.getParameter("num"));
		 OperaResult bank_result = bankService.pay(info);
		 if(bank_result.getResult()){
			 VipOperaInfo opinfo = new VipOperaInfo();
			 opinfo.setUserid(userid);
			 opinfo.dateInit();
			 opinfo.setRecharge(info.getOperateNum());
			 opinfo.setPurpose("card recharge");
			 OperaResult recharge_result = vipService.cardBalanceOpera(opinfo);
			 if(recharge_result.getResult()){
				 ajaxinfo = "success";
			 }else{
				 ajaxinfo = recharge_result.getComment();
			 }
			 
		 }else{
			 ajaxinfo = bank_result.getComment();
		 }
		return AJAXINFO;
	}
	
	
	/*
	 * record
	 * */
	public String ajax_record(){
		String userid = (String) session.get("userid");
		setRecordlist(vipService.getRecordsByPage(userid,page));
		if(recordlist==null||page<0){
			ajaxinfo="empty";
			return AJAXINFO;
		}
		return SUCCESS;
	}
	public String viewRecord(){
		return SUCCESS;
	}
// ////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getAjaxinfo() {
		return ajaxinfo;
	}

	public void setAjaxinfo(String ajaxinfo) {
		this.ajaxinfo = ajaxinfo;
	}

	public VipClientInfo getVipinfo() {
		return vipinfo;
	}

	public void setVipinfo(VipClientInfo vipinfo) {
		this.vipinfo = vipinfo;
	}

	public VipCardInfo getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(VipCardInfo cardinfo) {
		this.cardinfo = cardinfo;
	}

	public List<VipLevel> getLvslist() {
		return lvslist;
	}

	public void setLvslist(List<VipLevel> lvslist) {
		this.lvslist = lvslist;
	}

	public List<VipRecordInfo> getRecordlist() {
		return recordlist;
	}

	public void setRecordlist(List<VipRecordInfo> recordlist) {
		this.recordlist = recordlist;
	}

	public List<Activity> getActivitylist() {
		return activitylist;
	}

	public void setActivitylist(List<Activity> activitylist) {
		this.activitylist = activitylist;
	}

	public List<Activity> getActivitylist_unparticipated() {
		return activitylist_unparticipated;
	}

	public void setActivitylist_unparticipated(
			List<Activity> activitylist_unparticipated) {
		this.activitylist_unparticipated = activitylist_unparticipated;
	}

	public List<Location> getLocationlist() {
		return locationlist;
	}

	public void setLocationlist(List<Location> locationlist) {
		this.locationlist = locationlist;
	}

	public List<ActivityRecord> getActivityrecordlist() {
		return activityrecordlist;
	}

	public void setActivityrecordlist(List<ActivityRecord> activityrecordlist) {
		this.activityrecordlist = activityrecordlist;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}


}
