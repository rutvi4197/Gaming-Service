package com.intuit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GamingResponse {
  private long score;
  private String playerName;
}
