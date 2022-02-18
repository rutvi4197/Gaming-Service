package com.intuit.service.impl;

import com.intuit.model.DashboardResponse;
import com.intuit.model.Score;
import com.intuit.service.DashboardService;
import com.intuit.service.PlayerService;
import com.intuit.service.ScoreService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

  private final ScoreService scoreService;
  private final PlayerService playerService;

  @Autowired
  public DashboardServiceImpl(ScoreService scoreService, PlayerService playerService) {
    this.scoreService = scoreService;
    this.playerService = playerService;
  }

  @Override
  public List<DashboardResponse> getTop5Players(int scoreCount) {
    List<Score> scoreCountList = this.scoreService.getAllScore().stream()
                                                  .sorted(Comparator.comparingLong(Score::getScore).reversed())
                                                  .limit(scoreCount).toList();
    List<DashboardResponse> response = new ArrayList<>(scoreCount);
    for (Score score : scoreCountList) {
      String playerName = playerService.getPlayerName(score.getPlayerId());
      if(playerName != null) {
        DashboardResponse dashboardResponse = new DashboardResponse(score.getScore(), playerName);
        response.add(dashboardResponse);
      }
    }

    return response;
  }
}
