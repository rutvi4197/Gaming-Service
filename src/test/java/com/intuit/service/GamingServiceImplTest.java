package com.intuit.service;


import com.intuit.model.GamingResponse;
import com.intuit.model.Player;
import com.intuit.model.Score;
import com.intuit.service.impl.GamingServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class GamingServiceImplTest {
  private GamingServiceImpl gamingService;
  private  ScoreService scoreService;
  private  PlayerService playerService;
  public GamingServiceImplTest() {
    this.playerService = Mockito.mock(PlayerService.class);
    this.scoreService = Mockito.mock(ScoreService.class);
    this.gamingService = new GamingServiceImpl(scoreService, playerService);
  }

  @Test
  void topScoreTest() {
    List<Score> score = getScore();
    Mockito.when(this.scoreService.getAllScore()).thenReturn(score);
    Mockito.when(this.playerService.getPlayerById(ArgumentMatchers.anyLong())).thenReturn(new Player("rutvi"));
    List<GamingResponse> playersList = this.gamingService.getTopPlayers(5);
    Assertions.assertEquals(5,playersList.size());
    Assertions.assertEquals(80,playersList.get(0).getScore());
  }

  @Test
  void negativeTopScoreTest() {
    List<GamingResponse> playersList = this.gamingService.getTopPlayers(-1);
    Assertions.assertEquals(0,playersList.size());
  }


  private List<Score> getScore() {
    List<Score> list = new ArrayList<>();
    list.add(new Score(25L,1L));
    list.add(new Score(30L,2L));
    list.add(new Score(55L,3L));
    list.add(new Score(75L,4L));
    list.add(new Score(30L,5L));
    list.add(new Score(50L,6L));
    list.add(new Score(30L,7L));
    list.add(new Score(80L,8L));
    return list;
  }
}
