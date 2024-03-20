package org.omidmohebbise.axon.example1.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Getter
public class FlightUpdatedEvent {

    private final String flightId;
    private final Long delay;

}
