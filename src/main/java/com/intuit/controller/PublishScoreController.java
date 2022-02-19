package com.intuit.controller;

import com.intuit.model.Score;
import com.intuit.service.PublishScoreService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class PublishScoreController {
  private final PublishScoreService publishScoreService;

  public PublishScoreController(PublishScoreService publishScoreService) {
    this.publishScoreService = publishScoreService;
  }

  @GetMapping(value = "/scores")
  public boolean readScores() {
    return this.publishScoreService.readScores();
  }

  @PostMapping(value = "/scores",consumes = MediaType.APPLICATION_JSON_VALUE)
  public boolean addScores(@RequestBody List<Score> score) {
    return this.publishScoreService.writeScores(score);
  }

}
