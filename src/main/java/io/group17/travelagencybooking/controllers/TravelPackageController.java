package io.group17.travelagencybooking.controllers;

import io.group17.travelagencybooking.models.Destination;
import io.group17.travelagencybooking.models.TravelPackage;
import io.group17.travelagencybooking.services.TravelPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class TravelPackageController {

    private TravelPackageController travelPackageController;
    private TravelPackageService travelPackageService;

    //Create a travel package
    @PostMapping("")
    public ResponseEntity<TravelPackage> createTravelPackage(@RequestBody TravelPackage travelPackage){
        TravelPackage createdTravelPackage = travelPackageService.createTravelPackage(travelPackage);
        return new ResponseEntity<>(createdTravelPackage, HttpStatus.CREATED);
    }

    //
    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getTravelPackageById(Long id){
        TravelPackage travelPackage = travelPackageService.getTravelPackageById(id);
        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }
    //update an existing package
    @PutMapping("/{id}")
    public ResponseEntity<TravelPackage> updateTravelPackage(@PathVariable Long id, @RequestBody TravelPackage travelPackage) {
        TravelPackage updatedTravelPackage = travelPackageService.updateTravelPackage(id, travelPackage);
        return new ResponseEntity<>(updatedTravelPackage, HttpStatus.OK);
    }
    //Get all destinations
    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllTravelPackages(){
        List<TravelPackage> travelPackages = travelPackageService.getAllTravelPackages();
        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePackageById(@PathVariable Long id) {
        travelPackageService.deleteTravelPackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
