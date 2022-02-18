package com.intuit.controller;

import com.intuit.model.Score;
import com.intuit.service.PublishScoreService;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishScoreController {
  private final PublishScoreService publishScoreService;

  public PublishScoreController(PublishScoreService publishScoreService) {
    this.publishScoreService = publishScoreService;
  }

  @GetMapping(value = "/readScoresFromFile")
  public boolean readScoresFromFile() throws FileNotFoundException {
    return this.publishScoreService.readScoreFromTopic();
  }

  @GetMapping(value = "/getAllPlayer")
  public List<Score> addPlayer() throws FileNotFoundException {
    return this.publishScoreService.getAllScoreFromScoreTable();
  }
}
