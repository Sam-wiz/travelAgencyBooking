package io.group17.travelagencybooking.utils;

import io.group17.travelagencybooking.dtos.TravelPackagedto;
import io.group17.travelagencybooking.models.TravelPackage;

public class TravelPackageUtils
{
    public static TravelPackagedto mapToTravelPackageDto(TravelPackage travelPackage) {
        TravelPackagedto travelPackageDto = new TravelPackagedto();
        travelPackageDto.setTitle(travelPackage.getTitle());
        travelPackageDto.setDescription(travelPackage.getDescription());
        travelPackageDto.setPrice(travelPackage.getPrice());
        travelPackageDto.setDuration(travelPackage.getDuration());
        travelPackageDto.setDestinationdto(DestinationUtils.mapToDestinationDto(travelPackage.getDestination()));
        return travelPackageDto;
    }
}