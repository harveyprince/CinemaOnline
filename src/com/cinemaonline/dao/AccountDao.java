package com.cinemaonline.dao;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.client.AccountLogin;

public interface AccountDao {
	public Account insert(Account info);
	
	public void update(Account info);
	
	public void deleteByAccountName(String ac);
	
	public Account find(AccountLogin info);
	
	public Account findByAccountName(String ac);

}
