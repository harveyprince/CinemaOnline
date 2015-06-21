package com.cinemaonline.service;

import java.util.List;

import com.cinemaonline.model.FilmProfitPlan;
import com.cinemaonline.model.ProfitPlan;
import com.cinemaonline.model.client.FilmInfo;
import com.cinemaonline.model.client.FilmProfitFromClient;
import com.cinemaonline.model.client.OperaResult;
import com.cinemaonline.model.client.ProfitPlanInfo;

public interface ProfitService {

	OperaResult addProfitPlan(ProfitPlanInfo info);

	List<FilmInfo> getAllUnplanedFilms();

	List<ProfitPlan> getAllWorkingPlans();

	List<ProfitPlan> getAllWorkingUndispatchPlans();

	List<FilmProfitPlan> getProfitDispatchByPlanId(String id);

	OperaResult submitProfitDispatch(
			List<FilmProfitFromClient> filmProfitPercentlist);

	List<ProfitPlan> getWorkingDispatchedProfitPlan();

}
