package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.repositories.DestinationRepository;
import io.group17.travelagencybooking.repositories.TravelPackageRepository;

public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;
    private TravelPackageRepository travelPackageRepository;

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(long id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        return optionalDestination.orElse(null);
    }

    @Override
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination updateDestination(long id, Destination updatedDestination) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if (optionalDestination.isPresent()) {
            Destination destination = optionalDestination.get();
            destination.setName(updatedDestination.getName());
            destination.setLocationDescription(updatedDestination.getLocationDescription());
            destination.setPopularAttractions(updatedDestination.getPopularAttractions());
            return destinationRepository.save(destination);
        }
        return null;
    }

    @Override
    public void deleteDestination(long id) {
        destinationRepository.deleteById(id);
    }

    @Override
    public List<TravelPackage> getAllTravelPackages(long id) {
        return travelPackageRepository.findByDestinationId(id); 
    }
           
}
