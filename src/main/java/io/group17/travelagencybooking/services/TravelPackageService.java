package io.group17.travelagencybooking.services;

import io.group17.travelagencybooking.dtos.TravelPackagedto;
import io.group17.travelagencybooking.models.TravelPackage;
import java.util.List;

public interface TravelPackageService {
    List<TravelPackagedto> getAllTravelPackages();
    TravelPackagedto getTravelPackageById(long id);
    TravelPackagedto createTravelPackage(TravelPackagedto travelPackage);
    TravelPackage updateTravelPackage(long id, TravelPackage updatedTravelPackage);

    TravelPackagedto updateTravelPackage(long id, TravelPackagedto updatedTravelPackage);

    void deleteTravelPackage(long id);

}