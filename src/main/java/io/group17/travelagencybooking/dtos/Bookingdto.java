package io.group17.travelagencybooking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookingdto
{
    private Integer numberOfTravelers;
    private Double totalCost;
    private String bookingDate;
    private Customerdto customerdto;
    private TravelPackagedto travelPackagedto;
}
