package com.intuit.controller;

import com.intuit.model.Score;
import com.intuit.service.ScoreService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scoring")
public class ScoringController {
  private final ScoreService scoreService;

  @Autowired
  public ScoringController(ScoreService scoreService) {this.scoreService = scoreService;}

  @GetMapping
  public List<Score> getAllScore() {
    return this.scoreService.getAllScore();
  }

}
