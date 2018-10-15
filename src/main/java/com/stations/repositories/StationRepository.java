package com.stations.repositories;

import com.stations.models.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
  Station findByStationID(String stationID);
  Station findByStationName(String name);
}
