package com.intuit.service;

import com.intuit.model.Score;

import java.util.List;

public interface ScoreService {

  boolean addScore(Score score);

  List<Long> addAllScore(List<Score> scores);

  List<Score> getAllScore();

}
