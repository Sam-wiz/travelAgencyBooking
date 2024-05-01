package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.repositories.TravelPackageRepository;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Override
    public List<TravelPackage> getAllTravelPackages() {
        return travelPackageRepository.findAll();
    }

    @Override
    public TravelPackage getTravelPackageById(long id) {
        Optional<TravelPackage> optionalTravelPackage = travelPackageRepository.findById(id);
        return optionalTravelPackage.orElse(null);
    }

    @Override
    public TravelPackage createTravelPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    @Override
    public TravelPackage updateTravelPackage(long id, TravelPackage updatedTravelPackage) {
        Optional<TravelPackage> optionalTravelPackage = travelPackageRepository.findById(id);
        if (optionalTravelPackage.isPresent()) {
            TravelPackage travelPackage = optionalTravelPackage.get();
            travelPackage.setTitle(updatedTravelPackage.getTitle());
            travelPackage.setDescription(updatedTravelPackage.getDescription());
            travelPackage.setPrice(updatedTravelPackage.getPrice());
            travelPackage.setDestination(updatedTravelPackage.getDestination());
            travelPackage.setDuration(updatedTravelPackage.getDuration());
            return travelPackageRepository.save(travelPackage);
        }
        return null;
    }

    @Override
    public void deleteTravelPackage(long id) {
        travelPackageRepository.deleteById(id);
    }
}
