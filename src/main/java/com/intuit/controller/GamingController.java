package com.intuit.controller;

import com.intuit.model.GamingResponse;
import com.intuit.service.GamingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GamingController {
  private final GamingService gamingService;

  @Autowired
  public GamingController(GamingService dashboardService) {this.gamingService = dashboardService;}

  @GetMapping(value = "/getTopPlayers")
  public List<GamingResponse> getTop5Players(@RequestParam(value = "maxCount", required = false,defaultValue = "5") int maxCount) {
    return this.gamingService.getTopPlayers(maxCount);
  }
}
