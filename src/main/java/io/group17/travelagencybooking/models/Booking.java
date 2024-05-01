package io.group17.travelagencybooking.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfTravelers;
    private Double totalCost;
    private String bookingDate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private TravelPackage travelPackage;
}
