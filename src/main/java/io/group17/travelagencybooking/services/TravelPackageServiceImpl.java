package io.group17.travelagencybooking.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.repositories.TravelPackageRepository;
import io.group17.travelagencybooking.dtos.TravelPackagedto;
import io.group17.travelagencybooking.ExceptionHandler.TravelPackageException.ResourceNotFoundException;
import io.group17.travelagencybooking.utils.TravelPackageUtils;

@Service
public abstract class TravelPackageServiceImpl implements TravelPackageService {

    private TravelPackageRepository travelPackageRepository;

    @Override
    public List<TravelPackagedto> getAllTravelPackages() {
        List<TravelPackage> travelPackages = travelPackageRepository.findAll();
        return travelPackages.stream()
                .map(this::mapToTravelPackageDto)
                .collect(Collectors.toList());
    }

    @Override
    public TravelPackagedto getTravelPackageById(long id) {
        TravelPackage travelPackage = travelPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Travel package not found with id: " + id));
        return TravelPackageUtils.mapToTravelPackageDto(travelPackage);
    }

    @Override
    public TravelPackagedto createTravelPackage(TravelPackagedto travelPackage) {
        TravelPackage newTravelPackage = TravelPackageUtils.mapToTravelPackage(travelPackage);
        TravelPackage savedTravelPackage = travelPackageRepository.save(newTravelPackage);
        return TravelPackageUtils.mapToTravelPackageDto(savedTravelPackage);
    }

    @Override
    public TravelPackagedto updateTravelPackage(long id, TravelPackagedto updatedTravelPackage) {
        TravelPackage existingTravelPackage = travelPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Travel package not found with id: " + id));
        existingTravelPackage.setTitle(updatedTravelPackage.getTitle());
        existingTravelPackage.setDescription(updatedTravelPackage.getDescription());
        existingTravelPackage.setPrice(updatedTravelPackage.getPrice());
        existingTravelPackage.setDuration(updatedTravelPackage.getDuration());
        TravelPackage updatedPackage = travelPackageRepository.save(existingTravelPackage);
        return TravelPackageUtils.mapToTravelPackageDto(updatedPackage);
    }

    @Override
    public void deleteTravelPackage(long id) {
        TravelPackage travelPackage = travelPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Travel package not found with id: " + id));
        travelPackageRepository.delete(travelPackage);
    }

    private TravelPackagedto mapToTravelPackageDto(TravelPackage travelPackage) {
        return TravelPackageUtils.mapToTravelPackageDto(travelPackage);
    }
}
