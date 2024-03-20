package org.omidmohebbise.axon.aggregate;

import org.axonframework.modelling.command.AggregateIdentifier;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


public class Flight {

    @AggregateIdentifier
    private String aggregateId;


    public void scheduleFlight(String aggregateId){

    }
}
