package com.cinemaonline.dao;

import com.cinemaonline.model.Bank;
public interface BankDao {
	
	public Bank findById(long id);
	
	public void update(Bank bank);
	
	public Bank insert(Bank info);

}
