package com.intuit.service.action;

import com.intuit.model.Player;
import com.intuit.service.PlayerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayerFileReaderImpl implements Action<Boolean> {
  private final PlayerService playerService;

  @Autowired
  public PlayerFileReaderImpl(PlayerService playerService) {
    this.playerService = playerService;
  }

  @Override
  public Boolean invoke() {
    File file = new File("/home/rutvishah/interviews/intuit/src/main/resources/playerFile.txt");
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
    }
    catch (FileNotFoundException e) {

      log.error("File Not Found while reading player ", e);
      return false;
    }

    List<String> fileContent = new ArrayList<>();
    while (scanner.hasNext()) {
      String next = scanner.nextLine();
      fileContent.add(next);
    }
    populateScoresFromfile(fileContent);
    return true;
  }

  private void populateScoresFromfile(List<String> fileContent) {
    for (String content : fileContent) {
      String[] split = content.split(" ");
      Player player = new Player(Integer.valueOf(split[0]), split[1], split[2], Integer.valueOf(split[3]));
      playerService.addPlayer(player);
    }
  }
}
