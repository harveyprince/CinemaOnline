package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.Bank;
import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipLevel;
import com.cinemaonline.model.client.OperaResult;

public interface InfoService {

	public OperaResult addHall(Hall info);
	
	public OperaResult addBank(Bank info);
	
	public OperaResult addIdentity(Identity info);
	
	public OperaResult addVipLevel(VipLevel info);
	
	public OperaResult addAccount(Account info);
	
	public List<Location> getAllLocation();

	public void addLocation(Location info);
}
