package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.ProfitPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.ProfitPlanInfo;

public interface ProfitService {

	OperaResult addProfitPlan(ProfitPlanInfo info);

	List<FilmInfo> getAllUnplanedFilms();

	List<ProfitPlan> getAllWorkingPlans();

}
