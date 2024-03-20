package org.omidmohebbise.axon.config;

import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.omidmohebbise.axon.aggregate.Flight;

public class AxonConfigurer {

    private final Configurer configurer;


    public AxonConfigurer() {
        this.configurer = DefaultConfigurer.defaultConfiguration()
                .configureAggregate(Flight.class);
    }

    public Configurer getConfigurer() {
        return configurer;
    }
}
