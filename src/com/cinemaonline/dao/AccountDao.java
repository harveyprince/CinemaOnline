package com.cinemaonline.dao;

import com.cinemaonline.model.Account;
import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.AccountUpdate;

public interface AccountDao {
	public long insert(AccountSignUp info);
	
	public void update(AccountUpdate info);
	
	public void deleteByAccountName(String ac);
	
	public Account find(AccountLogin info);
	
	public Account findByAccountName(String ac);

}
