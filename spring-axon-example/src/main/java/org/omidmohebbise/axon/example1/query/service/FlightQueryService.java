package org.omidmohebbise.axon.example1.query.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.omidmohebbise.axon.example1.event.FlightCreatedEvent;
import org.omidmohebbise.axon.example1.query.FlightBasicQuery;
import org.omidmohebbise.axon.example1.query.model.FlightEntity;
import org.omidmohebbise.axon.example1.query.model.repository.FlightRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightQueryService {

    private final FlightRepo repository;

    @EventSourcingHandler
    public void on(FlightCreatedEvent event) {
        Duration duration = Duration.between(event.getDeparture(), event.getArrival());
        repository.save(FlightEntity.builder()
                .flightId(event.getFlightId())
                .source(event.getSource())
                .destination(event.getDestination())
                .departure(event.getDeparture())
                .arrival(event.getArrival())
                .reservationDate(LocalDateTime.now())
                .duration(duration.getSeconds())
                .build());
    }

    @QueryHandler
    public List<FlightEntity> findAllFlights(FlightBasicQuery flightBasicQuery){
        return repository.findAll(
                PageRequest.of(flightBasicQuery.getPage(),
                30,Sort.by(Sort.Direction.DESC,"id"))).getContent();

    }
}
