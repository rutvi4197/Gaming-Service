package com.intuit.service.impl;

import com.intuit.model.GamingResponse;
import com.intuit.model.Player;
import com.intuit.model.Score;
import com.intuit.service.GamingService;
import com.intuit.service.PlayerService;
import com.intuit.service.ScoreService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamingServiceImpl implements GamingService {

  private final ScoreService scoreService;
  private final PlayerService playerService;

  @Autowired
  public GamingServiceImpl(ScoreService scoreService, PlayerService playerService) {
    this.scoreService = scoreService;
    this.playerService = playerService;
  }

  @Override
  public List<GamingResponse> getTopPlayers(int scoreCount) {
    if (scoreCount < 0) {
      return Collections.emptyList();
    }
    List<Score> scoreCountList = this.scoreService.getAllScore().stream()
                                                  .sorted(Comparator.comparingLong(Score::getScore).reversed())
                                                  .limit(scoreCount).toList();
    List<GamingResponse> response = new ArrayList<>(scoreCount);
    for (Score score : scoreCountList) {
      Player player = playerService.getPlayerById(score.getPlayerId());
      GamingResponse dashboardResponse = new GamingResponse(score.getScore(), player.getName());
      response.add(dashboardResponse);
    }

    return response;
  }
}
