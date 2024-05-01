package io.group17.travelagencybooking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelPackagedto
{
    private String title;
    private String description;
    private double price;
    private int duration;
    private Destinationdto destinationdto;
}
