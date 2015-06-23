package com.cinemaonline.model.client;

import com.cinemaonline.model.ProfitPlan;

public class StatisticProfitStatus {

	private ProfitPlan profitPlan;
	private Long profit;
	public ProfitPlan getProfitPlan() {
		return profitPlan;
	}
	public void setProfitPlan(ProfitPlan profitPlan) {
		this.profitPlan = profitPlan;
	}
	public Long getProfit() {
		return profit;
	}
	public void setProfit(Long profit) {
		this.profit = profit;
	}
}
