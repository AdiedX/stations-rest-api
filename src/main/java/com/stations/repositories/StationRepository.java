package com.stations.repositories;

import com.stations.models.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
  Iterable<Station> findByStationID(String stationID);
  Iterable<Station> findByName(String name);
}
