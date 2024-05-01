package io.group17.travelagencybooking.utils;

import io.group17.travelagencybooking.dtos.Destinationdto;
import io.group17.travelagencybooking.models.Destination;

public class DestinationUtils {
    public static Destinationdto mapToDestinationDto(Destination destination) {
        Destinationdto destinationDto = new Destinationdto();
        destinationDto.setName(destination.getName());
        destinationDto.setLocationDescription(destination.getLocationDescription());
        destinationDto.setPopularAttractions(destination.getPopularAttractions());
        return destinationDto;
    }
}