package com.cinemaonline.dao;

import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;

public interface AccountDao {
	public int login(AccountLogin login);
	
	public long signup(AccountSignUp signup);

}
