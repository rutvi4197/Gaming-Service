package com.intuit.service;

import com.intuit.model.Score;

import java.util.List;

public interface ScoreService {

  void addScore(Score score);

  List<Score> getAllScore();

}
