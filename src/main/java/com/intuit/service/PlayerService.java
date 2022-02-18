package com.intuit.service;

import com.intuit.model.Player;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

public interface PlayerService {

  boolean addPlayer(String name,String gender,int age);

  boolean readPlayersFromFile() throws FileNotFoundException;

  Collection<Player> getAllPlayer();

   void addPlayer(Player player);
  String getPlayerName(long id);

  }
