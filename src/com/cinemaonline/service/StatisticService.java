package com.cinemaonline.service;

import com.cinemaonline.model.client.StatisticCinemaClient;

public interface StatisticService {

	StatisticCinemaClient getCinemaStatic(int year, int month);

}
