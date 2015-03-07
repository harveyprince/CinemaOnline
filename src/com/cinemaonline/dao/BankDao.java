package com.cinemaonline.dao;

import com.cinemaonline.model.client.BankOperaInfo;
import com.cinemaonline.model.client.OperaResult;
public interface BankDao {
	
	public OperaResult saveIn(BankOperaInfo info);
	
	public OperaResult consume(BankOperaInfo info);

}
