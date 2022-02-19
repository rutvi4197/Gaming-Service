package com.intuit.service;

import com.intuit.model.Score;
import com.intuit.service.impl.ScoreServiceInMemoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ScoreServiceInMemoryImplTest {
  private ScoreServiceInMemoryImpl scoreServiceInMemory;
  private PlayerService playerService ;

  public ScoreServiceInMemoryImplTest() {
    this.playerService = Mockito.mock(PlayerService.class);
    this.scoreServiceInMemory = new ScoreServiceInMemoryImpl(this.playerService);
  }


  @Test
  void addValidPlayer() {
    Score score = new Score(30L,1L);
    Mockito.when(this.playerService.checkValidPlayer(1)).thenReturn(true);
    Assertions.assertTrue( this.scoreServiceInMemory.addScore(score));

  }
  @Test
  void addInvalidPlayer() {
    Score score = new Score(30L,1L);
    Mockito.when(this.playerService.checkValidPlayer(1)).thenReturn(false);
    Assertions.assertFalse( this.scoreServiceInMemory.addScore(score));

  }

  @Test
  void getAllScore() {
    Score score = new Score(30L,1L);
    Mockito.when(this.playerService.checkValidPlayer(1)).thenReturn(true);
    this.scoreServiceInMemory.addScore(score);
    List<Score> allScore = this.scoreServiceInMemory.getAllScore();
    Assertions.assertEquals(1,allScore.size());
  }

  @Test
  void addAllScore(){
    List<Score> scores = new ArrayList<>();
    scores.add(new Score(30L,1L));
    scores.add(new Score(50L,2L));
    Mockito.when(this.playerService.checkValidPlayer(1)).thenReturn(true);
    List<Long> invalidPlayers = this.scoreServiceInMemory.addAllScore(scores);
    Assertions.assertEquals(1,invalidPlayers.size());
  }
}
