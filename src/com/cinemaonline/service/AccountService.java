package com.cinemaonline.service;

import com.cinemaonline.model.client.AccountLogin;
import com.cinemaonline.model.client.AccountSignUp;
import com.cinemaonline.model.client.OperaResult;

public interface AccountService {
	public OperaResult loginJudge(AccountLogin info);
	
	public OperaResult signupJudge(AccountSignUp signup);
}
