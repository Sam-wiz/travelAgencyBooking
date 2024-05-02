package io.group17.travelagencybooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfTravelers;
    private Double totalCost;
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id") 
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "travel_package_id") 
    private TravelPackage travelPackage;
}
