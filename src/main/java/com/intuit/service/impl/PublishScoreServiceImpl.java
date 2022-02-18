package com.intuit.service.impl;

import com.intuit.model.Score;
import com.intuit.service.PublishScoreService;
import com.intuit.service.ScoreService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishScoreServiceImpl implements PublishScoreService {
  private final ScoreService scoreService;

  @Autowired
  public PublishScoreServiceImpl(ScoreService scoreService) {
    this.scoreService = scoreService;
  }

  /*Reading from topic and push in database
   * here I am reading from file and pushing in database*/
  @Override
  public boolean readScoreFromTopic() throws FileNotFoundException {
    File file = new File("/home/rutvishah/interviews/intuit/src/main/resources/scorePublishFile.txt");
    Scanner scanner = new Scanner(file);

    List<String> fileContent = new ArrayList<>();
    while (scanner.hasNext()) {
      String next = scanner.nextLine();
      fileContent.add(next);
    }
     populateScoresFromfile(fileContent);
    return true;
  }

  @Override
  public List<Score> getAllScoreFromScoreTable() {
    return this.scoreService.getAllScore();
  }

  private void populateScoresFromfile(List<String> fileContent) {
    for (String content : fileContent) {
      String[] split = content.split(" ");
      Score score = new Score(Long.valueOf(split[1]), Long.valueOf(split[0]));
      scoreService.addScore(score);}
  }




}
