package com.intuit.service.impl;

import com.intuit.model.Score;
import com.intuit.service.ScoreService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

  private final List<Score> scoreList;

  public ScoreServiceImpl() {
    this.scoreList = new ArrayList<>();

  }

  @Override
  public void addScore(Score score) {
    this.scoreList.add(score);
  }

  @Override
  public List<Score> getAllScore() {
    return this.scoreList;
  }
}
