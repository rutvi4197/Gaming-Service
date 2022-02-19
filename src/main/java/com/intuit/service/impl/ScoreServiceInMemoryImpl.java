package com.intuit.service.impl;

import com.intuit.model.Score;
import com.intuit.service.PlayerService;
import com.intuit.service.ScoreService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScoreServiceInMemoryImpl implements ScoreService {

  private final List<Score> scoreList;
  private PlayerService playerService;

  public ScoreServiceInMemoryImpl(PlayerService playerService) {
    this.playerService = playerService;
    this.scoreList = new ArrayList<>();
  }

  @Override
  public boolean addScore(Score score) {
    if(playerService.checkValidPlayer(score.getPlayerId())) {
      this.scoreList.add(score);
      return true;
    }
    return false;
  }

  @Override
  public List<Long> addAllScore(List<Score> scores) {
    List<Long> invalidPlayes = new ArrayList<>();
    for (Score score : scores) {
      if(!this.addScore(score)){
        invalidPlayes.add(score.getPlayerId());
      }
    }
    return invalidPlayes;
  }

  @Override
  public List<Score> getAllScore() {
    return this.scoreList;
  }
}
