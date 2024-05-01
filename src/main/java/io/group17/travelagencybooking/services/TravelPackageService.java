package io.group17.travelagencybooking.services;

import io.group17.travelagencybooking.models.TravelPackage;
import java.util.List;

public interface TravelPackageService {
    List<TravelPackage> getAllTravelPackages();
    TravelPackage getTravelPackageById(long id);
    TravelPackage createTravelPackage(TravelPackage travelPackage);
    TravelPackage updateTravelPackage(long id, TravelPackage updatedTravelPackage);
    void deleteTravelPackage(long id);  
} 