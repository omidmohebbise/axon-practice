package org.omidmohebbise.axon.example1.command;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Getter
public class CreateFlightCommand {

    private final String flightId;
    private final String destination;
    private final String source;
    private final ZonedDateTime departure;
    private final ZonedDateTime arrival;

}
