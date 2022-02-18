package com.intuit.controller;

import com.intuit.model.DashboardResponse;
import com.intuit.service.DashboardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
  private final DashboardService dashboardService;

  @Autowired
  public DashboardController(DashboardService dashboardService) {this.dashboardService = dashboardService;}

  @GetMapping(value = "/getTopPlayers")
  public List<DashboardResponse> getTop5Players(@RequestParam(value = "maxCount", required = false) Integer maxCount) {
    if (maxCount == null || maxCount == 0) {
      maxCount = 5;
    }
    return this.dashboardService.getTop5Players(maxCount);
  }
}
