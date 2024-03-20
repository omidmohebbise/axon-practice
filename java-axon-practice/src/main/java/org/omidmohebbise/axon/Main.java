package org.omidmohebbise.axon;

import org.axonframework.config.Configuration;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.omidmohebbise.axon.aggregate.Flight;
import org.omidmohebbise.axon.config.AxonConfigurer;

public class Main {
    public static void main(String[] args) {
        AxonConfigurer configurer = new AxonConfigurer();
        configurer.getConfigurer().start();

        System.out.println("end");
    }
}