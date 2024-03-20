package org.omidmohebbise.axon.example1.command.service;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.omidmohebbise.axon.example1.command.CreateFlightCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class FlightService{

    private final CommandGateway commandGateway;
    private final List<String> airports = List.of("IST", "AMS", "IKH", "ISF", "TNK","NYC", "LAX", "LHR", "CDG", "SYD");

    @Scheduled( fixedRate = 5000)
    public void timer(){
        var random = (new Random().nextInt(airports.size()-1));
        var currentTime = ZonedDateTime.now();
        commandGateway.send(new CreateFlightCommand(String.format("flight %d %d %d",
                currentTime.getHour(),
                currentTime.getMinute(),
                currentTime.getSecond()
                ),
                airports.get(random),
                random >= airports.size() ? airports.get(random-1) : airports.get(random+1),
                currentTime.plusDays(random),
                currentTime.plusDays(random).plusHours(3)
                ));
    }


}
