package com.cinemaonline.dao;

public interface AccountDao {
	public int login(String accountName,String password);
	
	public long signup(String accountName,String password);

}
