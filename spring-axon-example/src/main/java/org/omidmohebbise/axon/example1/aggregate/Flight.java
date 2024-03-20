package org.omidmohebbise.axon.example1.aggregate;

import lombok.Getter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.omidmohebbise.axon.example1.command.CreateFlightCommand;
import org.omidmohebbise.axon.example1.command.UpdateFlightCommand;
import org.omidmohebbise.axon.example1.event.FlightCreatedEvent;
import org.omidmohebbise.axon.example1.event.FlightUpdatedEvent;


import java.time.ZonedDateTime;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Getter
public class Flight {
    @AggregateIdentifier
    private String id;
    private String destination;
    private String source;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;

    public Flight() {
      //
    }

    @CommandHandler
    public Flight(CreateFlightCommand command) {
        apply(new FlightCreatedEvent(command.getFlightId(), command.getDestination(),
                command.getSource(), command.getDeparture(), command.getArrival()));
    }

    @EventSourcingHandler
    public void on(FlightCreatedEvent event) {
        this.id = event.getFlightId();
        this.destination = event.getDestination();
        this.source = event.getSource();
        this.departure = event.getDeparture();
        this.arrival = event.getArrival();
    }

}
