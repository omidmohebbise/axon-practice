package org.omidmohebbise.axon.example1.query.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "flights_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private  String flightId;
    private  String destination;
    private  String source;
    private  ZonedDateTime departure;
    private  ZonedDateTime arrival;

    private Long duration;
    private LocalDateTime reservationDate;

    @Version
    private int version;

}
