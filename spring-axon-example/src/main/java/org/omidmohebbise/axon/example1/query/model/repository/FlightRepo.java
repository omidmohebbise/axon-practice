package org.omidmohebbise.axon.example1.query.model.repository;

import org.omidmohebbise.axon.example1.query.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<FlightEntity,Long> {
    FlightEntity findByFlightId(String flightId);
}
