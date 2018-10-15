package com.stations.station_manager;

import com.stations.models.Station;
import com.stations.repositories.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.stations.models"})
@EnableJpaRepositories("com.stations.repositories")
public class StationManagerApplication {
  private static final Logger log = LoggerFactory.getLogger(StationManagerApplication.class);

  public static void main(String[] args) {
		SpringApplication.run(StationManagerApplication.class);
	}

	@Bean
  public CommandLineRunner demo(StationRepository repository) {
    return (args) -> {
      repository.save(new Station("001", "Kiss FM", true, null));
      repository.save(new Station("002", "Douche FM", false, "DGN-TV"));
      repository.save(new Station("003", "Diddy FM", true, "DID-TV"));

      log.warn("Stations found with findAll:");

      for (Station station : repository.findAll()) {
        log.warn(station.toString());
      }
    };
  }
}
