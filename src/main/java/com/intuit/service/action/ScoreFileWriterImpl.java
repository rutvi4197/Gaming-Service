package com.intuit.service.action;

import com.intuit.model.Score;
import com.intuit.service.ScoreService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScoreFileWriterImpl implements Action<Boolean> {

  private final ScoreService scoreService;
  private List<Score> scores;

  @Autowired
  public ScoreFileWriterImpl(ScoreService scoreService) {
    this.scoreService = scoreService;
  }

  @Override
  public Boolean invoke() {
    List<Long> invalidPlayers = this.scoreService.addAllScore(this.scores);
    if(!invalidPlayers.isEmpty())
    log.error("Invalid Players found: "+ invalidPlayers.toString());
    return true;
  }

  public ScoreFileWriterImpl withScoreList(List<Score> scores){
    this.scores = scores;
    return this;
  }

}
