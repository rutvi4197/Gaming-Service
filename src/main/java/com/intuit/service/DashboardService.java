package com.intuit.service;

import com.intuit.model.DashboardResponse;

import java.util.List;

public interface DashboardService {

  List<DashboardResponse> getTop5Players(int scoreCount);

}
