package com.intuit.service;

import com.intuit.model.Player;

import java.io.FileNotFoundException;
import java.util.Collection;

public interface PlayerService {

  Collection<Player> getAllPlayer();

   boolean addPlayer(Player player);

  Player getPlayerById(long id);
  boolean checkValidPlayer(long id);

  }
