package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;

import io.group17.travelagencybooking.dtos.Destinationdto;
import io.group17.travelagencybooking.exceptions.DestinationException;
import io.group17.travelagencybooking.exceptions.DestinationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.repositories.DestinationRepository;
import io.group17.travelagencybooking.repositories.TravelPackageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@Service
public class DestinationServiceImpl implements DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;
    private TravelPackageRepository travelPackageRepository;
    public DestinationServiceImpl(DestinationRepository destinationRepository, TravelPackageRepository travelPackageRepository){
        this.destinationRepository = destinationRepository;
        this.travelPackageRepository = travelPackageRepository;
    }

    @Override
    public List<Destination> getAllDestinations() {

        return destinationRepository.findAll();
    }

    @Override
    public Destination getDestinationById(long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new DestinationException.DestinationNotFoundException(id, "Destination with ID " + id + " not found"));
    }
    @Override
    public Destination createDestination(Destination destination) {
        // Add validation logic if needed
        return destinationRepository.save(destination);
    }
    @Override
    public Destination updateDestination(long id, Destination updatedDestination) {
        // Add update logic if needed
        throw new DestinationException.InvalidDestinationException("Update operation not supported yet");
    }
    public Destination createDestination(Destinationdto destinationDTO) {
        Destination destination = new Destination();
        destination.setName(destinationDTO.getName());
        destination.setLocationDescription(destinationDTO.getLocationDescription());
        destination.setPopularAttractions(destinationDTO.getPopularAttractions());
        return destinationRepository.save(destination);
    }
    public Destination updateDestination(long id, Destinationdto updatedDestinationDTO) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if (optionalDestination.isPresent()) {
            Destination destination = optionalDestination.get();
            destination.setName(updatedDestinationDTO.getName());
            destination.setLocationDescription(updatedDestinationDTO.getLocationDescription());
            destination.setPopularAttractions(updatedDestinationDTO.getPopularAttractions());
            return destinationRepository.save(destination);
        }
        return null;
    }

    @Override
    public void deleteDestination(long id) {
        destinationRepository.findById(id).ifPresentOrElse(
                destination -> destinationRepository.deleteById(id),
                () -> {
                    throw new DestinationException.DestinationNotFoundException(id, "Destination with ID " + id + " not found");
                }
        );
    }

    @Override
    public List<TravelPackage> getAllTravelPackages(long id) {
        return travelPackageRepository.findByDestinationId(id);
    }
}


