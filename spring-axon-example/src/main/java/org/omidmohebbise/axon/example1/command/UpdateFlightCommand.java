package org.omidmohebbise.axon.example1.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.Duration;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Getter
public class UpdateFlightCommand {

    @TargetAggregateIdentifier
    private final String flightId;
    private final Long delay;

}
