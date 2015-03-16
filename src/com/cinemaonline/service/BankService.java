package com.cinemaonline.service;

import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;

public interface BankService {
	public OperaResult pay(BankOperaInfo info);
}
