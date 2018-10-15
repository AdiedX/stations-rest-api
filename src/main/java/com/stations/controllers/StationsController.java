package com.stations.controllers;

import com.stations.models.Station;
import com.stations.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StationsController {
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private StationRepository repository;

  @RequestMapping(
    value = "/stations/{name}",
    method = RequestMethod.GET,
    produces = "application/json"
  )
  public Station getStationByName(@PathVariable(name = "name", required = false) String name) {
    return repository.findByStationName(name);
  }
}
