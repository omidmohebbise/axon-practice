package org.omidmohebbise.axon.example1.controller;

import lombok.RequiredArgsConstructor;
import org.omidmohebbise.axon.example1.command.UpdateFlightCommand;
import org.omidmohebbise.axon.example1.command.service.FlightService;
import org.omidmohebbise.axon.example1.query.FlightBasicQuery;
import org.omidmohebbise.axon.example1.query.service.FlightQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightQueryService flightQueryService;
    private final FlightService flightService;


    @GetMapping("/{page}")
    public ResponseEntity<?> findAllFlights(@PathVariable int page){
        return ResponseEntity.ok(flightQueryService.findAllFlights(
                new FlightBasicQuery(page)
        ));
    }

    @PatchMapping()
    public ResponseEntity<?> delay(@RequestBody UpdateFlightCommand updateFlightCommand){
        flightService.delay(updateFlightCommand);
        return ResponseEntity.ok("");
    }
}
