package com.intuit.service.impl;

import com.intuit.model.Player;
import com.intuit.service.PlayerService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PlayerServiceInMemoryImpl implements PlayerService {

  private final Map<Long, Player> players;

  public PlayerServiceInMemoryImpl() {
    this.players = new HashMap<>();
  }

  @Override
  public Collection<Player> getAllPlayer() {
    return this.players.values();
  }


  @Override
  public boolean addPlayer(Player player) {
    this.players.put(player.getId(), player);
    return true;
  }

  @Override
  public Player getPlayerById(long id) {
    return this.players.get(id);

  }
  @Override
  public boolean checkValidPlayer(long id) {
    return this.players.containsKey(id);

  }
}
