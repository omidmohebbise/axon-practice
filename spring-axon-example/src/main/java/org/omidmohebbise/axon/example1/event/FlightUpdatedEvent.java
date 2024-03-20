package org.omidmohebbise.axon.example1.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FlightUpdatedEvent {

    private final String flightId;
    private final String updatedDestination;

}
