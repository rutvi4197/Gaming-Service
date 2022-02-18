package com.intuit.model;

import lombok.Data;

@Data
public class Score {
  private long score;
  private long playerId;

  public Score(Long score, Long playerId) {
    this.score=score;
    this.playerId =playerId;
  }
}
