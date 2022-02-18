package com.intuit.service.impl;

import com.intuit.model.Player;
import com.intuit.model.Score;
import com.intuit.service.PlayerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
  private Map<Long, Player> players;

  public PlayerServiceImpl() {this.players = new HashMap<>();}

  @Override
  public boolean addPlayer(String name, String gender,int age) {
    Player player = new Player(name,gender,age);
    this.addPlayer(player);
    return true;
  }

  @Override
  public boolean readPlayersFromFile() throws FileNotFoundException {
    File file = new File("/home/rutvishah/interviews/intuit/src/main/resources/playerFile.txt");
    Scanner scanner = new Scanner(file);

    List<String> fileContent = new ArrayList<>();
    while (scanner.hasNext()) {
      String next = scanner.nextLine();
      fileContent.add(next);
    }
    populateScoresFromfile(fileContent);
    return true;
  }

  @Override
  public Collection<Player> getAllPlayer() {
    return this.players.values();
  }

  private void populateScoresFromfile(List<String> fileContent) {
    for (String content : fileContent) {
      String[] split = content.split(" ");
      Player player = new Player(Integer.valueOf(split[0]), split[1],split[2], Integer.valueOf(split[3]));
      this.addPlayer(player);
    }
  }
  @Override
  public void addPlayer(Player player) {
    this.players.put(player.getId(), player);
  }

  public String getPlayerName(long id){
    Player player = this.players.get(id);
    if(player != null){
      return player.getName();
    }
    return null;
  }
}
