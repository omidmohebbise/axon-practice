package org.omidmohebbise.axon.example1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@AllArgsConstructor
@Getter
public class CreateToDoCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String description;

}
