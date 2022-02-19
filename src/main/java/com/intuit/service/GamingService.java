package com.intuit.service;

import com.intuit.model.GamingResponse;

import java.util.List;

public interface GamingService {

  List<GamingResponse> getTopPlayers(int scoreCount);

}
