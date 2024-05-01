package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;

import io.group17.travelagencybooking.exceptions.DestinationException;
import io.group17.travelagencybooking.exceptions.DestinationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.repositories.DestinationRepository;

public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public List<Destination> getAllDestinations() {

        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(long id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if(optionalDestination.isEmpty()){
            throw new DestinationException.DestinationNotFoundException(id, "Destination with ID " + id + " not found");
        }
//        return optionalDestination.orElse(null);
        return optionalDestination.get();
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
}
