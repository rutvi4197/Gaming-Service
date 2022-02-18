package com.intuit.controller;

import com.intuit.model.Player;
import com.intuit.service.PlayerService;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

  private final PlayerService playerService;
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping(value = "/readPlayerFromFile")
  public boolean readPlayersFromFile() throws FileNotFoundException {
   return this.playerService.readPlayersFromFile();
  }
  @GetMapping(value = "/addPlayer")
  public boolean addPlayer(@RequestParam("name")String name,
                        @RequestParam("gender")String  gender,
                        @RequestParam("age")int age) throws FileNotFoundException {
   return this.playerService.addPlayer(name,gender,age);
  }

  @GetMapping(value = "/getAllPlayer")
  public Collection<Player> addPlayer() throws FileNotFoundException {
    return this.playerService.getAllPlayer();
  }

}
