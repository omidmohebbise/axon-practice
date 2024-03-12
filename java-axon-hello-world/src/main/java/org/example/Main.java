package org.example;

import org.axonframework.config.Configuration;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;

public class Main {
    public static void main(String[] args) {
        Configurer configurer =
                DefaultConfigurer.defaultConfiguration()
                        .configureAggregate(Flight.class)
                        .registerCommandHandler(configuration -> {
                            return configuration;
                        });
        Configuration configuration = configurer.start();
    }
}