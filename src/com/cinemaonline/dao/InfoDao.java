package com.cinemaonline.dao;

import java.util.List;

import com.cinemaonline.model.Hall;
import com.cinemaonline.model.Identity;
import com.cinemaonline.model.Location;
import com.cinemaonline.model.VipLevel;

public interface InfoDao {
//	identity
	public Identity insertIdentity(Identity info);
	
	public Identity getIdentityById(int id);
//hall
	public Hall insertHall(Hall info);
	
//	viplevel
	public VipLevel insertVipLevel(VipLevel info);
	
//	location
	public Location insertLocation(Location info);
	
	public Location getLocationById(int id);
	
	public List<Location> getAllLocation();
	
	public List<Location> getLocationWithVips();
}
