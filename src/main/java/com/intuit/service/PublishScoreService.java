package com.intuit.service;

import com.intuit.model.Score;

import java.io.FileNotFoundException;
import java.util.List;

public interface PublishScoreService {

  boolean readScoreFromTopic() throws FileNotFoundException;

  List<Score> getAllScoreFromScoreTable();

}
