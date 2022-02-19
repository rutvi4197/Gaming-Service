package com.intuit.service;

import com.intuit.model.Score;

import java.util.List;

public interface PublishScoreService {

  boolean readScores();

  boolean writeScores(List<Score> scoreList);



}
