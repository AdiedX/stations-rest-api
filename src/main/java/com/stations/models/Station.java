package com.stations.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Station {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String stationID;

  private String name;

  private boolean hdEnabled;

  private String callSign;

  protected Station() {}

  public Station(String stationID, String name, boolean hdEnabled, String callSign) {
    this.stationID = stationID;
    this.name = name;
    this.hdEnabled = hdEnabled;
    this.callSign = callSign;
  }

  @Override
  public String toString() {
    return String.format(
      "Station[id=%s, name = %s, hdEnabled = %s, callSign = %s]",
      stationID, name, hdEnabled, callSign
    );
  }
}
