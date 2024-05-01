package io.group17.travelagencybooking.services;

import java.util.List;
import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;

public interface DestinationService {
    List<Destination> getAllDestinations();
    Destination getDestinationById(long id);
    Destination createDestination(Destination destination);
    Destination updateDestination(long id, Destination updatedDestination);
    void deleteDestination(long id);
    List<TravelPackage> getAllTravelPackages(long id);
}