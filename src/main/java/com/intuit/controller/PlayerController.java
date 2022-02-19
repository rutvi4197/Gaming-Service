package com.intuit.controller;

import com.intuit.model.Player;
import com.intuit.service.PlayerService;
import com.intuit.service.action.PlayerFileReaderImpl;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

  private final PlayerService playerService;
  private final PlayerFileReaderImpl playerFileReader;
  public PlayerController(PlayerService playerService, PlayerFileReaderImpl playerFileReader) {
    this.playerService = playerService;
    this.playerFileReader = playerFileReader;
  }

  @GetMapping(value = "/read")
  public boolean readPlayersFromFile(){
   return this.playerFileReader.invoke();
  }

  @PostMapping(value = "/add")
  public boolean getAllPlayer(@RequestBody Player player) {
   return this.playerService.addPlayer(player);
  }

  @GetMapping()
  public Collection<Player> getAllPlayer()  {
    return this.playerService.getAllPlayer();
  }

}
