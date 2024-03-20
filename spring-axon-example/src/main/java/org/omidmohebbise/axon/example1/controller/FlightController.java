package org.omidmohebbise.axon.example1.controller;

import lombok.RequiredArgsConstructor;
import org.omidmohebbise.axon.example1.query.FlightBasicQuery;
import org.omidmohebbise.axon.example1.query.service.FlightQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightQueryService flightQueryService;


    @GetMapping("/{page}")
    public ResponseEntity<?> findAllFlights(@PathVariable int page){
        return ResponseEntity.ok(flightQueryService.findAllFlights(
                new FlightBasicQuery(page)
        ));
    }
}
