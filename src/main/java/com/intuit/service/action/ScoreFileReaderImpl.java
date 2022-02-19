package com.intuit.service.action;

import com.intuit.model.Score;
import com.intuit.service.ScoreService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScoreFileReaderImpl implements Action<Boolean> {

  private final ScoreService scoreService;

  @Autowired
  public ScoreFileReaderImpl(ScoreService scoreService) {
    this.scoreService = scoreService;
  }

  @Override
  public Boolean invoke() {
    File file = new File("/home/rutvishah/interviews/intuit/src/main/resources/scorePublishFile.txt");
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    }
    catch (FileNotFoundException e) {
      log.error("File Not Found while reading score ",e);
      return  false;
    }

    List<String> fileContent = new ArrayList<>();
    while (scanner.hasNext()) {
      String next = scanner.nextLine();
      fileContent.add(next);
    }
    populateScoresFromfile(fileContent);
    return true;
  }
  private void populateScoresFromfile(List<String> fileContent) {
    for (String content : fileContent) {
      String[] split = content.split(" ");
      Score score = new Score(Long.valueOf(split[1]), Long.valueOf(split[0]));
      boolean succesful = scoreService.addScore(score);
      if(!succesful)    log.error("Invalid Player found: "+ score.getPlayerId());

    }
  }
}
