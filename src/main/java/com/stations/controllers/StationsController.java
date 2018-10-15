package com.stations.controllers;

import com.stations.models.Station;
import com.stations.repositories.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StationsController {
  private final AtomicLong counter = new AtomicLong();

  private static final Logger logger = LoggerFactory.getLogger(StationsController.class);

  @Autowired
  private StationRepository repository;

  @RequestMapping(
    value = "/stations/n/{name}",
    method = RequestMethod.GET,
    produces = "application/json"
  )
  public Iterable<Station> getStationByName(@PathVariable(name = "name", required = true) String name) {
    return repository.findByName(name);
  }

  @RequestMapping(
    value = "/stations/id/{id}",
    method = RequestMethod.GET,
    produces = "application/json"
  )
  public Iterable<Station> getStationByID(@PathVariable(name = "stationID", required = true) String stationID) {
    return repository.findByStationID(stationID);
  }

  @RequestMapping(
    value = "/stations",
    method = RequestMethod.GET,
    produces = "application/json"
  )
  public Iterable<Station> getAllStations() {
    return repository.findAll();
  }

  @RequestMapping(
    value = "/stations",
    method = RequestMethod.POST,
    produces = "application/json"
  )
  public void saveStation(@RequestBody Station newStation) {
    repository.save(newStation);
  }

  @RequestMapping(
    value = "/stations/id/{stationID}",
    method = RequestMethod.PUT,
    produces = "application/json"
  )
  public void updateStation(@RequestBody Station updatedStation, @PathVariable(name = "stationID", required = true) String stationID) {
    try {
      repository.findByStationID(stationID).forEach(station -> {
        station.setName(updatedStation.getName());
        station.setCallSign(updatedStation.getCallSign());
        station.setStationID(updatedStation.getStationID());
        station.setHdEnabled(updatedStation.isHdEnabled());
      });
    } catch (Exception e) {
      logger.error("Could not find station corresponding to %s", stationID);
      e.printStackTrace();
    }
  }
}
