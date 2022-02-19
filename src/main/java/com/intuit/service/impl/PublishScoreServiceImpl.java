package com.intuit.service.impl;

import com.intuit.model.Score;
import com.intuit.service.PublishScoreService;
import com.intuit.service.action.ScoreFileReaderImpl;
import com.intuit.service.action.ScoreFileWriterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishScoreServiceImpl implements PublishScoreService {
  private final ScoreFileReaderImpl scoreFileReader;
  private final ScoreFileWriterImpl scoreWriter;

  @Autowired
  public PublishScoreServiceImpl(ScoreFileReaderImpl scoreFileReader,
                                 ScoreFileWriterImpl scoreFileWriter) {
    this.scoreFileReader = scoreFileReader;
    this.scoreWriter = scoreFileWriter;
  }

  /*Reading from topic and push in database
   * here I am reading from file and pushing in database*/
  @Override
  public boolean readScores() {
    return this.scoreFileReader.invoke();
  }

  @Override
  public boolean writeScores(List<Score> scores) {
    return this.scoreWriter.withScoreList(scores).invoke();
  }



}
